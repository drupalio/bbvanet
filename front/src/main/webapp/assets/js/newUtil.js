//metodo que habilita o desabilita el boton cuando se escribe en el input

//inputId = id del input
//btn = name del button

function enableDisableButton(inputId, btn) {
    var button = document.getElementsByName(btn.name)[0].id;
    var valor = inputId.value;
    if (valor.length != 0) {
	document.getElementById(button).disabled = false;
	document.getElementById(button).classList.remove('ui-state-disabled');
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
	document.getElementById(button).classList.remove('ui-state-disabled');
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

// Para abrir y cerrar los detalles de movimientos.
function clickMove() {
    $(document).ready(function() {
	var index;
	var next;
	$('.ui-datatable-data').children().each(function() {
	    var selected = $(this).attr('aria-selected');
	    if (selected === 'true') {
		index = $(this).attr('data-ri');
		next = $(this).next('.ui-expanded-row-content').length;
		return false;
	    }
	});

	var i = $('.ui-row-toggler.ui-icon-circle-triangle-s').length;
	if (i == 1) {
	    $('.ui-expanded-row').find('.ui-row-toggler').click();
	}
	if (next == 0) {
	    $('.ui-datatable-data').find('.ui-row-toggler').eq(index).click();
	}
    });
}

// Cerrar de los tab operation Quota y Movements
$(document).ready(function() {
    $('.close-button').click(function() {
	var parent = $(this).parents('.operation-tabs');
	parent.find('.active').removeClass('active');
    });
});

/* combos */
function styles(combo) {
    $(document).ready(function() {
	$(combo).blur();
    });
}
$(document).ready(function() {
    $('#headerTab').click(function() {
	$(this).removeClass('setStyle');
    });
});

function headerTabS(button) {
    $(document).ready(function() {
	var parent = $(button).parents('#dateFilterContent');
	var li = $(parent).parents('.date-filter').children('#headerTab');
	$(li).addClass('setStyle');
    });
}