<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERRO NO CADASTRO</title>
</head>
<body>
<jsp:include page="../templates/barraSuperior.jsp"></jsp:include>
<jsp:include page="../templates/menuLateralGeral.jsp"></jsp:include>
	
	<center>
		<div class="alert alert-error span12" >
			<button class="close" data-dismiss="alert">x</button>
			<strong>Atenção!!!</strong>
			"Usuario ou senha incorretos, por favor tente novamente"
		</div>
	</center>
</body>
</html>