package com.example.spring3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring3.model.Student;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

@Service
public class StudentService {

	@Autowired
	private ObservationRegistry observationRegistry;
	
	List<Student> studentList = new ArrayList<>();

	public Student addStudent(Student student) {
		studentList.add(student);
//		return student;
		return Observation.createNotStarted("studentadded", observationRegistry)
				          .observe(() -> student);
	}

	public List<Student> getAllStudents() {
//		return studentList;
		return Observation.createNotStarted("students", observationRegistry)
		          .observe(() -> studentList);
}
	

	public Student getStudent(String id) {
//		return studentList.stream()
//				           .filter(student -> student.id().equals(id))
//				           .findFirst()
//				           .orElseThrow(() -> new RuntimeException("Student not found."));
		
		return Observation.createNotStarted("student", observationRegistry)
		          .observe(() -> getStudentById(id));
	}

	
	private Student getStudentById(String id) {
		return studentList.stream()
		           .filter(student -> student.id().equals(id))
		           .findFirst()
		           .orElseThrow(() -> new RuntimeException("Student not found."));
	}

	
	
}
