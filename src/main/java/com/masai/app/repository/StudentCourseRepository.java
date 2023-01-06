package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.entity.StudentCourses;

public interface StudentCourseRepository extends JpaRepository<StudentCourses, Integer> {

}
