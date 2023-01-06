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

import com.masai.app.entity.Student;
import com.masai.app.entity.StudentCourses;
import com.masai.app.service.StudentServiceImpl;

@RestController
@RequestMapping("/myapp/api")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/students")
	public ResponseEntity<?> createStud(@RequestBody Student student){
		List<Student> students=this.studentServiceImpl.createStudent(student);
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	/** To set which of the students have taken up which courses 
	 *  student_courses is the third table containing foreign keys of student table
	 *  and course table and implementing many to many relationship
	 */
	@PostMapping("/studentcourses")
	public ResponseEntity<?> createStudcourse(@RequestBody StudentCourses studentCourses){
		StudentCourses stdcrs=this.studentServiceImpl.createStdCrs(studentCourses);
		return ResponseEntity.ok(stdcrs);
	}
	
	@GetMapping("/students")
	public ResponseEntity<?> getAllStud(){
		List<Student> students=this.studentServiceImpl.getAllStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@PutMapping("/students")
	public ResponseEntity<?> updateStud(@RequestBody Student student){
		Student std=this.studentServiceImpl.updateStudent(student);
		if(std==null)
			throw new IllegalArgumentException("The entity must not exist");
		return ResponseEntity.ok(std);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<?> getStud(@PathVariable("id") int stuId){
		Student student=this.studentServiceImpl.getOneStudent(stuId);
		return ResponseEntity.ok(student);
	}
	
	
}
