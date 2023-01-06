package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
