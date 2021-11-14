package com.cafebabe.repository;

import com.cafebabe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
