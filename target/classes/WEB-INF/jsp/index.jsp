<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Haber si la cargo</title>
</head>
<body>
	<h1> Crud Sencillo</h1>
	<c:url var="agregar" value="/agregarActualizar"></c:url>
	<form:form action="${agregar}" modelAttribute="rol">

		<c:if test="${ !empty rol.description}">
			<form:label path="idRol">
				<spring:message text="ID ROL" />
			</form:label>
			<form:input path="idRol" readonly="true" disabled="true" />
			<form:hidden path="idRol" />
		</c:if>
		<form:label path="description"> <spring:message text="Descripcion"/></form:label>
		<form:input path="description"/>
		<br><br>
		<c:if test="${!empty rol.description }">
			<input type="submit" value="Modificar">
		</c:if>
		<c:if test="${empty rol.description}">
			<input type="submit" value="Guardar">
		</c:if>
	</form:form>
	
	<br>
	<h2>Lista de Roles</h2>
	<c:if test="${!empty listaRol }">
		<table border="solid">
			<tr>
				<th> IdRol</th>
				<th> Descripcion</th>
				<th> Modificar</th>
				<th>Eliminar</th>
			</tr>
			<c:forEach var="lista" items="${listaRol }">
				<tr>
					<td>${lista.idRol}</td>
					<td>${lista.description}</td>
					<td><a href=" <c:url value='/editarRol/${lista.idRol}'/>" >Editar</a></td>
					<td><a href=" <c:url value='/borrar/${lista.idRol}'/>">Eliminar</a></td>
				</tr>
			</c:forEach>
			<tr>
			</tr>
		</table>	
	</c:if>
	
</body>
</html>