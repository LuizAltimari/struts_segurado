<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h5 align="center">Cadastro de Segurado</h5>

	<div style="height: 100%; display: flex; align-items: center; justify-content: center; margin-top: 50px;">
		<s:form action="cadastra-segurado">
		<s:textfield cssClass="form-control" name="nome" size="20"
			placeholder="Nome do Segurado" label="Nome" />

		<s:textfield cssClass="form-control" name="cpf" size="20"
			placeholder="Somente números" label="CPF" />

		<s:textfield cssClass="form-control" name="rg" size="20"
			placeholder="Somente números" label="RG" />

		<div class = "form-group">
			<s:radio label= "Sexo" name="sexo" list="#{'Feminino': 'Feminino', 'Masculino': 'Masculino'}"></s:radio>	
		</div>			
		
		<div class="form group">
			<s:select label="Correntista? " name="correntista" list= "#{'true': 'Sim', 'false': 'Não' }"> </s:select>
		</div>		

		<s:textfield cssClass="form-control" name="dataNascimento" size="20"
			placeholder="dd/MM/aaaa" label="Data de Nascimento" />

		<s:checkboxlist list="listaSeguros" label="Seguros" name="">
		</s:checkboxlist>
		
		<s:checkboxlist list="dias" label="Dias de Visita" name="">
		</s:checkboxlist>

		<div class="form-group">

			<s:submit cssClass="btn btn-primary btn-block" label="Gravar"
				align="center" method="cadastrar" />
		</div>
	</s:form>
		
	</div>	
</body>
</html>