<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="/pwcheck" method="post">
<label>Password: </label><input type="password" name="password"/><br>
<br>
<input type="submit" value="enter"/>
</form>

</body>
</html>