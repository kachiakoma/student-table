<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Table</title>
</head>
<body>
	<div align="center">
		<h1>Student Table</h1>
		<table style="text-align: center;">
			<thead>
				<tr>
					<td>ID</td>
					<td>Student</td>
					<td>Campus</td>
					<td>Entry</td>
					<td>Grade</td>
					<td>Year</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
				<tr>
					<td><a href="/students/${student.id_000}/edit">${student.id_000}</a></td>
					<td>${student.student_000}</td>
					<td>${student.campus_000}</td>
					<td>${student.entry_date}</td>
					<td>${student.grade_level}</td>
					<td>${student.school_year}</td>
					<td><a href="students/${student.id_000}/delete">X</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<a href="/">Homepage</a>
	</div>
</body>
</html>