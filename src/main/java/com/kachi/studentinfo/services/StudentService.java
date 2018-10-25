package com.kachi.studentinfo.services;

import java.util.List;
import java.util.Optional;

import com.kachi.studentinfo.models.Student;

public interface StudentService {
	Student saveStudent(Student student);
	Student updateStudent(Student student);
	void deleteStudent(Student student);
	Optional<Student> getStudentById(int id);
	List<Student> getAllStudents();
}
