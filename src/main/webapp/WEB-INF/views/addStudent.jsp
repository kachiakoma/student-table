<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<div align="center">
		<h1>Add Student</h1>
		<form action="/students/new" method="POST">
			<label for="id">Id</label><br />
			<input type="text" id="id" name="id_000"/><br />
			
			<label for="name">Student Name</label><br />
			<input type="text" id="name" name="student_000"/><br />
			
			<label for="code">Campus Code</label><br />
			<input type="text" id="code" name="campus_000"/><br />
			
			<label for="enroll">Enroll Date</label><br />
			<input type="date" id="enroll" placeholder="MM/DD/YYYY" name="entry_date"/><br />
			
			<label for="level">Grade Level</label><br />
			<input type="text" id="level" name="grade_level"/><br />
			
			<label for="year">School Year</label><br />
			<input type="text" id="year" placeholder="YYYY" name="school_year"/><br />
			<button>Add</button>
		</form>
		<br />
		${msg}
		<br />
		<a href="/students">View Students Table</a>	
		<br />
		<a href="/">Homepage</a>	
	</div>
</body>
</html>