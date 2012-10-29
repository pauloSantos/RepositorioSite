<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<c:if test="${empty sessionScope.usuario }">
	<jsp:include page="../templates/menuLateralGeral.jsp"/>
	</c:if>
	
	<c:if test="${sessionScope.usuario.tipoUsuario.value =='medico' }">
	<jsp:include page="../templates/menuLateralMedico.jsp"/>
	</c:if>
	
	
	<c:if test="${sessionScope.usuario.tipoUsuario.value =='admin' }">
	<jsp:include page="../templates/menuLateralAdmin.jsp"/>
	</c:if>
	
</html>