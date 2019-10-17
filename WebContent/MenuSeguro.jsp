<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.10.2/css/all.css"
	integrity="sha384-rtJEYb85SiYWgfpCr0jn174XgJTn4rptSOQsMroFBPQSGLdOC5IbubP6lJ35qoM9"
	crossorigin="anonymous">
</head>


<body>
	<div class="container-fluid">
		<div class="row">
			<nav class="navbar navbar-light" style="background-color: #e3f2fd;">

				<div>
					<i class="fa fa-circle"></i> <a class="nav-brand">Seguro</a>
				</div>
				<div>
					<a class="nav-brand" href="#">Cadastrar</a>
				</div>
				<div>
					<a class="nav-brand" href="#">Buscar</a>
				</div>
				<div>
					<a class="nav-brand" href="#">Atualizar</a>
				</div>
				<div>
					<a class="nav-brand" href="/listarMenu.tiles">Listar</a>
				</div>
			</nav>
		</div>
		
		<div class = "row">
			<tiles:insertAttribute name="corpo" />
		</div>

	</div>
</body>

</html>