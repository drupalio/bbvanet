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

// metodo que abre y cierra el div de detalle de movimiento
// function divMovement() {
//
// var styles = document.getElementById("rowExpansion").style.display;
//
// if (styles == 'none')
// document.getElementById("rowExpansion").style.display = "block";
// else
// document.getElementById("rowExpansion").style.display = "none";
// }


