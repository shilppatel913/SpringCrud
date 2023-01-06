package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
