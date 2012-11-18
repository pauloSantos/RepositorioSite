<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/SiteDieta/static/css/publicacaoDietas.css" rel="stylesheet">
<script src="/SiteDieta/static/js/publicacaoDieta.js"></script>
<title>Publicar Dieta</title>

</head>
<body>
		<jsp:include page="../templates/barraSuperior.jsp" />

	<div class="row-fluid">
	<jsp:include page="../templates/menuLateralMedico.jsp"/>
	<div class="span9">
<div class="tabbable">	
<s:form beanclass="com.site.web.action.PublicacaoDietaAction">
	<ul class="nav nav-tabs">
    	<li class="active"><a href="#dietaManha" data-toggle="tab">Manh&atilde;</a></li>
    	<li><a href="#dietaTarde" data-toggle="tab">Tarde</a></li>
    	<li><a href="#dietaNoite" data-toggle="tab">Noite</a></li>
	</ul>
<s:messages></s:messages>
<s:errors/>
<div class="hero-unit">	
<label class="label espacoSuperior" style="margin-top: -31px;margin-bottom: 30px;">Detalhes da dieta</label>
<table>	
<tr>
<td><label class="label " style= "margin-right:5px" >Nome :</label></td>
<td><s:text id="nomeDieta" name="dieta.nomeDieta" ></s:text></td>	
<td><label class="label" style="margin-right:5px;margin-left:300px;" >Dura&ccedil;&atilde;o:</label></td>
<td><s:text id="duracaoDieta" name="dieta.periodoDieta" style="margin-right:100px;" class="input-mini"></s:text></td>
</tr>
</table>
<hr>
<div class="tab-content">
<div class="tab-pane active" id="dietaManha">
<label class="label espacoSuperior" style="margin-top: 15px;">Refei&ccedil;&otilde;es da manh&atilde;</label>
<table>
<tr>
<td><label style="margin-right:5px;" class="espacoSuperior labelHorario label ">Hor&aacute;rio:</label></td>
<td><s:text id="horarioManha" name="horarioRefeicaoManha" class="espacoSuperior inputHorario input-mini" onkeyup="formatarHorario(this.id, 'manha'), verificaHoraManha()" maxlength="5" style="width:36px "/></td>
<td>
<label id="maisRefeicao" class="label botaoMaisRefeicao espacoSuperior">
<i class="icon-plus icon-white" onclick="manipularRefeicaoOpcional('lbRefeicaoOpcional', 'Manha')"></i>
</label>
</td>
<td><label style="margin-right:5px;" class="espacoSuperior labelRefeicao label ">Refei&ccedil;&atilde;o:</label></td>
</tr>
</table>

<table class="espacoSuperior">
<tr>
<td>
<label id="btnMaisAlimento1" class="label botaoMaisAlimento">
<i  class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimento2', 'lbAlimento2', 'txAlimento2', 'lbQuantidade2', 'txQuantidade2', 'medidas2')" ></i>
</label>
</td>
<td><label id="lbAlimento1" style="margin-right:5px;" class="labelAlimento label ">Alimento:</label></td>
<td><s:text id="txAlimento1"  name ="nomeAlimentos.alimentoManha1" class="inputAlimento"></s:text></td>
<td><label id="lbQuantidade1" style="margin-right:5px" class="labelQuantidade label" >Quantidade:</label></td>
<td><s:text id="txQuantidade1" name="quantidade.alimentoManha1" class="inputQuantidade input-mini"/></td>
<td>
<s:select id="medidas1" name="listaUnidadeDeMedida.alimentoManha1" class="comboMedidas">
  <option></option>
  <option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimento2" class="label botaoMaisAlimento" style="display: none">
<i  class="icon-plus icon-white"  onclick="manipularCampos('btnMaisAlimento3', 'lbAlimento3', 'txAlimento3', 'lbQuantidade3', 'txQuantidade3', 'medidas3')"></i>
</label>
</td>
<td><label id="lbAlimento2" class="labelAlimento label " style="display: none;margin-right:5px" >Alimento:</label></td>
<td><input id="txAlimento2" name ="nomeAlimentos.alimentoManha2" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade2" class="labelQuantidade label" style="display: none;margin-right:5px" >Quantidade:</label></td>
<td><s:text id="txQuantidade2" name="quantidade.alimentoManha2" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas2" name="listaUnidadeDeMedida.alimentoManha2"  class="comboMedidas" style="display: none" >
  <option></option>
   <option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimento3" class=" label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimento4', 'lbAlimento4', 'txAlimento4', 'lbQuantidade4', 'txQuantidade4', 'medidas4')" ></i>
</label>
</td>
<td><label id="lbAlimento3" class="labelAlimento label " style="display: none;margin-right:5px" >Alimento:</label></td>
<td><s:text id="txAlimento3" name ="nomeAlimentos.alimentoManha3" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade3" class="labelQuantidade label" style="display: none; margin-right:5px" >Quantidade:</label></td>
<td><s:text id="txQuantidade3" name="quantidade.alimentoManha3" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas3" name="listaUnidadeDeMedida.alimentoManha3"  class="comboMedidas" style="display: none">
  <option></option>
 <option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimento4" class=" label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white"onclick="manipularCamposSemBotao('lbAlimento5', 'txAlimento5', 'lbQuantidade5', 'txQuantidade5', 'medidas5')"></i>
</label>
</td>
<td><label id="lbAlimento4" class="labelAlimento label " style="display: none; margin-right:5px">Alimento:</label></td>
<td><s:text id="txAlimento4" name ="nomeAlimentos.alimentoManha4" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade4" class="labelQuantidade label" style="display: none; margin-right:5px;">Quantidade:</label></td>
<td><s:text id="txQuantidade4" name="quantidade.alimentoManha4" class="inputQuantidade input-mini"style="display: none" /></td>
<td>
<s:select id="medidas4" name="listaUnidadeDeMedida.alimentoManha4"  class="comboMedidas" style="display: none">
  <option></option>
   <option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>
</table>

<table>
<tr>
<td><label id="lbAlimento5" class="labelAlimentoSemBotao label " style="display: none; margin-right:5px">Alimento:</label></td>
<td><s:text id="txAlimento5" name ="nomeAlimentos.alimentoManha5" class="inputAlimentoSemBotao" style="display: none"/></td>
<td><label id="lbQuantidade5" class="labelQuantidadeSemBotao label" style="display: none; margin-right:5px">Quantidade:</label></td>
<td><s:text id="txQuantidade5" name="quantidade.alimentoManha5" class="inputQuantidadeSemBotao input-mini" style="display: none"/></td>
<td>
<s:select id="medidas5" name="listaUnidadeDeMedida.alimentoManha5"  class="comboMedidasSemBotao" style="display: none">
  <option></option>
   <option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>
</table>

<table>		
<tr>
<td><label id="lbRefeicaoOpcional" class="labelRefeicaoOpcional label " style="display: none; margin-right:5px">Refei&ccedil;&atilde;o Opcional:</label></td>
</tr>
</table>
		
<table class="espacoSuperior">
<tr>
<td>
<label id="btnMaisAlimento6" class=" label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimento7', 'lbAlimento7', 'txAlimento7', 'lbQuantidade7', 'txQuantidade7', 'medidas7')"></i>
</label>
</td>
<td><label id="lbAlimento6" class="labelAlimento label " style="display: none; margin-right:5px">Alimento:</label></td>
<td><s:text id="txAlimento6"  name="nomeAlimentos.alimentoOpcionalManha6" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade6" class="labelQuantidade label" style="display: none; margin-right:5px">Quantidade:</label></td>
<td><s:text id="txQuantidade6" name="quantidade.alimentoOpcionalManha6" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas6" name="listaUnidadeDeMedida.alimentoOpcionalManha6" class="comboMedidas" style="display: none">
  <option></option>
<option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimento7" class=" label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimento8', 'lbAlimento8', 'txAlimento8', 'lbQuantidade8', 'txQuantidade8', 'medidas8')"></i>
</label>
</td>
<td><label id="lbAlimento7" class="labelAlimento label " style="display: none; margin-right:5px">Alimento:</label></td>
<td><s:text id="txAlimento7" name ="nomeAlimentos.alimentoOpcionalManha7" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade7" class="labelQuantidade label" style="display: none; margin-right:5px">Quantidade:</label></td>
<td><s:text id="txQuantidade7" name="quantidade.alimentoOpcionalManha7" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas7" name="listaUnidadeDeMedida.alimentoOpcionalManha7" class="comboMedidas" style="display: none">
  <option></option>
<option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimento8" class=" label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimento9', 'lbAlimento9', 'txAlimento9', 'lbQuantidade9', 'txQuantidade9', 'medidas9')"></i>
</label>
</td>
<td><label id="lbAlimento8" class="labelAlimento label " style="display: none; margin-right:5px">Alimento:</label></td>
<td><s:text id="txAlimento8" name="nomeAlimentos.alimentoOpcionalManha8" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade8" class="labelQuantidade label" style="display: none; margin-right:5px">Quantidade:</label></td>
<td><s:text id="txQuantidade8" name="quantidade.alimentoOpcionalManha8" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas8" name="listaUnidadeDeMedida.alimentoOpcionalManha8" class="comboMedidas" style="display: none">
  <option></option>
<option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimento9" class=" label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCamposSemBotao('lbAlimento10', 'txAlimento10', 'lbQuantidade10', 'txQuantidade10', 'medidas10')"></i>
</label>
</td>
<td><label id="lbAlimento9" class="labelAlimento label " style="display: none; margin-right:5px">Alimento:</label></td>
<td><s:text id="txAlimento9" name="nomeAlimentos.alimentoOpcionalManha9" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade9" class="labelQuantidade label" style="display: none; margin-right:5px">Quantidade:</label></td>
<td><s:text id="txQuantidade9" name="quantidade.alimentoOpcionalManha9" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas9" name="listaUnidadeDeMedida.alimentoOpcionalManha9" class="comboMedidas" style="display: none">
  <option></option>
<option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>
</table>

<table>
<tr>
<td><label id="lbAlimento10" class="labelAlimentoSemBotao label " style="display: none; margin-right:5px">Alimento:</label></td>
<td><s:text id="txAlimento10" name ="nomeAlimentos.alimentoOpcionalManha10" class="inputAlimentoSemBotao" style="display: none"/></td>
<td><label id="lbQuantidade10" class="labelQuantidadeSemBotao label" style="display: none; margin-right:5px">Quantidade:</label></td>
<td><s:text id="txQuantidade10" name="quantidade.alimentoOpcionalManha10" class="inputQuantidadeSemBotao input-mini" style="display: none"/></td>
<td>
<s:select id="medidas10" name="listaUnidadeDeMedida.alimentoOpcionalManha10"  class="comboMedidasSemBotao" style="display: none">
  <option></option>
<option>unidade</option>
  <option>ml</option>
  <option>gramas</option>
  <option>x&iacute;cara</option>
  <option>colher (sopa)</option>
  <option>colher (sobremesa)</option>
  <option>fatia</option>
</s:select>
</td>
</tr>
</table>

</div>
<!-- FIM DO TAB-PANE -->

	<div class="tab-pane" id="dietaTarde">
	<label class="label espacoSuperior" style="margin-top: 15px;">Refei&ccedil;&otilde;es da tarde</label>
		<jsp:include page="alimentosTarde.jsp" />
	</div>
	
	<div class="tab-pane" id="dietaNoite">
	<label class="label espacoSuperior" style="margin-top: 15px;">Refei&ccedil;&otilde;es da noite</label>
		<jsp:include page="alimentosNoite.jsp" />
	</div>
	
</div>
<!-- FIM DO TAB-CONTENT  -->
</div>
<s:submit name="salvar" class="pull-right label " style="margin-top: 50px;margin-right: 72px;height: 29px;width: 60px;" value="Salvar"></s:submit>
</s:form>
</div>
		
		</div>
	</div>
</body>
</html>