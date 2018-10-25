<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CSV Upload</title>
</head>
<body>
	<div align="center">
		 <h1>CSV Upload</h1>
		 <form action="upload" method="POST" enctype="multipart/form-data">
		 	<input type="file" name="file" accept=".csv"/> <br /><br />
		 	<button>Upload</button>
		 </form>
	</div>
</body>
</html>