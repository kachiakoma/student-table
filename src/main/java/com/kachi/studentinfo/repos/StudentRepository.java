package com.kachi.studentinfo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kachi.studentinfo.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("from Student where (?1 is null or ?1='' or id_000=?1) and (?2 is null or ?2='' or student_000=?2) and"
			+ "(?3 is null or ?3='' or campus_000=?3) and (?4 is null or ?4='' or entry_date=?4) and "
			+ "(?5 is null or ?5='' or grade_level=?5) and (?6 is null or ?6='' or school_year=?6)")
	List<Student> findStudents(String id, String name, String campus, String date,
			String grade, String syear);
}
