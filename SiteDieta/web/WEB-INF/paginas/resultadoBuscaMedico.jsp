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
		<c:forEach var="dieta" items="${actionBean.dietas}">
	
		<div class="accordion" id="accordion2">
		<div class="control-group">
		<div class="controls">
		<div class="accordion-group">
		<div class="accordion-heading">
		<a href="" onclick="exibir('${dieta.id}')" class=" label label-info accordion-toggle"  data-toggle="collapse" data-parent="#accordion2"> 
		<ul class="pull-right">
		<i id="icone1" id="menu1" class="icon-chevron-down icon-white"></i>
		</ul>
			${dieta.nomeDieta}
		</a>
		</div>
		<div id="${dieta.id}" class="accordion-body collapse">
					<table class="table">
												<tbody>
													<tr>
														<td>M&eacute;dico: ${dieta.medico.nomeMedico}</td>
														<td>CPF: ${dieta.medico.cpfMedico}</td>
														<td></td>
													</tr>
													<tr>
														<td>Tipo de Registro: ${dieta.medico.tipoRegistroMedico}</td>
														<td>Numero Profissional:
															${dieta.medico.numeroRegistroMedico}</td>
														<td></td>
													</tr>
													<tr>
														<td>Endere&ccedil;o: ${dieta.medico.enderecoConsultorio}</td>
														<td>Numero: ${dieta.medico.numeroConsultorio}</td>
														<td>Bairro: ${dieta.medico.bairroConsultorio}</td>
													</tr>
													<tr>
														<td>Cidade: ${dieta.medico.cidadeConsultorio}</td>
														<td>Estado: ${dieta.medico.estadoConsultorio}</td>
														<td></td>
													</tr>
													<tr>
														<td>CNPJ: ${dieta.medico.cnpjConsultorio}</td>
														<td></td>
														<td></td>
													</tr>
												</tbody>
											</table>
		</div>
		</div>
		</div>
		</div>
		</div>
									
			
		</c:forEach>
		</div>
	</div>
</body>
</html>