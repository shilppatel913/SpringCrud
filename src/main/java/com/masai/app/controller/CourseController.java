package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.entity.Course;
import com.masai.app.entity.Student;
import com.masai.app.entity.Syllabus;
import com.masai.app.entity.Teacher;
import com.masai.app.repository.TeacherRepository;
import com.masai.app.service.CourseServiceImpl;
import com.masai.app.service.StudentServiceImpl;

@RestController
@RequestMapping("/myapp/api")
public class CourseController {

	@Autowired
	private CourseServiceImpl courseServiceImpl;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@PostMapping("/courses")
	public ResponseEntity<?> createCour(@RequestBody Course course){
		int tid=course.getTeacher().getTid();
		Teacher teacher=this.teacherRepository.findById(tid).get();
		course.setTeacher(teacher);
		List<Course> courses=this.courseServiceImpl.createCourse(course);
		return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<?> getAllCour(){
		List<Course> courses=this.courseServiceImpl.getAllCourses();
		return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
	}
	
	@PutMapping("/courses")
	public ResponseEntity<?> updateCours(@RequestBody Course course){
		int tid=course.getTeacher().getTid();
		Teacher teacher=this.teacherRepository.findById(tid).get();
		course.setTeacher(teacher);
		System.out.println("Inside course update");
		Course c=this.courseServiceImpl.updateCourse(course);
		if(c==null)
			throw new IllegalArgumentException("The course must not be present");
		return ResponseEntity.ok(c);
	}
	
	@PostMapping("/course/{id}/syllabus")
	public ResponseEntity<?> createSyllforcCourse(@PathVariable("id") int cid,
			@RequestBody Syllabus syllabus){
		Syllabus syll=this.courseServiceImpl.createSyllabus(syllabus,cid);
		return ResponseEntity.ok(syll);
	}
	
	@GetMapping("/course/{id}/syllabus")
	public ResponseEntity<?> getSyllForCourse(@PathVariable("id") int cid){
		Syllabus syllabus=this.courseServiceImpl.getSyllabus(cid);
		return ResponseEntity.ok(syllabus);
	}
	
}
