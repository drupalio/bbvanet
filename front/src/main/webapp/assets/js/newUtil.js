//metodo que habilita o desabilita el boton cuando se escribe en el input

//inputId = id del input
//btn = name del button

function enableDisableButton(inputId) {
    var valueInput = $(inputId).val().length;
    if (valueInput > 0) {
	$('.saveAlias').removeClass('buttonDisabled');
    }
    return false;
}

// metodo que habilita o desabilita el boton cuando hay 4 digitos en el input

// inputId= id del input
// btnW = name del button

function enableDisable(inputId, btnW) {
    var valueInput = $(inputId).val().length;
    if (valueInput == 4) {
	$('.operKey').removeClass('buttonDisabled');
    }
    return false;
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

/* Quitar estilo de tabs de consultas */
$(document).ready(function() {
    $('#headerTab').click(function() {
	$(this).removeClass('setStyle');
    });
});

/* Poner estilo de tabs de consultas */
function headerTabS(button) {
    $(document).ready(function() {
	var parent = $(button).parents('#dateFilterContent');
	var li = $(parent).parents('.date-filter').children('#headerTab');
	$(li).addClass('setStyle');
    });
}

$(window).load(function() {
    var styleBody = $('.ui-growl-item-container').length;
	 if (styleBody == 1) {
	     var heightB = $(document).height();
	     var overlay = "<div id='modal' class='ui-widget-overlay' style='height:"+ heightB+ "px !important; z-index: 1000;'> </div>";
	     $('body').append(overlay);
	 }
});


$(window).load(function() {
	$('.ui-growl').find('div.ui-growl-icon-close').click(function() {
	    $('#modal').remove();
	});
});
$(document).ready(function() {
    $('.extractButton').click(function() {
	$('.extractOnePage').empty();
	$('.extractTwoPage').removeClass('renderExtract');
    });

});
