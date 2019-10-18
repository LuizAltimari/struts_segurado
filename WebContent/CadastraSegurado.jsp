<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h5 align ="center">Cadastro de Segurado</h5>
	
	<div class="card mx-auto mt-5">
		<s:form action ="cadastra-segurado">
		<s:textfield cssClass="form-control" name="nome" size="20"
			placeholder="Nome do Segurado" label="Nome" />
			
		<s:textfield cssClass="form-control" name="cpf" size="20"
			placeholder="Somente números" label="CPF" />
			
		<s:textfield cssClass="form-control" name="rg" size="20"
			placeholder="Somente números" label="RG" />
			
		<s:textfield cssClass="form-control" name="sexo" size="20"
			placeholder="Sexo" label="Sexo" />
		
		<s:textfield cssClass="form-control" name="correntista" size="20"
			placeholder="Sim/Não" label="Correntista?" />
		
		<s:textfield cssClass="form-control date-mask" name="dataNascimento" size="20"
			placeholder="dd/MM/aaaa" label="Data de Nascimento" />	
			
		<s:checkboxlist list="seguros" label="Seguros" name=""> </s:checkboxlist>	
		
		<div class="form-group">
		
		

			<s:submit cssClass="btn btn-primary btn-block"
				label="Gravar" align="center" method="cadastrar"/>
		</div>
	</s:form>
	</div>	
</body>
</html>