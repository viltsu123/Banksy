<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tapahtumat Kortillesi</title>
</head>
<body>
	<h3>Tapahtumat kortillesi</h3>
	<c:set var="tapa" scope="session" value="${tapahtumat.size()}" />
	<c:choose>
		<c:when test="${tapa > 0}">

			<c:forEach items="${tapahtumat}" var="k">


				<div
					style="border-style: solid; border-width: 1px; background-color: yellow;">
					<table>
						<tr>
							<td>Kortinnumero:</td>
							<td><c:out value="${k.kortti_id}" /></td>
						</tr>
						<tr>
							<td>Maksunsaaja:</td>
							<td><c:out value="${k.maksunsaaja}" /></td>
						</tr>
						<tr>
							<td>Maksupäivä:</td>
							<td><c:out value="${k.pvm}" /></td>
						</tr>
						<tr>
							<td>Euro hinta:</td>
							<td><c:out value="${k.hinta}" /></td>
						</tr>
						<tr>
							<td>Viesti:</td>
							<td><c:out value="${k.viesti}" /></td>
						</tr>
					</table>
				</div>
				<br>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>Ei tapahtumia haetulle kortille!</p>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<a href="tapahtuma">Hae lisää korttitapahtumia</a>
	<br>
	<br>
	<a href="id">Hae id perusteella kortillisia</a>
	<br>
	<br>
	<a href="hae">Kannassa just nyt</a>
	<br>
	<br>
	<a href="koti">Etusivulle</a>

</body>
</html>