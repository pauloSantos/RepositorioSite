<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Cadastro </title>
</head>
<body>
<jsp:include page="../templates/barraSuperior.jsp"/>

		<div class="row-fluid">
		<jsp:include page="../templates/menuLateralGeral.jsp"/>
		<div class="span6">
			<div>
				<form  action="registrar.do" method="post" class="well span12">
					<label class="label label-info">Dados Pessoais</label>
					<label>*Nome:</label>
					<input name="nome_medico"type="text" class="span8">
					<label>*CPF:</label>
					<input name="cpf_medico" type="text" class="input-medium" maxlength="11">
					<label>*N&uacute;mero Registro Profissional:</label>
					<input name="registro_medico" type="text" class="input-medium">
					<label>*Tipo de Registro:</label>
					<select name="tipo_identificacao" class="span2">
					<option></option>
					<option>CRM</option>
					<option>CRN</option>
					</select>
					<hr>
					<label class="label label-info">Login</label>
					<label>*Login:</label>
					<input name="login_medico"type="text" class="span8">
					<label>*Senha:</label>
					<input name="senha_medico" type="password" class="input-medium">
					<label>*Confirmar Senha:</label>
					<input name="confirmacao_senha" type="password" class="input-medium">
					<hr>
					<label class="label label-info">Dados do Consult&oacute;rio</label>
					<label>Endere&ccedil;o:</label>
					<input name="endereco_clinica" type="text" class="span8">
					<label>N&uacute;mero:</label>
					<input name="numero_clinica" type="text" class="input-mini">
					<label>Bairro:</label>
					<input name="bairro_clinica" type="text" class="input-medium">
					<label>Cidade:</label>
					<input name="cidade_clinica" type="text" class="input-medium">
					<label>Estado:</label>
					<input name="estado_clinica" type="text" maxlength="2" class="input-mini">
					<label>CNPJ:</label>
					<input name="cnpj_clinica" type="text" maxlength="15" class="input-medium">
					<br></br>
					<center>
						<input id="fat-btn" type="submit" value="Salvar" data-loading-text="salvando..." class="btn btn-info">
						<a  id="fat-btn" href="goHome.do" data-loading-text="cancelando..." class="btn btn-info">Cancelar</a>
					</center>	
				</form>
					<footer class="label label-info nav pull-right">* Campos obrigat&oacute;rios</footer>
			</div>
		</div>
		<!--/span6-->
		<div class="well alert alert-info span3">
			<strong>Aten��o!</strong>
			"Preencha os campos obrigat&oacute;rios!"
		</div>
		<!--/span3-->
	</div>
	<!-- /.row-fluid -->

</body>
</html>