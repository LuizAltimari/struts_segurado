<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
	<s:form action ="altera-seguro">
		
		<s:textfield cssClass="form-control" name="seguro" size="20"
			placeholder="Nome do Seguro" label="Seguro" />
		<s:textfield cssClass="form-control" name="valor" size="20"
			placeholder="Valor do Seguro" label="Valor(R$)" />
		<s:hidden name="id" value="%{id}"></s:hidden>
		<div class="form-group">
			
			<s:submit cssClass="btn btn-primary btn-block"
				label="Gravar" align="center"/>
		</div>
	</s:form>
</body>
</html>