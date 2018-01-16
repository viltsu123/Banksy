<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pankinasiakkaat</title>
</head>
<body>
	<h1>Tietokannassa:</h1>
	
	<c:forEach items="${kortit}" var="k">
	<c:set var="korttinro" scope="session" value="${k.kortti_id }"/>
		<div
			style="border-style: solid; border-width: 1px; background-color: yellow;">
			
			<table>
				<tr>
					<td>Etunimi:</td>
					<td><c:out value="${k.etunimi}" /></td>
				</tr>
				<tr>
					<td>Sukunimi:</td>
					<td><c:out value="${k.sukunimi}" /></td>
				</tr>
				<tr>
					<td>Saldo:</td>
					<td><c:out value="${k.saldo}" /></td>
				</tr>
				<tr>
					<td>Kortinnumero:</td>
					<td><c:out value="${k.kortti_id}" /></td>
				</tr>
				
				<tr>
					<td><button>
							<a href="nosto?korttiId=<c:out value="${k.kortti_id}"/>">otto(alpha)</a>
						</button>
						<button>
							<a href="talletus?korttiIdp=<c:out value="${k.kortti_id}"/>">Pano(alpha)</a>
						</button>
						<button>
							<a href="poisto?korttiIdx=<c:out value="${k.kortti_id}"/>">Lopeta asiakkuus</a>
						</button>
					</td>
				</tr>
			</table>
			
		</div>
		<br>
	</c:forEach>
	<a href="id">Hae id perusteella kortillisia</a>
	<br>
	<br>
	<a href="uusi">Uusi asiakas?</a>
	<br>
	<br>
	<a href="koti">Etusivulle</a>
</body>
</html>