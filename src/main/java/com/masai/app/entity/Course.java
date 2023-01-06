package com.masai.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
	@JsonIgnore
	private List<StudentCourses> student_courses=new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy="course")
	@JsonIgnore
	private Syllabus syllabus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher teacher;
	

}
