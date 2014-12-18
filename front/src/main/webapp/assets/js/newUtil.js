//metodo que habilita o desabilita el boton cuando se escribe en el input

//inputId = id del input
//btn = name del button

function enableDisableButton(inputId, btn) {
	var button = document.getElementsByName(btn.name)[0].id;
	var valor = inputId.value;
	if (valor.length != 0) {
		document.getElementById(button).disabled = false;
	} else {
		document.getElementById(button).disabled = true;
	}
}

// metodo que habilita o desabilita el boton cuando hay 4 digitos en el input

// inputId= id del input
// btnW = name del button

function enableDisable(inputId, btnW) {
	var button = document.getElementsByName(btnW.name)[0].id;
	var valor = inputId.value;
	if (valor.length == 4) {
		document.getElementById(button).disabled = false;
	} else {
		document.getElementById(button).disabled = true;
	}

}

// Metodo que cambia el estilo del divOperationkey
// (resources.bbva.messages.divOperationKey)

function checkFilled(btnW, inputId) {
	var button = document.getElementsByName(btnW.name)[0].id;
	document.getElementById(button).style.visibility = "hidden";
	inputId.className = "col-xs-9 col-md-8 input-control pass-valid";

}

// no sirve .... // metodo que hacia los cambios de vista
// del registro de correos de adquiriencia

function checkAdd(btnAdd, btnUp, divId, label, inputOri, inputNew) {
	var button = document.getElementsByName(btnAdd.name)[0].id;
	var valor = inputOri.value;
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/.test(inputOri)) {
		alert("La dirección de email " + valor + " es correcta.");
		document.getElementById(button).disabled = true;
		document.getElementById(divId).style.visibility = "visible";
		document.getElementById(btnUp).style.visibility = "visible";
		document.getElementById(inputNew).value = valor;
	} else {
		alert("La dirección de email es incorrecta.");
		document.getElementById(label).style.visibility = "visible";
	}
}
