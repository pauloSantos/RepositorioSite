<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<table>
<tr>
<td><label class="espacoSuperior labelHorario label">Hor&aacute;rio:</label></td>
<td><s:text id="horarioNoite" name="horarioRefeicaoNoite" class="espacoSuperior inputHorario" onkeyup="formatarHorario(this.id, 'noite'), verificaHoraManha()" maxlength="5" style="width:36px "/></td>
<td>
<label class="label botaoMaisRefeicao espacoSuperior">
<i id="maisRefeicaoNoite" class="icon-plus icon-white" onclick="manipularRefeicaoOpcional('lbRefeicaoOpcionalNoite', 'Noite')"></i>
</label>
</td>
<td><label class="espacoSuperior labelRefeicao label">Refei&ccedil;&atilde;o:</label></td>
</tr>
</table>



<table class="espacoSuperior">
<tr>
<td>
<label id="btnMaisAlimentoNoite1" class="label botaoMaisAlimento">
	<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoNoite2', 'lbAlimentoNoite2', 'txAlimentoNoite2', 'lbQuantidadeNoite2', 'txQuantidadeNoite2', 'medidasNoite2')"></i>
</label>
</td>
<td><label id="lbAlimentoNoite1" class="labelAlimento label">Alimento:</label></td>
<td><s:text id="txAlimentoNoite1"  name ="nomeAlimentos.alimentoNoite1" class="inputAlimento"></s:text></td>
<td><label id="lbQuantidadeNoite1" class="labelQuantidade label" >Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite1" name="quantidade.alimentoNoite1" class="inputQuantidade input-mini"/></td>
<td>
<s:select id="medidasNoite1" name="listaUnidadeDeMedida.alimentoNoite1" class="comboMedidas">
  <option></option>
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimentoNoite2" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white"  onclick="manipularCampos('btnMaisAlimentoNoite3', 'lbAlimentoNoite3', 'txAlimentoNoite3', 'lbQuantidadeNoite3', 'txQuantidadeNoite3', 'medidasNoite3')"></i>
</label>
</td>
<td><label id="lbAlimentoNoite2" class="labelAlimento label" style="display: none" >Alimento:</label></td>
<td><input id="txAlimentoNoite2" name ="nomeAlimentos.alimentoNoite2" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeNoite2" class="labelQuantidade label" style="display: none" >Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite2" name="quantidade.alimentoNoite2" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasNoite2" name="listaUnidadeDeMedida.alimentoNoite2"  class="comboMedidas" style="display: none" >
  <option></option>
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimentoNoite3" class="label botaoMaisAlimento" style="display: none">
<i  class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoNoite4', 'lbAlimentoNoite4', 'txAlimentoNoite4', 'lbQuantidadeNoite4', 'txQuantidadeNoite4', 'medidasNoite4')"></i>
</label>
</td>
<td><label id="lbAlimentoNoite3" class="labelAlimento label" style="display: none" >Alimento:</label></td>
<td><s:text id="txAlimentoNoite3" name ="nomeAlimentos.alimentoNoite3" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeNoite3" class="labelQuantidade label" style="display: none" >Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite3" name="quantidade.alimentoNoite3" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasNoite3" name="listaUnidadeDeMedida.alimentoNoite3"  class="comboMedidas" style="display: none">
  <option></option>
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimentoNoite4" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCamposSemBotao('lbAlimentoNoite5', 'txAlimentoNoite5', 'lbQuantidadeNoite5', 'txQuantidadeNoite5', 'medidasNoite5')" ></i>
</label>
</td>
<td><label id="lbAlimentoNoite4" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoNoite4" name ="nomeAlimentos.alimentoNoite4" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeNoite4" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite4" name="quantidade.alimentoNoite4" class="inputQuantidade input-mini"style="display: none" /></td>
<td>
<s:select id="medidasNoite4" name="listaUnidadeDeMedida.alimentoNoite4"  class="comboMedidas" style="display: none">
  <option></option>
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>
</table>

<table>
<tr>
<td>
<label id="btnMaisAlimentoNoite5" class="label botaoMaisAlimento" style="display: none">
<i  class="icon-plus icon-white" onclick="manipularCamposSemBotao('lbAlimentoNoite6', 'txAlimentoNoite6', 'lbQuantidadeNoite6', 'txQuantidadeNoite6', 'medidasNoite6')" ></i>
</label>
</td>
<td><label id="lbAlimentoNoite5" class="labelAlimentoSemBotao label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoNoite5" name ="nomeAlimentos.alimentoNoite5" class="inputAlimentoSemBotao" style="display: none"/></td>
<td><label id="lbQuantidadeNoite5" class="labelQuantidadeSemBotao label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite5" name="quantidade.alimentoNoite5" class="inputQuantidadeSemBotao input-mini" style="display: none"/></td>
<td>
<s:select id="medidasNoite5" name="listaUnidadeDeMedida.alimentoNoite5"  class="comboMedidasSemBotao" style="display: none">
  <option></option>
  <option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>
</table>


<table>		
<tr>
<td><label id="lbRefeicaoOpcionalNoite" class="labelRefeicaoOpcional label" style="display: none">Refei&ccedil;&atilde;o Opcional:</label></td>
</tr>
</table>


<table class="espacoSuperior">
<tr>
<td>
<label id="btnMaisAlimentoNoite6" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoNoite7', 'lbAlimentoNoite7', 'txAlimentoNoite7', 'lbQuantidadeNoite7', 'txQuantidadeNoite7', 'medidasNoite7')"></i>
</label>
</td>
<td><label id="lbAlimentoNoite6" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoNoite6"  name="nomeAlimentos.alimentoOpcionalNoite6" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeNoite6" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite6" name="quantidade.alimentoOpcionalNoite6" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasNoite6" name="listaUnidadeDeMedida.alimentoOpcionalNoite6" class="comboMedidas" style="display: none">
  <option></option>
<option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimentoNoite7" class="label botaoMaisAlimento" style="display: none">
<i  class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoNoite8', 'lbAlimentoNoite8', 'txAlimentoNoite8', 'lbQuantidadeNoite8', 'txQuantidadeNoite8', 'medidasNoite8')"></i>
</label>
</td>
<td><label id="lbAlimentoNoite7" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoNoite7" name ="nomeAlimentos.alimentoOpcionalNoite7" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeNoite7" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite7" name="quantidade.alimentoOpcionalNoite7" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasNoite7" name="listaUnidadeDeMedida.alimentoOpcionalNoite7" class="comboMedidas" style="display: none">
  <option></option>
<option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimentoNoite8" class="label botaoMaisAlimento" style="display: none">
<i  class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoNoite9', 'lbAlimentoNoite9', 'txAlimentoNoite9', 'lbQuantidadeNoite9', 'txQuantidadeNoite9', 'medidasNoite9')"></i>
</label>
</td>
<td><label id="lbAlimentoNoite8" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoNoite8" name="nomeAlimentos.alimentoOpcionalNoite8" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeNoite8" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite8" name="quantidade.alimentoOpcionalNoite8" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasNoite8" name="listaUnidadeDeMedida.alimentoOpcionalNoite8" class="comboMedidas" style="display: none">
  <option></option>
<option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>

<tr>
<td>
<label id="btnMaisAlimentoNoite9" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCamposSemBotao('lbAlimentoNoite10', 'txAlimentoNoite10', 'lbQuantidadeNoite10', 'txQuantidadeNoite10', 'medidasNoite10')"></i>
</label>
</td>
<td><label id="lbAlimentoNoite9" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoNoite9" name="nomeAlimentos.alimentoOpcionalNoite9" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeNoite9" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite9" name="quantidade.alimentoOpcionalNoite9" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasNoite9" name="listaUnidadeDeMedida.alimentoOpcionalNoite9" class="comboMedidas" style="display: none">
  <option></option>
<option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>
</table>


<table>
<tr>
<td><label id="lbAlimentoNoite10" class="labelAlimentoSemBotao label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoNoite10" name ="nomeAlimentos.alimentoOpcionalNoite10" class="inputAlimentoSemBotao" style="display: none"/></td>
<td><label id="lbQuantidadeNoite10" class="labelQuantidadeSemBotao label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeNoite10" name="quantidade.alimentoOpcionalNoite10" class="inputQuantidadeSemBotao input-mini" style="display: none"/></td>
<td>
<s:select id="medidasNoite10" name="listaUnidadeDeMedida.alimentoOpcionalNoite10"  class="comboMedidasSemBotao" style="display: none">
  <option></option>
<option>ml</option>
  <option>gramas</option>
</s:select>
</td>
</tr>
</table>

</html>