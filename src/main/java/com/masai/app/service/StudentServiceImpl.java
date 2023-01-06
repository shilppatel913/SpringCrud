package com.masai.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.entity.Course;
import com.masai.app.entity.Student;
import com.masai.app.entity.StudentCourses;
import com.masai.app.repository.CourseRepository;
import com.masai.app.repository.StudentCourseRepository;
import com.masai.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentCourseRepository studentCourseRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Student> createStudent(Student student) {
		this.studentRepository.save(student);
		return this.studentRepository.findAll();
	}

	@Override
	public List<Student> getAllStudents() {
		
		return this.studentRepository.findAll();
	}

	@Override
	public Student getOneStudent(int stuId) {
	Optional<Student> opStudent=	this.studentRepository.findById(stuId);
		if(opStudent.isPresent()) {
			Student student=opStudent.get();
			return student;
		}else {
			return null;
		}
	}

	@Override
	public Student updateStudent(Student student) {
		Student st=getOneStudent(student.getSr_no());
		if(st!=null) {
			this.studentRepository.save(student);
			return student;
		}
		else {
			return null;
		}
	
	}

	@Override
	public StudentCourses createStdCrs(StudentCourses studentCourses) {
		Student student= this.studentRepository.findById(studentCourses.getStudent().getSr_no()).get();
		Course course=this.courseRepository.findById(studentCourses.getCourse().getCid()).get();
		studentCourses.setCourse(course);
		studentCourses.setStudent(student);
		return this.studentCourseRepository.save(studentCourses);
	}
	
	

}
