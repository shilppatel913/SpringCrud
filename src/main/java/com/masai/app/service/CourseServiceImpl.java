package com.masai.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.entity.Course;
import com.masai.app.entity.Syllabus;
import com.masai.app.repository.CourseRepository;
import com.masai.app.repository.SyllabusRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private SyllabusRepository syllabusRepo;
	
	@Override
	public List<Course> createCourse(Course course) {
		this.courseRepo.save(course);
		return this.courseRepo.findAll();
	}

	@Override
	public List<Course> getAllCourses() {
		
		return this.courseRepo.findAll();
	}

	@Override
	public Course getOneCourse(int cid) {
		Optional<Course> optCourse=this.courseRepo.findById(cid);
		if(optCourse.isPresent()) {
			return optCourse.get();
		}else {
			return null;
		}
	}

	@Override
	public Course updateCourse(Course course) {
		Course cr=getOneCourse(course.getCid());
		if(cr!=null) {
			this.courseRepo.save(course);
			return course;
		}
		else {
			return null;
		}
	}

	@Override
	public Syllabus createSyllabus(Syllabus syllabus,int cid) {
		Course course=this.courseRepo.findById(cid).get();
		syllabus.setCourse(course);
		return this.syllabusRepo.save(syllabus);
	}

	@Override
	public Syllabus getSyllabus(int cid) {
		Course course=getOneCourse(cid);
		if(course!=null) {
			return course.getSyllabus();
		}
		else {
			return null;
		}
	}

}
