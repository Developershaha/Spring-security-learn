package com.spriingboot.student_managment_system.repository;

import com.spriingboot.student_managment_system.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @EntityGraph(attributePaths = "roles")
    Optional<User> findByUsername(String username);
}
