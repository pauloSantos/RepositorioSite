<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Minhas Dietas</title>
</head>
<body>
	<jsp:include page="../templates/barraSuperior.jsp" />

	<div class="row-fluid">
		<jsp:include page="../templates/menuLateralMedico.jsp" />
		<div class="span6">
		<center>
			<a class="btn" href="/SiteDieta/action/publicacao/dieta">Publicar Dieta</a>
		</center>	
		</div>
	</div>
</body>
</html>