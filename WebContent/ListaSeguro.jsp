<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.10.2/css/all.css"
	integrity="sha384-rtJEYb85SiYWgfpCr0jn174XgJTn4rptSOQsMroFBPQSGLdOC5IbubP6lJ35qoM9"
	crossorigin="anonymous">

</head>
<body>
	<h4 align="center" style="margin-top: 20px;">Lista de Seguros</h4>
	<table class="table"
		style="height: 100%; display: flex; align-items: center; justify-content: center; margin-top: 100px;">

		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nome</th>
			<th scope="col">Valor (R$)</th>
			<th scope="col">Ações</th>
		</tr>

		<s:iterator value="lista">
			<tr>
				<td><s:property value="id"></s:property></td>
				<td><s:property value="seguro"></s:property></td>
				<td><s:property value="valor"></s:property></td>

				<s:url action="deleta-seguro" var="del">
					<s:param name="id" value="id"></s:param>
				</s:url>
								
				<s:url action="carrega-seguro" var="alt">
					<s:param name="id" value="id"></s:param>
				</s:url>
				
				<td>
					<a class="btn btn-danger " href="<s:property value="del"/>"><i class="fa fa-trash text-white"></i></a>
					<a class="btn btn-primary " href="<s:property value="alt"/>"><i class="fa fa-paint-brush text-white"></i></a>
				</td>
			</tr>
		</s:iterator>

	</table>
</body>
</html>