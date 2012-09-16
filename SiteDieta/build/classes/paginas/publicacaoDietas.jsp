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
    	<li><s:submit name="salvar" value="Salvar"></s:submit></li>
	</ul>
<div class="tab-content">
<div class="tab-pane active" id="dietaManha">
<s:errors/>
<table>
<tr>
<td><label class="labelHorario">Hor&aacute;rio:</label></td>
<td><s:text id="horario" name="refeicao.horarioRefeicao" class="inputHorario" onkeyup="formatarHorario(this.id, 'manha'), verificaHoraManha()" maxlength="5" style="width:36px "/></td>
<td><input id="maisRefeicao" class="botaoMaisRefeicao"type="button" onclick="manipularRefeicaoOpcional('lbRefeicaoOpcional'), manipularCampos('btnMaisAlimento6', 'lbAlimento6', 'txAlimento6', 'lbQuantidade6', 'txQuantidade6', 'medidas6')" value="+" /></td>
<td><label class="labelRefeicao">Refei&ccedil;&atilde;o:</label></td>
</tr>
</table>

<table class="espacoSuperior">
<tr>
<td><input id="btnMaisAlimento1" class="botaoMaisAlimento" type="button" onclick="manipularCampos('btnMaisAlimento2', 'lbAlimento2', 'txAlimento2', 'lbQuantidade2', 'txQuantidade2', 'medidas2')" value="+"/></td>
<td><label class="labelAlimento">Alimento:</label></td>
<td><s:text id="txAlimento1"  name ="nomeAlimentos" class="inputAlimento"></s:text></td>
<td><label class="labelQuantidade" >Quantidade:</label></td>
<td><s:text id="quantidadePrimeiroAlimento" name="quantidade" class="inputQuantidade input-mini"/></td>
<td>
<s:select name="listaUnidadeDeMedida" class="comboMedidas">
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento2" class="botaoMaisAlimento" type="button" style="display: none" onclick="manipularCampos('btnMaisAlimento3', 'lbAlimento3', 'txAlimento3', 'lbQuantidade3', 'txQuantidade3', 'medidas3')" value="+"/></td>
<td><label id="lbAlimento2" class="labelAlimento" style="display: none" >Alimento:</label></td>
<td><input id="txAlimento2" name ="nomeAlimentos" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade2" class="labelQuantidade" style="display: none" >Quantidade:</label></td>
<td><s:text id="txQuantidade2" name="quantidade" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas2" name="listaUnidadeDeMedida"  class="comboMedidas" style="display: none" >
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento3" class="botaoMaisAlimento" style="display: none" type="button" onclick="manipularCampos('btnMaisAlimento4', 'lbAlimento4', 'txAlimento4', 'lbQuantidade4', 'txQuantidade4', 'medidas4')" value="+"/></td>
<td><label id="lbAlimento3" class="labelAlimento" style="display: none" >Alimento:</label></td>
<td><s:text id="txAlimento3" name ="nomeAlimentos" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade3" class="labelQuantidade" style="display: none" >Quantidade:</label></td>
<td><s:text id="txQuantidade3" name="quantidade" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas3" name="listaUnidadeDeMedida"  class="comboMedidas" style="display: none">
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento4"class="botaoMaisAlimento" type="button" onclick="manipularCamposSemBotao('lbAlimento5', 'txAlimento5', 'lbQuantidade5', 'txQuantidade5', 'medidas5')" value="+" style="display: none" /></td>
<td><label id="lbAlimento4" class="labelAlimento" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimento4" name ="nomeAlimentos" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade4" class="labelQuantidade" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidade4" name="quantidade" class="inputQuantidade input-mini"style="display: none" /></td>
<td>
<s:select id="medidas4" name="listaUnidadeDeMedida"  class="comboMedidas" style="display: none">
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>
</table>

<table>
<tr>
<td><label id="lbAlimento5" class="labelAlimentoSemBotao" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimento5" name ="nomeAlimentos" class="inputAlimentoSemBotao" style="display: none"/></td>
<td><label id="lbQuantidade5" class="labelQuantidadeSemBotao" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidade5" name="quantidade" class="inputQuantidadeSemBotao input-mini" style="display: none"/></td>
<td>
<s:select id="medidas5" name="listaUnidadeDeMedida"  class="comboMedidasSemBotao" style="display: none">
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>
</table>

<table>		
<tr>
<td><label id="lbRefeicaoOpcional" class="labelRefeicaoOpcional" style="display: none">Refei&ccedil;&atilde;o Opcional:</label></td>
</tr>
</table>
		
<table class="espacoSuperior">
<tr>
<td><input id="btnMaisAlimento6" class="botaoMaisAlimento" type="button" onclick="manipularCampos('btnMaisAlimento7', 'lbAlimento7', 'txAlimento7', 'lbQuantidade7', 'txQuantidade7', 'medidas7')" value="+" style="display: none"/></td>
<td><label id="lbAlimento6" class="labelAlimento" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimento6"  name="nomeAlimentos" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade6" class="labelQuantidade" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidade6" name="quantidade" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas6" name="listaUnidadeDeMedida" class="comboMedidas" style="display: none">
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento7" class="botaoMaisAlimento" type="button" onclick="manipularCampos('btnMaisAlimento8', 'lbAlimento8', 'txAlimento8', 'lbQuantidade8', 'txQuantidade8', 'medidas8')" value="+" style="display: none"/></td>
<td><label id="lbAlimento7" class="labelAlimento" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimento7" name ="nomeAlimentos" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade7" class="labelQuantidade" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidade7" name="quantidade" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas7" name="listaUnidadeDeMedida" class="comboMedidas" style="display: none">
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento8" class="botaoMaisAlimento" type="button" onclick="manipularCampos('btnMaisAlimento9', 'lbAlimento9', 'txAlimento9', 'lbQuantidade9', 'txQuantidade9', 'medidas9')" value="+" style="display: none"/></td>
<td><label id="lbAlimento8" class="labelAlimento" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimento8" name="nomeAlimentos" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade8" class="labelQuantidade" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidade8" name="quantidade" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas8" name="listaUnidadeDeMedida" class="comboMedidas" style="display: none">
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento9"class="botaoMaisAlimento" type="button" onclick="manipularCamposSemBotao('lbAlimento10', 'txAlimento10', 'lbQuantidade10', 'txQuantidade10', 'medidas10')" value="+" style="display: none"/></td>
<td><label id="lbAlimento9" class="labelAlimento" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimento9" name="nomeAlimentos" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidade9" class="labelQuantidade" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidade9" name="quantidade" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidas9" name="listaUnidadeDeMedida" class="comboMedidas" style="display: none">
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>
</table>

<table>
<tr>
<td><label id="lbAlimento10" class="labelAlimentoSemBotao" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimento10" name ="nomeAlimentos" class="inputAlimentoSemBotao" style="display: none"/></td>
<td><label id="lbQuantidade10" class="labelQuantidadeSemBotao" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidade10" name="quantidade" class="inputQuantidadeSemBotao input-mini" style="display: none"/></td>
<td>
<s:select id="medidas10" name="listaUnidadeDeMedida"  class="comboMedidasSemBotao" style="display: none">
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>
</table>

</div>
<!-- FIM DO TAB-PANE -->

	<div class="tab-pane" id="dietaTarde">
		<s:text name="teste"></s:text>
	</div>
	
	<div class="tab-pane" id="dietaNoite">
		<s:text name="outro"></s:text>
	</div>
	
</div>
<!-- FIM DO TAB-CONTENT  -->

</s:form>
</div>
		
		</div>
	</div>
</body>
</html>