package com.kachi.studentinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kachi.studentinfo.models.Student;
import com.kachi.studentinfo.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentinfoApplicationTests {

//	@Test
//	public void contextLoads() {
//	}
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreateStudent() {
		Student student;
        student = new Student();

        student.setId_000(25676);
		student.setStudent_000("Belinda Guzman");
		student.setCampus_000((short) 105);
		student.setEntry_date("8/27/2018");
		student.setGrade_level((short) 4);
		student.setSchool_year((short) 2019);

        studentRepository.save(student);
	}

	@Test
	public void testFindStudentById() {
	    Student student = studentRepository.findById(25676).get();
	    System.out.println(student);

    }
	
	@Test
	public void testUpdateent() {
	    Student student = studentRepository.findById(25676).get();
	    student.setGrade_level((short) 8);
	    System.out.println(student);

    }

}
