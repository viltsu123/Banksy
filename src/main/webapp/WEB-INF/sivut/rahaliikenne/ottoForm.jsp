<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nostotapahtuma</title>
</head>
<body>

<form:form action="nosto" modelAttribute="otto" method="post">
		  	<fieldset>		
				<legend>Nostatko Rahaa?</legend>
				<p>
					<form:label	path="saldo">paljon nostat?</form:label><br/>
					<form:input path="saldo" />		
				</p>
				<p>
					<form:label	path="kortti_id">korttinumerosi</form:label><br/>
					<form:input path="kortti_id" value="${param.korttiId}"/>	
				</p>
				<p>	
					<button type="submit">Nosta</button>
					<br>
					<br>
					<a href="hae">Kantaan</a>
					<br>
					<br>
					<a href="koti">Etusivulle</a>
				</p>
			</fieldset>
		</form:form>

</body>
</html>