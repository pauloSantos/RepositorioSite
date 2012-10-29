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

</head>
<body>

	<div class="navbar">
		<div class="navbar-inner">
			<div class="container">
				<a data-target=".nav-collapse" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="nav-collapse">
					<form action="" class="navbar-search pull-left">
							<ul class="nav">
								<input type="text" placeholder="Pesquisar"
									class="search-query span2">
								<input type="submit" value="Ir"
									class="btn-inverse search-query span1">
							</ul>
					</form>
					
					<c:if test="${empty sessionScope.usuario }">
					<ul class="nav pull-right">
								<s:form beanclass="com.site.web.action.AutenticadorAction" class="navbar-search pull-left" method="get">
									<span class= "label label-inverse">Login</span> 
									<s:text name ="login" maxlength="20" size="5" class="search-query span2"/> 
									<span class="label label-inverse">Senha</span> 
									<s:password name="senha" class="search-query span2"/> 
									<s:submit name="autenticar" value="Ok" class="btn-inverse search-query span1"/> 
									<a name="link_cadastro" href="goCadastro.do" class="search-query">Cadastre-se</a>
								</s:form>
							</ul>
					</c:if>
					
						<c:if test="${not empty sessionScope.usuario }">
								<div class="btn-group nav pull-right">
								<a class="btn btn-inverse" href="#"><i class="icon-user icon-white"></i> ${sessionScope.usuario.nomeUsuario}</a>
								<a class="btn btn-inverse dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
								<ul class="dropdown-menu">
            						<li><a href="/SiteDieta/usuario/logout"><i class="i"></i> Sair</a></li>
								</div>	
							</ul>					
						</c:if>
					
				</div>
				<!-- /.nav-collapse -->
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>

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
    		<li><a href="#dietaConcluidas" data-toggle="tab">Total dietas conclu&iacute;das</a></li>
	
		</ul>
		
		<div class="tab-content">
			<div class="tab-pane active" id="dietaConcluidas">
	
			</div>
	
			<div class="tab-pane" id="dietasPorGenero">
			
			<table>
			<tr>
				<td><div id="chart_downloads_genero"></div></td>
				<td><div id="chart_dietas_completas"></div></td>
			</tr>
			</table>
			</div>

	
	
			<div class="tab-pane" id="dietasPorIdade">
	
				Total de downloads X Idade
		
				Total Dietas Concluidas X Idade
		
			</div>
			</div>
		</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>