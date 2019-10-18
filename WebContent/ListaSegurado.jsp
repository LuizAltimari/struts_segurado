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
	<h4 align="center" style="margin-top: 20px;">Lista de Segurados</h4>
	<table class="table"
		style="height: 100%; display: flex; align-items: center; justify-content: center; margin-top: 100px;">

		<tr>
			
			<th scope="col">Nome</th>
			<th scope="col">CPF</th>
			<th scope="col">RG</th>
			<th scope="col">Sexo</th>
			<th scope="col">Correntista</th>
			<th scope="col">Data de Nascimento</th>
			<th scope="col">Data de Cadastro</th>
			<th scope="col">Data de Alteração</th>						
			<th scope="col">Ações</th>
			
		</tr>

		<s:iterator value="lista">
			<tr>
				<td><s:property value="nome"></s:property></td>
				<td><s:property value="cpf"></s:property></td>
				<td><s:property value="rg"></s:property></td>
				<td><s:property value="sexo"></s:property></td>
				<td><s:property value="correntista"></s:property></td>
				<td><s:property value="dataNascimento"></s:property></td>
				<td><s:property value="dataCadastro"></s:property></td>
				<td><s:property value="dataAlteracao"></s:property></td>

				<s:url action="deleta-segurado" var="del">
					<s:param name="cpf" value="cpf"></s:param>
				</s:url>
								
				<s:url action="carrega-segurado" var="alt">
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