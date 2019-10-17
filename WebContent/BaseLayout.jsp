<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/menu.css"
	media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div class="container-fluid">


		<div class="row">

			<div class="col-xl-12" align="center"
				style="background-color: #1E90FF;">
				<tiles:insertAttribute name="header" />
			</div>
		</div>
		<div class="row">
			<div class="col-lg-1" align="center">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="col-lg-11" >
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
</body>
</html>