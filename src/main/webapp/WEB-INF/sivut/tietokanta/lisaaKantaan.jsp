<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uusi Kortinhaltija</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>
<body>

	<h1>
		Luo Uusi Asiakkuus:
	</h1>
		<form:form modelAttribute="kortti" method="post">
		  	<fieldset>		
				<legend>Henkilön tiedot</legend>
				
				<spring:hasBindErrors name="kortti">
					<p class="Virheotsikko"><spring:message code="henk.create.errors" />:</p>
					<div class="Virheblokki"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
				<p>
					<form:label	path="etunimi">Etunimi</form:label><br/>
					<form:input path="etunimi" cssErrorClass="VirheellinenKentta"/><form:errors path="etunimi" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<form:label path="sukunimi">Sukunimi</form:label><br/>
					<form:input path="sukunimi" cssErrorClass="VirheellinenKentta"/><form:errors path="sukunimi" cssClass="Virheteksti"/>
				</p>
				<p>	
					<button type="submit">Lisää</button>
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