package com.masai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.app.entity.Student;
import com.masai.app.entity.StudentCourses;

import jakarta.servlet.annotation.WebServlet;

@Service
public interface StudentService {
	
	public List<Student> createStudent(Student student);
	public List<Student> getAllStudents();
	public Student getOneStudent(int stuId);
	public Student updateStudent(Student student);
	public StudentCourses createStdCrs(StudentCourses studentCourses);
	

}
