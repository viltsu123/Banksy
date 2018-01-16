<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hae tiettyä asiakasta</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>
<body>
<h3>Syötä hakemasi id kantaan niin katsotaan löytyykö:</h3>
<form:form modelAttribute="id" method="post">
	<fieldset>
		<legend>Henkilö id jota haet:</legend>
		
		<spring:hasBindErrors name="kortti">
					<p class="Virheotsikko"><spring:message code="henk.create.errors" />:</p>
					<div class="Virheblokki"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
			<p>
				<form:label path="id" value=""></form:label><br>
				<form:input path="id" cssErrorClass="VirheellinenKentta"/><form:errors path="id" cssClass="Virheteksti"/>	
			</p>
			<p>
				<button type="submit">Etsi</button>
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