package com.masai.app.service;

import java.util.List;

import com.masai.app.entity.Course;
import com.masai.app.entity.Syllabus;

public interface CourseService {

	public List<Course> createCourse(Course course);
	public List<Course> getAllCourses();
	public Course getOneCourse(int cid);
	public Course updateCourse(Course course);
	public Syllabus createSyllabus(Syllabus syllabus,int cid);
	public Syllabus getSyllabus(int cid);
}
