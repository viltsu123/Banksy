<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="/resources/styles/common.css"/> -->
<title>Kaikki tapahtumat</title>
</head>
<body>
	<h3>Tämä sivu näyttää kaikki tapahtumat jotka on tehty
		Pankinkorteilla (admin näkymä)</h3>

	<c:forEach items="${tapahtumat}" var="k">
	<br>
	<div style="border-style: solid; border-width: 1px; background-color: #b0ea9a;">
		<table>
			<tr>
				<td>Korttinumero: <c:out value="${k.kortti_id}"></c:out></td>
			</tr>
			<tr>
				<td>Maksunsaaja: <c:out value="${k.maksunsaaja}"></c:out></td>
			</tr>
			<tr>
				<td>Päivämäärä: <c:out value="${k.pvm}"></c:out></td>
			</tr>
			<tr>
				<td>Euromäärä (veloitus): <c:out value="${k.hinta}"></c:out></td>
			</tr>
			<tr>
				<td>Viesti/Viite: <c:out value="${k.viesti}"></c:out></td>
			</tr>

		</table>
		</div>
		<!-- <p><c:out value="${k.kortti_id}, ${k.maksunsaaja}, ${k.pvm}, ${k.hinta}, ${k.viesti}"/></p> -->
	</c:forEach>
	<br>
	<br>
	<a href="uusi">Uusi asiakas?</a>
	<br>
	<br>
	<a href="koti">Etusivulle</a>

</body>
</html>