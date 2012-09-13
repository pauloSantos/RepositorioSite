<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/SiteDieta/static/css/publicacaoDietas.css" rel="stylesheet">

<title>Publicar Dieta</title>

<script>
function displayDate(id)
{
var i = document.getElementById("campo1");
var b = document.getElementById(id);
if(i.type=="text"){
i.type="hidden";
b.value="+";
}else{
i.type="text";
b.value="-";
}

}
</script>

</head>
<body>
		<jsp:include page="../templates/barraSuperior.jsp" />

	<div class="row-fluid">
	<jsp:include page="../templates/menuLateralMedico.jsp"/>
	<div class="span9">
		<s:form beanclass="com.site.web.action.PublicacaoDieta">
		
<table>
<tr>
<td><input id="maisHorario" class="botaoMaisHorario" type="button" onclick="" value="+"/></td>
<td><label class="labelHorario">Hor&aacute;rio:</label></td>
<td><input id="horario" class="inputHorario" type="text" onkeyup="formatarHorario(this.value), verificaHoraManha()" maxlength="5" style="width:36px "/></td>
<td><input id="maisRefeicao" class="botaoMaisRefeicao"type="button" onclick="" value="+" /></td>
<td><label class="labelRefeicao">Refei&ccedil;&atilde;o:</label></td>
</table>
</tr>

<table class="espacoSuperior">
<tr>
<td><input id="btnMaisAlimento1" class="botaoMaisAlimento" type="button" onclick="manipularCampos('btnMaisAlimento2', 'lbAlimento2', 'txAlimento2', 'lbQuantidade2', 'txQuantidade2', 'medidas2')" value="+"/></td>
<td><label class="labelAlimento">Alimento:</label></td>
<td><input id="primeiroAlimento"  class="inputAlimento" type="text"/></td>
<td><label class="labelQuantidade" >Quantidade:</label></td>
<td><input id="quantidadePrimeiroAlimento" class="inputQuantidade input-mini" type="text"/></td>
<td>
<select class="comboMedidas">
  <option>ml</option>
  <option>gramas</option>
</select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento2" class="botaoMaisAlimento" type="button" style="display: none" onclick="manipularCampos('btnMaisAlimento3', 'lbAlimento3', 'txAlimento3', 'lbQuantidade3', 'txQuantidade3', 'medidas3')" value="+"/></td>
<td><label id="lbAlimento2" class="labelAlimento" style="display: none" >Alimento:</label></td>
<td><input id="txAlimento2" class="inputAlimento" style="display: none" type="text"/></td>
<td><label id="lbQuantidade2" class="labelQuantidade" style="display: none" >Quantidade:</label></td>
<td><input id="txQuantidade2" class="inputQuantidade input-mini" type="text" style="display: none"/></td>
<td>
<select id="medidas2"class="comboMedidas" style="display: none" >
  <option>ml</option>
  <option>gramas</option>
</select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento3" class="botaoMaisAlimento" style="display: none" type="button" onclick="" value="+"/></td>
<td><label id="lbAlimento3" class="labelAlimento" style="display: none" >Alimento:</label></td>
<td><input id="txAlimento3" class="inputAlimento" style="display: none" type="text"/></td>
<td><label id="lbQuantidade3" class="labelQuantidade" style="display: none" >Quantidade:</label></td>
<td><input id="txQuantidade3" class="inputQuantidade input-mini" style="display: none" type="text"/></td>
<td>
<select id="medidas3" class="comboMedidas" style="display: none">
  <option>ml</option>
  <option>gramas</option>
</select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento4"class="botaoMaisAlimento" type="button" onclick="" value="+"/></td>
<td><label class="labelAlimento" >Alimento:</label></td>
<td><input id="quartoAlimento" class="inputAlimento" type="text"/></td>
<td><label class="labelQuantidade">Quantidade:</label></td>
<td><input id="quantidadeQuartoAlimento" class="inputQuantidade input-mini" type="text"/></td>
<td>
<select class="comboMedidas">
  <option>ml</option>
  <option>gramas</option>
</select>
</td>
</tr>
</table>

<table>
<tr>
<td><label class="labelAlimentoSemBotao">Alimento:</label></td>
<td><input id="quintoAlimento" class="inputAlimentoSemBotao" type="text"/></td>
<td><label class="labelQuantidadeSemBotao">Quantidade:</label></td>
<td><input id="quantidadeQuintoAlimento" class="inputQuantidadeSemBotao input-mini" type="text"/></td>
<td>
<select class="comboMedidasSemBotao">
  <option>ml</option>
  <option>gramas</option>
</select>
</td>
</tr>

</table>

<table>		
<tr>
<td><label class="labelRefeicaoOpcional">Refei&ccedil;&atilde;o Opcional:</label></td>
</tr>
</table>
		
<table class="espacoSuperior">
<tr>
<td><input id="btnMaisAlimento6" class="botaoMaisAlimento" type="button" onclick="" value="+"/></td>
<td><label class="labelAlimento">Alimento:</label></td>
<td><input id="sextoAlimento"  class="inputAlimento" type="text"/></td>
<td><label class="labelQuantidade" >Quantidade:</label></td>
<td><input id="quantidadeSextoAlimento" class="inputQuantidade input-mini" type="text"/></td>
<td>
<select class="comboMedidas">
  <option>ml</option>
  <option>gramas</option>
</select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento7" class="botaoMaisAlimento" type="button" onclick="" value="+"/></td>
<td><label class="labelAlimento" >Alimento:</label></td>
<td><input id="setimoAlimento" class="inputAlimento" type="text"/></td>
<td><label class="labelQuantidade">Quantidade:</label></td>
<td><input id="quantidadeSetimoAlimento" class="inputQuantidade input-mini" type="text"/></td>
<td>
<select class="comboMedidas">
  <option>ml</option>
  <option>gramas</option>
</select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento8" class="botaoMaisAlimento" type="button" onclick="" value="+"/></td>
<td><label class="labelAlimento" >Alimento:</label></td>
<td><input id="oitavoAlimento" class="inputAlimento" type="text"/></td>
<td><label class="labelQuantidade">Quantidade:</label></td>
<td><input id="quantidadeOitavoAlimento" class="inputQuantidade input-mini" type="text"/></td>
<td>
<select class="comboMedidas">
  <option>ml</option>
  <option>gramas</option>
</select>
</td>
</tr>

<tr>
<td><input id="btnMaisAlimento9"class="botaoMaisAlimento" type="button" onclick="" value="+"/></td>
<td><label class="labelAlimento" >Alimento:</label></td>
<td><input id="nonoAlimento" class="inputAlimento" type="text"/></td>
<td><label class="labelQuantidade">Quantidade:</label></td>
<td><input id="quantidadeNonoAlimento" class="inputQuantidade input-mini" type="text"/></td>
<td>
<select class="comboMedidas">
  <option>ml</option>
  <option>gramas</option>
</select>
</td>
</tr>
</table>
		
				</s:form>
		</div>
	</div>
</body>
</html>