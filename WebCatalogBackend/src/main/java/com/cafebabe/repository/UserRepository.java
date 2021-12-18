package com.cafebabe.repository;

import com.cafebabe.entity.User;
import com.cafebabe.security.ERole;
import com.cafebabe.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findAllByEmailLikeAndRolesContains(String email, Role role);

    List<User> findAllByNameLikeAndSurnameLike(String name, String surname);

//    @Query(nativeQuery = true, value = "select * from User u where u.email like ''")
//    List<User> find()
}
