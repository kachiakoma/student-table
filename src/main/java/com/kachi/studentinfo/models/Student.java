package com.kachi.studentinfo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studenttab")
public class Student {

    @Id
    private int id_000;
	private String student_000;
    private short campus_000;
    private String entry_date;
    private short grade_level;
    private short school_year;
    
	public int getId_000() {
		return id_000;
	}
	public void setId_000(int id_000) {
		this.id_000 = id_000;
	}
	public String getStudent_000() {
		return student_000;
	}
	public void setStudent_000(String student_000) {
		this.student_000 = student_000;
	}
	public short getCampus_000() {
		return campus_000;
	}
	public void setCampus_000(short campus_000) {
		this.campus_000 = campus_000;
	}
	public String getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}
	public short getGrade_level() {
		return grade_level;
	}
	public void setGrade_level(short grade_level) {
		this.grade_level = grade_level;
	}
	public short getSchool_year() {
		return school_year;
	}
	public void setSchool_year(short school_year) {
		this.school_year = school_year;
	}
	
	@Override
	public String toString() {
		return "Student [id_000=" + id_000 + ", student_000=" + student_000 + ", campus_000=" + campus_000
				+ ", entry_date=" + entry_date + ", grade_level=" + grade_level + ", school_year=" + school_year + "]";
	}
    
	
}
