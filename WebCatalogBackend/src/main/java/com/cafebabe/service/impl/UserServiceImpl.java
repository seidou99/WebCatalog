package com.cafebabe.service.impl;

import com.cafebabe.entity.User;
import com.cafebabe.entity.User_;
import com.cafebabe.repository.UserRepository;
import com.cafebabe.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected EntityManager entityManager;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User create(RegistrationRequest registrationRequest) {
        Role role = roleRepository.findByName(ERole.USER.getName()).get();
        User user = new User(registrationRequest.getEmail(), registrationRequest.getName(), registrationRequest.getSurname(), passwordEncoder.encode(registrationRequest.getPassword()), Collections.singletonList(role));
        return save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteById(BigInteger id) {
        userRepository.deleteById(id);
    }

    public List<User> findByEmailAndRole(String email, ERole role) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Predicate emailPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get(User_.email)), "%" + email.toLowerCase() + "%");
        ListJoin<User, Role> join = root.join(User_.roles);
        Path<String> roleNamePath = join.get(Role_.name);
        Predicate roleNamePredicate = criteriaBuilder.equal(roleNamePath, role.getName());
        query.where(emailPredicate, roleNamePredicate);
        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public List<User> findByNameAndSurnameAndRole(String name, String surname, ERole role) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        ListJoin<User, Role> userToRoleJoin = root.join(User_.roles);
        Path<String> roleNamePath = userToRoleJoin.get(Role_.name);
        List<Predicate> predicates = new ArrayList<>();
        Predicate roleNamePredicate = criteriaBuilder.equal(roleNamePath, role.getName());
        predicates.add(roleNamePredicate);
        if (name != null && !name.isEmpty()) {
            Predicate userNamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get(User_.name)), "%" + name + "%");
            predicates.add(userNamePredicate);
        }
        if (surname != null && !surname.isEmpty()) {
            Predicate userSurnamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get(User_.surname)), "%" + surname.toLowerCase() + "%");
            predicates.add(userSurnamePredicate);
        }
        query.where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(query).getResultList();
    }

    public List<User> findByNameLikeAndSurnameLike(String name, String surname) {
        return userRepository.findAllByNameLikeAndSurnameLike(name, surname);
    }


}
