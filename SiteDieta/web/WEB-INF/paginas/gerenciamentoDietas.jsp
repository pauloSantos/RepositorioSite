<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Minhas Dietas</title>

<SCRIPT LANGUAGE="JavaScript">

function exibir(id) {
	var cadastroSelecionado = "#" + id;
	$(cadastroSelecionado).collapse('toggle');
}

</SCRIPT>
</head>
<body>
	<jsp:include page="../templates/barraSuperior.jsp" />

	<div class="row-fluid">
		<jsp:include page="../templates/menuLateralMedico.jsp" />
		<div class="span6">
		<a class="btn pull-right" href="/SiteDieta/action/publicacao/dieta">Publicar Dieta</a>
			

	</div>
	
	<div class="span6">
	
		<jsp:useBean id="gerenciador" class="com.site.web.action.GerenciadorDietasAction" />
		<div class="accordion" id="accordion2">
		<s:form beanclass="com.site.web.action.GerenciadorDietasAction" method="get">
		<div class="control-group">
		<div class="controls">
		<div class="accordion-group">
		<div class="accordion-heading">
		<a href="" onclick="exibir('minhasDietas')" class=" label label-info accordion-toggle"  data-toggle="collapse" data-parent="#accordion2"> 
		<ul class="pull-right">
		<i id="icone1" id="menu1" class="icon-chevron-down icon-white"></i>
		</ul>
			Minhas Dietas
		</a>
		</div>
		<div id="minhasDietas" class="accordion-body collapse">
		<table class="table">
		<tbody>
		<c:forEach var="dieta" items="${actionBean.dieta}">
		<tr class="info">
			<td>
			<label>${dieta.nomeDieta}</label>
			</td>
			
			<td>
			<label>Dura&ccedil;&atilde;o: ${dieta.periodoDieta} dias</label> 
			</td>
		</tr>	
		</c:forEach>
		</tbody>
		</table>
		</div>
		</div>
		</div>
		</div>
		</s:form>
		</div>
									
			
		</div>
	</div>
</body>
</html>