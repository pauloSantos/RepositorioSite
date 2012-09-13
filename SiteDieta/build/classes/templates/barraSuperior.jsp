<%@page
	import="java.util.*,com.site.web.AutenticacaoLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="/SiteDieta/static/css/bootstrap.css" rel="stylesheet">
<link href="/SiteDieta/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/SiteDieta/static/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/SiteDieta/static/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="/SiteDieta/static/css/prettify.css" rel="stylesheet">

<link rel="shortcut icon" href="static/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="/SiteDieta/static/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="/SiteDieta/static/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" 	 href="/SiteDieta/static/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="/SiteDieta/static/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>
	<!-- menu header INICIO -->
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
								<form method="post" class="navbar-search pull-left" action="Autenticacao.do">
									<span class="label label-inverse">Login</span> 
									<input name ="campo_login" type="text" maxlength="20" size="5" class="search-query span2"> 
									<span class="label label-inverse">Senha</span> 
									<input name="campo_senha" type="password" class="search-query span2"> 
									<input type="submit"	value="Ok" class="btn-inverse search-query span1"> 
									<a name="link_cadastro" href="goCadastro.do" class="search-query">Cadastre-se</a>
								</form>
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
	<!-- menu header FIM -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="/SiteDieta/static/js/jquery.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-transition.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-alert.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-modal.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-dropdown.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-scrollspy.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-tab.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-tooltip.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-popover.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-button.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-collapse.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-carousel.js"></script>
	<script src="/SiteDieta/static/js/bootstrap-typeahead.js"></script>
	<script src="/SiteDieta/static/js/application.js"></script>
	<script src="/SiteDieta/static/js/publicacaoDieta.js"></script>
    
</body>
</html>
