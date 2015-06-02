//metodo que habilita o desabilita el boton cuando se escribe en el input

//inputId = id del input
//btn = name del button

function enableDisableButton(inputId) {
	var valueInput = $(inputId).val().length;
	if (valueInput > 0) {
		$('.saveAlias').removeClass('buttonDisabled');
		return;
	} else {
		$('.saveAlias').addClass('buttonDisabled');
	}
}

// metodo que habilita o desabilita el boton cuando hay 4 digitos en el input

// inputId= id del input
// btnW = name del button

function enableDisable(inputId) {
	var valueInput = $(inputId).val().length;
	if (valueInput == 4) {
		$('.operKey').removeClass('buttonDisabled');
		return;
	} else {
		$('.operKey').addClass('buttonDisabled');
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

$(window)
		.load(
				function() {
					var styleBody = $('.ui-growl-item-container').length;
					if (styleBody >= 1) {
						var heightB = $(document).height();
						var overlay = "<div id='modal' class='ui-widget-overlay' style='height:"
								+ heightB
								+ "px !important; z-index: 1000;'> </div>";
						$('body').append(overlay);
					}
				});

$(window).load(function() {
	$('.ui-growl').find('div.ui-growl-icon-close').click(function() {
		var styleBody = $('.ui-growl-item-container').length;
		if (styleBody == 1) {
			$('#modal').remove();
		}
	});
});

$(document).ready(function() {
	$('.extractButton').click(function() {
		$('.extractOnePage').empty();
		$('.extractTwoPage').removeClass('renderExtract');
	});
});

function buttonVisi(button) {
	$(document).ready(function() {
		var dat = $(button).parents('#headerFavo').parent();
		$(dat).find('span[class*="buttons-addfavo"]').removeClass('nonee');
		$(dat).find('a[id="alink"]').removeClass('mini-triangled');
		$(dat).find('a[id="alink"]').addClass('backImaNo');
	});
}

function removeEdit(button) {
	$(document).ready(function() {
		var but = $(button).parents('.ui-datatable-data');
		var i = $(but).find('.ui-row-toggler.ui-icon-circle-triangle-s');

		if (i.length == 1) {
			$(but).find('.ui-expanded-row').find('.ui-row-toggler').click();
		}
	});
}

function removeEditAll(button) {
	$(document).ready(function() {
		var dat = $(button).parents('article[id|="artFav"]').parent();
		var i = $('.ui-row-toggler.ui-icon-circle-triangle-s').length;

		if (i >= 1) {
			$('.ui-expanded-row').find('.ui-row-toggler').click();
		}
		$(dat).find('span[class*="buttons-addfavo"]').addClass('nonee');
		$(dat).find('a[id="alink"]').addClass('mini-triangled');
		$(dat).find('a[id="alink"]').removeClass('backImaNo');
	});
}

function clickMoveFav(button) {
	$(document).ready(function() {
		var dat = $(button).parents('td.operation').parent();
		var index = $(dat).attr('data-ri');
		var parent = $(dat).parent('.ui-datatable-data');
		var i = $('.ui-row-toggler.ui-icon-circle-triangle-s').length;

		if (i == 1) {
			$('.ui-expanded-row').find('.ui-row-toggler').click();
		}
		$(parent).find('.ui-row-toggler').eq(index).click();
	});
}
