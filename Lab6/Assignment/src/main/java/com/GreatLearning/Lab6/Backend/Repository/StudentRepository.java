package com.GreatLearning.Lab6.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GreatLearning.Lab6.Backend.Entity.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {

}
