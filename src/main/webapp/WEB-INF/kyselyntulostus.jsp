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
	table{
		background-color: rgb(242,242,242);
		border-collapse: collapse;
	}
	td,th{
		padding-left: 10px;
		padding-right: 10px;
		text-align: left;
		padding-top: 10px;
		border-style: solid;
  		border-color: black;
	}
	tr {
    	
	}
	#vastlink{
		padding: 5px;
		background-color: rgb(242,242,242);
	}

</style>
</head>
<body>
<h1>RAW DATA:</h1>
<br>
<table>
	<th>ID</th><th>NICKNAME</th><th>HOURS PLAYED</th><th>PROGRESS</th><th>FAVORITE BOSS</th>
	<th>M+ SCORE</th><th>PLAYS PVP</th><th>REMOVED CLASS</th><th>REASONING</th><th>HYPED FOR NEXT EXPAC</th>
	
	<c:forEach items="${vastaukset}" var="vastaukset">
		<tr>
			<td><c:out value="${vastaukset.id}"></c:out></td>
			<td><c:out value="${vastaukset.nickname}"></c:out></td>
			<td><c:out value="${vastaukset.hoursplayed}"></c:out></td>
			<td><c:out value="${vastaukset.progressnum}"></c:out>/11 <c:out value="${vastaukset.progressdiff}"></c:out></td>
			<td><c:out value="${vastaukset.favboss}"></c:out></td>
			<td><c:out value="${vastaukset.mplus}"></c:out></td>
			<td><c:out value="${vastaukset.playpvp}"></c:out></td>
			<td><c:out value="${vastaukset.removeclass}"></c:out></td>
			<td><c:out value="${vastaukset.whyremove}"></c:out></td>
			<td><c:out value="${vastaukset.expachype}"></c:out></td>
			<td><a href="/deleterow?id=${vastaukset.id}">delete</a></td>
		</tr>
	</c:forEach>

</table>
<br>
<br>
<a href="/vastaukset" id="vastlink">VASTAUKSIIN</a>
</body>
</html>