package com.database.database.repository;

import com.database.database.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<student, String>{
    List<student> findAll();
    Optional<student> findById(String id);

}