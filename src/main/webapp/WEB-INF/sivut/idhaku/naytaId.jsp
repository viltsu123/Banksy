<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Haun tulos</title>
</head>

<body>

	<h3>Etsimäsi henkilö:</h3>
	<c:set var="kortti_id" scope="session" value="${tyyppi.kortti_id}" />
	<c:if test="${kortti_id != null}">
		<table>
			<tr>
				<td>Etunimi:</td>
				<td><c:out value="${tyyppi.etunimi}" /></td>
			</tr>
			<tr>
				<td>Sukunimi:</td>
				<td><c:out value="${tyyppi.sukunimi}" /></td>
			</tr>
			<tr>
				<td>Kortinnumero:</td>
				<td><c:out value="${tyyppi.kortti_id}" /></td>
			</tr>
		</table>
	</c:if>

	<c:set var="tyhja" scope="session" value="${tyyppi.kortti_id }" />
	<c:if test="${tyhja == null}">
		<p>Hakemaasi id:tä ei löytynyt!</p>
	</c:if>

	<br>
	<br>
	<a href="tapahtuma">Näytä henkilön kortintapahtumat</a>
	<br>
	<br>
	<a href="hae">Kannassa just nyt</a>
	<br>
	<br>
	<a href="id">Hae id perusteella kortillisia</a>
	<br>
	<br>
	<a href="haetapahtumat">Kaikki Pankintapahtumat</a>
	<br>
	<br>
	<a href="koti">Etusivulle</a>
</body>
</html>