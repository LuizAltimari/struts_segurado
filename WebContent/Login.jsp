<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="pt-br">
<head>
<title>Login | Ebix.com</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.10.2/css/all.css"
	integrity="sha384-rtJEYb85SiYWgfpCr0jn174XgJTn4rptSOQsMroFBPQSGLdOC5IbubP6lJ35qoM9"
	crossorigin="anonymous">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

	<div class="container mt-5" >
		<div class="row">
			<div class="col-sm-5 mx-auto">
				<div class="card mx-auto">
					<div>
						<h4 class="text-center">
							<i class="fa fa-filter"></i> Sistema de Gerenciamento de
							Segurados | Login
						</h4>
					</div>
					<div class="dropdown-divider"></div>
					<article class="card-body mx-auto">
						<s:form action="login.action" method="post">

							<div class="form-group" align="center">
								<s:textfield cssClass="form-control" name="login.usuario" size="20"
									placeholder="Usuário" key="label.usuario" />
							</div>
							<!-- form-group// -->

							<div class="form-group" align="center">
								<s:password name="login.senha" cssClass="form-control" size="20"
									placeholder="Senha" key="label.senha" />
							</div>
							<!-- form-group// -->

							<!-- form-group// -->
							<div class="form-group">

								<s:submit cssClass="btn btn-primary btn-block" method="execute"
									key="label.login" align="center" />
							</div>
							<!-- form-group// -->
						</s:form>
					</article>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


<!--<s:actionerror />
			<s:form action="login.action" method="post">
				<s:textfield name="usuario" key="label.usuario" size="20" />
				<s:password name="senha" key="label.senha" size="20" />
				<s:submit method="execute" key="label.login" align="center" />
			</s:form>-->