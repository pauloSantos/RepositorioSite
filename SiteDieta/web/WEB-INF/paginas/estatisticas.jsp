<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estatisticas</title>
<jsp:include page ="/WEB-INF/templates/util.jsp"/>

    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript" src="/SiteDieta/static/js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="/SiteDieta/static/js/downloadsPorGenero.js"></script>
    <script type="text/javascript" src="/SiteDieta/static/js/porcentagemDietasFinalizadas.js"></script>
    <script type="text/javascript" src="/SiteDieta/static/js/estatisticas/downloadsPorIdade.js"></script>
    <script type="text/javascript" src="/SiteDieta/static/js/estatisticas/dietasFinalizadasPorIdade.js"></script>

</head>
<body>

	<jsp:include page="../templates/barraSuperior.jsp" />

	<div class="row-fluid">
	
	<jsp:include page="/WEB-INF/templates/menu.jsp"></jsp:include>
	
	<div class="span9">
	<ul class="nav nav-tabs">
	<li class="active"><a href="#downloads" data-toggle="tab">Downloads</a></li>
	</ul>
	
	<div class="tab-content">
			<div class="tab-pane active" id="downloads">
			
		
		<div class="span12">
		<ul class="nav nav-tabs">
    		<li class="active"><a href="#dietasPorGenero" data-toggle="tab">Por g&ecirc;nero</a></li>
    		<li><a href="#dietasPorIdade" data-toggle="tab">Por idade</a></li>
	
		</ul>
		
		<div class="tab-content">
			<div class="tab-pane" id="dietasPorGenero">
			
			<table>
			<tr>
				<td><div id="chart_downloads_genero"></div></td>
				<td><div id="chart_finalizadas_genero"></div></td>
			</tr>
			</table>
			</div>

	
	
			<div class="tab-pane" id="dietasPorIdade">
	
			<table>
			<tr>
				<td><div id="chart_downloads_idade"></div></td>
				<td><div id="chart_finalizadas_idade"></div></td>
			</tr>
			</table>
			</div>
			</div>
		</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>