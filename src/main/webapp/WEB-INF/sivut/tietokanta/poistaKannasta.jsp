<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Poista kannasta</title>
</head>
<body>
	<form:form modelAttribute="dummy" method="post">
		<fieldset>
			<legend>Poista käyttäjä:</legend>
			<p>
				<form:label path="kortti_id">Korttinumero</form:label>
				<br />
				<form:input path="kortti_id" value="${param.korttiIdx }"/>

			</p>
			<p>
				<button type="submit">Poista</button>
				
				<br> <br> 
				<a href="hae">Kannassa just nyt</a> 
				<br> <br>
				<a href="id">Hae id perusteella kortillisia</a> 
				
			</p>
		</fieldset>
	</form:form>
</body>
</html>