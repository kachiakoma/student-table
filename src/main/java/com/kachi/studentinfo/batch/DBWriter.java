package com.kachi.studentinfo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.kachi.studentinfo.models.Student;
import com.kachi.studentinfo.repos.StudentRepository;

@Component
public class DBWriter implements ItemWriter<Student>{
	
	@Autowired
	private StudentRepository repository;
	
	@Override
	public void write(List<? extends Student> students) throws Exception {
		
		for(Student student : students) {
			repository.save(student);
		}		
	}
	

}

