function manipularCampos(idBtnMaisAlimento , idLabelAlimento, idCampoAlimento, idLabelQuantidade, idCampoQuantidade, idCampoMedida){
	var btnMaisAlimento = document.getElementById(idBtnMaisAlimento);
	var labelAlimento = document.getElementById(idLabelAlimento);
	var labelQuantidade = document.getElementById(idLabelQuantidade);
	var inputAlimento = document.getElementById(idCampoAlimento);
	var inputQuantidade = document.getElementById(idCampoQuantidade);
	var inputMedida = document.getElementById(idCampoMedida);

	var estiloBtnMaisAlimento = btnMaisAlimento.style;
	var estiloLabelAlimento = labelAlimento.style;
	var estiloInputAlimento = inputAlimento.style;
	var estiloLabelQuantidade = labelQuantidade.style;
	var estiloInputQuantidade = inputQuantidade.style;
	var estiloInputMedida = inputMedida.style;

	if(estiloLabelAlimento.display == 'none'){
		estiloBtnMaisAlimento.display = 'block';
		estiloLabelAlimento.display = 'block';
		estiloInputAlimento.display = 'block';
		estiloLabelQuantidade.display = 'block';
		estiloInputQuantidade.display = 'block';
		estiloInputMedida.display = 'block';
	}else{
		estiloBtnMaisAlimento.display = 'none';
		estiloLabelAlimento.display = 'none';
		estiloInputAlimento.display = 'none';
		estiloLabelQuantidade.display = 'none';
		estiloInputQuantidade.display = 'none';
		estiloInputMedida.display = 'none';
	}
}

function manipularCamposSemBotao(idLabelAlimento, idCampoAlimento, idLabelQuantidade, idCampoQuantidade, idCampoMedida){
	var labelAlimento = document.getElementById(idLabelAlimento);
	var labelQuantidade = document.getElementById(idLabelQuantidade);
	var inputAlimento = document.getElementById(idCampoAlimento);
	var inputQuantidade = document.getElementById(idCampoQuantidade);
	var inputMedida = document.getElementById(idCampoMedida);

	var estiloLabelAlimento = labelAlimento.style;
	var estiloInputAlimento = inputAlimento.style;
	var estiloLabelQuantidade = labelQuantidade.style;
	var estiloInputQuantidade = inputQuantidade.style;
	var estiloInputMedida = inputMedida.style;

	if(estiloLabelAlimento.display == 'none'){
		estiloLabelAlimento.display = 'block';
		estiloInputAlimento.display = 'block';
		estiloLabelQuantidade.display = 'block';
		estiloInputQuantidade.display = 'block';
		estiloInputMedida.display = 'block';
	}else{
		estiloLabelAlimento.display = 'none';
		estiloInputAlimento.display = 'none';
		estiloLabelQuantidade.display = 'none';
		estiloInputQuantidade.display = 'none';
		estiloInputMedida.display = 'none';
	}
}

function manipularRefeicaoOpcional(idLabelRefeicaoOpcional, periodo){
	var labelRefeicaoOpcional = document.getElementById(idLabelRefeicaoOpcional);
	if(periodo == 'Manha'){
		periodo='';
	}
	
	if(labelRefeicaoOpcional.style.display == 'none'){
		labelRefeicaoOpcional.style.display = 'block';
		
		var btnMaisAlimento = document.getElementById('btnMaisAlimento' + periodo + '6');
		var lbAlimento = document.getElementById('lbAlimento' + periodo + '6');
		var txAlimento=  document.getElementById('txAlimento' + periodo + '6');
		var lbQuantidade = document.getElementById('lbQuantidade' + periodo + '6');
		var txQuantidade = document.getElementById('txQuantidade' + periodo + '6');
		var comboMedidas = document.getElementById('medidas' + periodo + '6');
		
		btnMaisAlimento.style.display = 'block';
		lbAlimento.style.display = 'block';
		txAlimento.style.display = 'block';
		lbQuantidade.style.display = 'block';
		txQuantidade.style.display = 'block';
		comboMedidas.style.display = 'block';
	
		
	}else{
		labelRefeicaoOpcional.style.display = 'none';
		
		for ( var i = 6; i < 10; i++) {
			var btnMaisAlimento = document.getElementById('btnMaisAlimento' + periodo + i);
			
			btnMaisAlimento.style.display = 'none';
		}
		
		
		for ( var i = 6; i < 11; i++) {
			var lbAlimento = document.getElementById('lbAlimento' + periodo + i);
			var txAlimento=  document.getElementById('txAlimento' + periodo + i);
			var lbQuantidade = document.getElementById('lbQuantidade' + periodo + i);
			var txQuantidade = document.getElementById('txQuantidade' + periodo + i);
			var comboMedidas = document.getElementById('medidas' + periodo + i);
			
			lbAlimento.style.display = 'none';
			txAlimento.style.display = 'none';
			lbQuantidade.style.display = 'none';
			txQuantidade.style.display = 'none';
			comboMedidas.style.display = 'none';
		}
	}
}

function formatarHorario(id, periodoDia){
	var input = document.getElementById(id);
	horaDigitada = input.value;
	var horaFinal = ''; 

	horaFinal = horaFinal + horaDigitada; 
	if (horaFinal.length == 2){
		horaFinal = horaFinal + ':'; 
		input.value = horaFinal;
	} 
	verificaHora(input, periodoDia);
}

function verificaHora(element, periodoDia){ 
	hrs = (element.value.substring(0,2)); 
	min = (element.value.substring(3,5)); 
	horaCorreta = "true";

	minMinimo = 00;
	minMaximo = 59;

	if(periodoDia == 'manha'){
		horaMinima = 00;
		horaMaxima = 11;

	}else if(periodoDia == 'tarde'){
		horaMinima = 12;
		horaMaxima = 17;

	}else{
		horaMinima = 18;
		horaMaxima = 23;
	}                

	if ((hrs < horaMinima ) || (hrs > horaMaxima) || ( min < minMinimo) ||( min > minMaximo)){ 
		horaCorreta = "false"; 
	} 

	if (element.value == "") { 
		horaCorreta = "false"; 
	} 

	if(element.value.length<2){
		horaCorreta="true";
	}
	
	if (horaCorreta == "false") { 
		element.value='';
		element.focus(); 
	} 
	
	function manipularCamposOpcionais(element, periodo){
		
		
		
	}
}
