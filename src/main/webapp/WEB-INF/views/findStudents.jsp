<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Search</title>
</head>
<body>
	<div align="center">
		<h1>Student Search</h1>
		<form action="find" method="POST">
			<label for="id">Id</label><br />
			<input type="text" id="id" value="${student.id_000}" name="id_000"/><br />
			
			<label for="name">Student Name</label><br />
			<input type="text" id="name" value="${student.student_000}" name="student_000"/><br />
			
			<label for="code">Campus Code</label><br />
			<input type="text" id="code" value="${student.campus_000}" name="campus_000"/><br />
			
			<label for="enroll">Enroll Date</label><br />
			<input type="date" id="enroll" value="${student.entry_date}" name="entry_date"/><br />
			
			<label for="level">Grade Level</label><br />
			<input type="text" id="level" value="${student.grade_level}" name="grade_level"/><br />
			
			<label for="year">School Year</label><br />
			<input type="text" id="year" value="${student.school_year}" name="school_year"/><br />
			<button>Find</button>
		</form>
		<br />
		<a href="/students">View Students Table</a>	
		<br />
		<a href="/">Homepage</a>
	</div>
</body>
</html>