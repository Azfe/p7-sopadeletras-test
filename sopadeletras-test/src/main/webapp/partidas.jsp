<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.sopadeletras.mvc.model.DatosPartida" %>
<%
String msg="mensaje";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />    
    <title>Partidas</title>
</head>
<body>
	<table border="1">
		<caption>Titulo de la tabla</caption>
		<tr>
			<th>ID</th>
			<th>Usuario</th>
			<th>Fecha</th>
			<th>Puntos</th>
			<th>Tiempo</th>
		</tr>
		<%= msg %>
	</table>
	<button onclick="location.href='../EnriqueVergara'">Volver</button>
</body>
</html>