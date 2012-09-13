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

function formatarHorario(hora){
	var hora01 = ''; 
	hora01 = hora01 + hora; 
	if (hora01.length == 2){ 
		hora01 = hora01 + ':'; 

		var h = document.getElementById('horario');
		h.value = hora01;
	} 
}

function verificaHoraManha(){ 
	var h = document.getElementById('horario');
	hrs = (h.value.substring(0,2)); 
	min = (h.value.substring(3,5)); 

	estado = ""; 
	if ((hrs < 00 ) || (hrs > 11) || ( min < 00) ||( min > 59)){ 
		estado = "errada"; 
	} 

	if (h.value == "") { 
		estado = "errada"; 
	} 

	if (estado == "errada") { 
		h.value='';
		h.focus(); 
	} 
}
