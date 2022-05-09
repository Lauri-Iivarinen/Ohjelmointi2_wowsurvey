<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results page</title>
<style>
	body{
		background-color: rgb(162, 191, 207, 80%);
	}
	form{
		margin-top: 20%;
		text-align: center;
	}

</style>
</head>
<body>
<form action="/topsecretresultspage" method="post">
<p><c:out value="${viesti}"></c:out></p>
<label>Password: </label><input type="password" name="password"/><br>
<br>
<input type="submit" value="enter"/>
</form>

</body>
</html>