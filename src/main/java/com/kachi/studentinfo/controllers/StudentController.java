package com.kachi.studentinfo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.kachi.studentinfo.models.Student;
import com.kachi.studentinfo.repos.StudentRepository;
import com.kachi.studentinfo.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService service;
	@Autowired
	StudentRepository repo;
	
	//	Index
	@RequestMapping(method = RequestMethod.GET)
	public String showStudents(ModelMap map) {
		List<Student> students = service.getAllStudents();
		map.addAttribute("students", students);
		return "students";
	}
	//	New
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addStudentPage() {
		return "addStudent";
	}
	//	Create
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public RedirectView addStudent(@ModelAttribute("student") Student student, ModelMap map) throws ParseException {
		
		if(student != null) {
			if(!student.getEntry_date().equals("")) {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(student.getEntry_date());
				student.setEntry_date(new SimpleDateFormat("MM/dd/yyyy").format(date));
			}
			
			Student saveStudent = service.saveStudent(student);
			String msg = "Student Table Updated At Id: " + saveStudent.getId_000();
			map.addAttribute("msg", msg);
		}
		RedirectView view = new RedirectView();
		view.setUrl("/students");
		return view;
	}
	//	Edit
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editStudent(@PathVariable("id") int id, ModelMap map) throws ParseException {
		Optional<Student> student = service.getStudentById(id);
		if(student.isPresent()) {
			map.addAttribute("student", student.get());
			Date newdate = new SimpleDateFormat("MM/dd/yyyy").parse(student.get().getEntry_date());
			student.get().setEntry_date(new SimpleDateFormat("yyyy-MM-dd").format(newdate));
		}
		return "editStudent";
	}
	//	Delete
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public RedirectView deleteStudent(@PathVariable("id") int id, ModelMap map) {
		service.deleteStudent(service.getStudentById(id).get());
		List<Student> students = service.getAllStudents();
		map.addAttribute("students", students);
		RedirectView view = new RedirectView();
		view.setUrl("/students");
		return view;
	}
	//	Find Page
	@RequestMapping(value ="/find", method = RequestMethod.GET)
	public String searchStudents() {
		return "findStudents";
	}
	//	Find
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String findStudents(@RequestParam(value="id_000", required=false) String id, @RequestParam(value="student_000", required=false) String name,
			@RequestParam(value="campus_000", required=false) String campus, @RequestParam(value="entry_date", required=false) String date,
			@RequestParam(value="grade_level", required=false) String level, @RequestParam(value="school_year", required=false) String syear,
			ModelMap map) throws ParseException {
		if(!date.equals("")) {
			Date newdate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			date = new SimpleDateFormat("MM/dd/yyyy").format(newdate);
		}	
		
		List<Student> students = repo.findStudents(id, name, campus, date, level, syear);
		map.addAttribute("students", students);
		return "findStudentsResults";
	}
	//	Star Route
	@RequestMapping(value = "/*")
	public String catchAll() {
		return "students";
	}	
}
