<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<!-- menu lateral INICIO -->
		<div class="span2">
			<div class="well sidebar-nav">
				<ul class="nav nav-list">
					<li class="nav-header">MENU</li>
					<jsp:useBean id="web" class="com.site.web.MenuUsuarioServlet"/>
					<c:forEach var="menu" items="${web.menuAdmin}">
					<li><a href=${menu.caminhoMenu}>${menu.nomeMenu}</a></li>
					</c:forEach>
				</ul>
			</div>
			<!--/.well -->
		</div>
		<!--/span3-->
	<!-- menu lateral FIM -->

</body>
</html>