<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<table>
<tr>
<td><label class="espacoSuperior labelHorario label">Hor&aacute;rio:</label></td>
<td><s:text id="horarioTarde" name="horarioRefeicaoTarde" class="espacoSuperior inputHorario" onkeyup="formatarHorario(this.id, 'tarde'), verificaHoraManha()" maxlength="5" style="width:36px "/></td>
<td>
<label id="maisRefeicaoTarde" class="label botaoMaisRefeicao espacoSuperior">
<i class="icon-plus icon-white" onclick="manipularRefeicaoOpcional('lbRefeicaoOpcionalTarde', 'Tarde')"></i>
</label>
</td>
<td><label class="espacoSuperior labelRefeicao label">Refei&ccedil;&atilde;o:</label></td>
</tr>
</table>


<table class="espacoSuperior">
<tr>
<td>
<label id="btnMaisAlimentoTarde1" class="label botaoMaisAlimento">
<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoTarde2', 'lbAlimentoTarde2', 'txAlimentoTarde2', 'lbQuantidadeTarde2', 'txQuantidadeTarde2', 'medidasTarde2')" ></i>
</label>
</td>
<td><label id="lbAlimentoTarde1" class="labelAlimento label">Alimento:</label></td>
<td><s:text id="txAlimentoTarde1"  name ="nomeAlimentos.alimentoTarde1" class="inputAlimento"></s:text></td>
<td><label id="lbQuantidadeTarde1" class="labelQuantidade label" >Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde1" name="quantidade.alimentoTarde1" class="inputQuantidade input-mini"/></td>
<td>
<s:select id="medidasTarde1" name="listaUnidadeDeMedida.alimentoTarde1" class="comboMedidas">
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
<label id="btnMaisAlimentoTarde2" class="label botaoMaisAlimento" style="display: none">
<i  class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoTarde3', 'lbAlimentoTarde3', 'txAlimentoTarde3', 'lbQuantidadeTarde3', 'txQuantidadeTarde3', 'medidasTarde3')"></i>
</label>
</td>
<td><label id="lbAlimentoTarde2" class="labelAlimento label" style="display: none" >Alimento:</label></td>
<td><input id="txAlimentoTarde2" name ="nomeAlimentos.alimentoTarde2" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeTarde2" class="labelQuantidade label" style="display: none" >Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde2" name="quantidade.alimentoTarde2" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasTarde2" name="listaUnidadeDeMedida.alimentoTarde2"  class="comboMedidas" style="display: none" >
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
<label id="btnMaisAlimentoTarde3" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoTarde4', 'lbAlimentoTarde4', 'txAlimentoTarde4', 'lbQuantidadeTarde4', 'txQuantidadeTarde4', 'medidasTarde4')"></i>
</label>
</td>
<td><label id="lbAlimentoTarde3" class="labelAlimento label" style="display: none" >Alimento:</label></td>
<td><s:text id="txAlimentoTarde3" name ="nomeAlimentos.alimentoTarde3" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeTarde3" class="labelQuantidade label" style="display: none" >Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde3" name="quantidade.alimentoTarde3" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasTarde3" name="listaUnidadeDeMedida.alimentoTarde3"  class="comboMedidas" style="display: none">
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
<label id="btnMaisAlimentoTarde4" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCamposSemBotao('lbAlimentoTarde5', 'txAlimentoTarde5', 'lbQuantidadeTarde5', 'txQuantidadeTarde5', 'medidasTarde5')"></i>
</label>
</td>
<td><label id="lbAlimentoTarde4" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoTarde4" name ="nomeAlimentos.alimentoTarde4" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeTarde4" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde4" name="quantidade.alimentoTarde4" class="inputQuantidade input-mini"style="display: none" /></td>
<td>
<s:select id="medidasTarde4" name="listaUnidadeDeMedida.alimentoTarde4"  class="comboMedidas" style="display: none">
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
<td><label id="lbAlimentoTarde5" class="labelAlimentoSemBotao label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoTarde5" name ="nomeAlimentos.alimentoTarde5" class="inputAlimentoSemBotao" style="display: none"/></td>
<td><label id="lbQuantidadeTarde5" class="labelQuantidadeSemBotao label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde5" name="quantidade.alimentoTarde5" class="inputQuantidadeSemBotao input-mini" style="display: none"/></td>
<td>
<s:select id="medidasTarde5" name="listaUnidadeDeMedida.alimentoTarde5"  class="comboMedidasSemBotao" style="display: none">
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
<td><label id="lbRefeicaoOpcionalTarde" class="labelRefeicaoOpcional label" style="display: none">Refei&ccedil;&atilde;o Opcional:</label></td>
</tr>
</table>



<table class="espacoSuperior">
<tr>
<td>
<label id="btnMaisAlimentoTarde6" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white"onclick="manipularCampos('btnMaisAlimentoTarde7', 'lbAlimentoTarde7', 'txAlimentoTarde7', 'lbQuantidadeTarde7', 'txQuantidadeTarde7', 'medidasTarde7')"></i>
</label>
</td>
<td><label id="lbAlimentoTarde6" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoTarde6"  name="nomeAlimentos.alimentoOpcionalTarde6" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeTarde6" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde6" name="quantidade.alimentoOpcionalTarde6" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasTarde6" name="listaUnidadeDeMedida.alimentoOpcionalTarde6" class="comboMedidas" style="display: none">
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
<label id="btnMaisAlimentoTarde7" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoTarde8', 'lbAlimentoTarde8', 'txAlimentoTarde8', 'lbQuantidadeTarde8', 'txQuantidadeTarde8', 'medidasTarde8')"></i>
</label>
</td>
<td><label id="lbAlimentoTarde7" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoTarde7" name ="nomeAlimentos.alimentoOpcionalTarde7" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeTarde7" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde7" name="quantidade.alimentoOpcionalTarde7" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasTarde7" name="listaUnidadeDeMedida.alimentoOpcionalTarde7" class="comboMedidas" style="display: none">
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
<label id="btnMaisAlimentoTarde8" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCampos('btnMaisAlimentoTarde9', 'lbAlimentoTarde9', 'txAlimentoTarde9', 'lbQuantidadeTarde9', 'txQuantidadeTarde9', 'medidasTarde9')"></i>
</label>
</td>
<td><label id="lbAlimentoTarde8" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoTarde8" name="nomeAlimentos.alimentoOpcionalTarde8" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeTarde8" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde8" name="quantidade.alimentoOpcionalTarde8" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasTarde8" name="listaUnidadeDeMedida.alimentoOpcionalTarde8" class="comboMedidas" style="display: none">
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
<label id="btnMaisAlimentoTarde9" class="label botaoMaisAlimento" style="display: none">
<i class="icon-plus icon-white" onclick="manipularCamposSemBotao('lbAlimentoTarde10', 'txAlimentoTarde10', 'lbQuantidadeTarde10', 'txQuantidadeTarde10', 'medidasTarde10')"></i>
</label>
</td>
<td><label id="lbAlimentoTarde9" class="labelAlimento label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoTarde9" name="nomeAlimentos.alimentoOpcionalTarde9" class="inputAlimento" style="display: none"/></td>
<td><label id="lbQuantidadeTarde9" class="labelQuantidade label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde9" name="quantidade.alimentoOpcionalTarde9" class="inputQuantidade input-mini" style="display: none"/></td>
<td>
<s:select id="medidasTarde9" name="listaUnidadeDeMedida.alimentoOpcionalTarde9" class="comboMedidas" style="display: none">
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
<td><label id="lbAlimentoTarde10" class="labelAlimentoSemBotao label" style="display: none">Alimento:</label></td>
<td><s:text id="txAlimentoTarde10" name ="nomeAlimentos.alimentoOpcionalTarde10" class="inputAlimentoSemBotao" style="display: none"/></td>
<td><label id="lbQuantidadeTarde10" class="labelQuantidadeSemBotao label" style="display: none">Quantidade:</label></td>
<td><s:text id="txQuantidadeTarde10" name="quantidade.alimentoOpcionalTarde10" class="inputQuantidadeSemBotao input-mini" style="display: none"/></td>
<td>
<s:select id="medidasTarde10" name="listaUnidadeDeMedida.alimentoOpcionalTarde10"  class="comboMedidasSemBotao" style="display: none">
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

</html>