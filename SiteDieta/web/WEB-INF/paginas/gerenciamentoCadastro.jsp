<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<SCRIPT LANGUAGE="JavaScript">

function exibir(id) {
	var cadastroSelecionado = "#" + id;
	$(cadastroSelecionado).collapse('toggle');
}

function executar(opcaoEscolhida, cadastroEscolhido){
	var opcao = document.getElementById('opcao_escolhida').value;
	var cadastro = document.getElementById('cadastro_escolhido').value;
	
	console.log(opcao);
	console.log(cadastro);
}
</SCRIPT>
</head>

<body>
	<jsp:include page="../templates/barraSuperior.jsp" />

	<div class="row-fluid">
		<jsp:include page="../templates/menuLateralAdmin.jsp" />
		<div class="span6">
		<s:messages></s:messages>
		<s:errors></s:errors>
			<jsp:useBean id="web"
				class="com.site.web.BuscadorMedico" />
			<div class="accordion" id="accordion2">
				<c:forEach var="cadastro" items="${web.cadastrosPendentes}">
					<s:form beanclass="com.site.web.action.GerenciamentoCadastroAction"  method="post">
						<div class="control-group">
							<div class="controls">
								<div class="accordion-group">
									<div class="accordion-heading">
										<a onclick="exibir(${cadastro.id});"
											class=" label label-warning accordion-toggle"
											data-toggle="collapse" data-parent="#accordion2">
											<ul class="pull-right">
												<i id="icone1" id="menu1" class="icon-chevron-down icon-white"></i>
											</ul> 
											${cadastro.nomeMedico}
										</a>
									</div>
									<div id="${cadastro.id}" class="accordion-body collapse">
										<div class="accordion-inner">
											<table class="table">
												<tbody>
													<tr>
														<td>Nome: ${cadastro.nomeMedico}</td>
														<td>CPF: ${cadastro.cpfMedico}</td>
														<td></td>
													</tr>
													<tr>
														<td>Tipo de Registro: ${cadastro.tipoRegistroMedico}</td>
														<td>N&uacute;mero Profissional:
															${cadastro.numeroRegistroMedico}</td>
														<td></td>
													</tr>
													<tr>
														<td>Endere&ccedil;o: ${cadastro.enderecoConsultorio}</td>
														<td>N&uacute;mero: ${cadastro.numeroConsultorio}</td>
														<td>Bairro: ${cadastro.bairroConsultorio}</td>
													</tr>
													<tr>
														<td>Cidade: ${cadastro.cidadeConsultorio}</td>
														<td>Estado: ${cadastro.estadoConsultorio}</td>
														<td></td>
													</tr>
													<tr>
														<td>CNPJ: ${cadastro.cnpjConsultorio}</td>
														<td></td>
														<td></td>
													</tr>
												</tbody>
											</table>
											<p>
												<s:submit name="confirmar" value="confirmar" class="btn btn-success"/>
												<s:submit name="rejeitar" value="rejeitar" class="btn btn-danger"/>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<s:hidden name="cadastroEscolhido" value="${cadastro.id}"/>
					</s:form>
				</c:forEach>
			</div>
			<!-- /accordion -->
			
		</div>
		<!-- /span6 -->
	</div>
	<!-- /.row-fluid -->

</body>
</html>