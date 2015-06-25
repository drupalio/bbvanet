//metodo que habilita o desabilita el boton cuando se escribe en el input
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

/* blur combos */
function styles(combo) {
	$(document).ready(function() {
		$(combo).blur();
	});
}

/* Poner estilo de tabs de consultas */
function headerTabS(button) {
	$(document).ready(function() {
		var parent = $(button).parents('#dateFilterContent');
		var li = $(parent).parents('.date-filter').children('#headerTab');
		$(li).addClass('setStyle');
	});
}

function openOperaMore() {
	$(document).ready(function() {
		var mysessionItem = $('#operations').val();
		if (mysessionItem == 'true') {
			var context = $('.operation-tabs');
			$(context).find('#item_operations').addClass('active');
			$(context).find('#tab-operaciones').addClass('active');
			$('#opButton').click();
		}
	});
}

/* buttons visible favoritos */
function buttonVisi(button) {
	$(document).ready(function() {
		var dat = $(button).parents('#headerFavo').parent();
		$(dat).find('span[class*="buttons-addfavo"]').removeClass('nonee');
		$(dat).find('a[id="alink"]').removeClass('mini-triangled');
		$(dat).find('a[id="alink"]').addClass('backImaNo');
	});
}

/* div edit actual hidden favoritos */
function removeEdit(button) {
	$(document).ready(function() {
		var but = $(button).parents('.ui-datatable-data');
		var i = $(but).find('.ui-row-toggler.ui-icon-circle-triangle-s');

		if (i.length == 1) {
			$(but).find('.ui-expanded-row').find('.ui-row-toggler').click();
		}
	});
}

/* div hidden all favoritos */
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

/* div edit actual visible favoritos */
function clickMoveFav() {
	$(document).ready(function() {
		var button = $('.editFavoritosRow.ui-state-focus');
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

function closePlease() {
	$(document).ready(function() {
		var asdasdas = $('#momentPlease');
		var asdasd = $('#momentPlease').find('.ui-dialog-titlebar-close');
		$(asdasd).click();
	});
}

$(document).ready(function() {
	/* button Extractos */
	$('.extractButton').click(function() {
		$('.extractOnePage').empty();
		$('.extractTwoPage').removeClass('renderExtract');
	});

	/* close de consultas */
	$('.close-button').click(function() {
		var parent = $(this).parents('.operation-tabs');
		parent.find('.active').removeClass('active');
	});

	/* Quitar estilo de tabs de consultas */
	$('#headerTab').click(function() {
		$(this).removeClass('setStyle');
	});

	/* event blur combos */
	$('body').mouseup(function() {
		$('.ui-selectonemenu').blur();
	});

	/* Exception blur combos */
	$('.ui-selectonemenu').mouseup(function(event) {
		event.stopPropagation();
	});

	/* Exception blur combos */
	$('.ui-selectonemenu-panel').mouseup(function(event) {
		event.stopPropagation();
	});

	/* Events Combo Like */
	$('.comboLike').children('.ui-selectonemenu').on({
		'click' : function(event) {
			var comboItems = $('#' + this.id.replace(/:/g, '\\:') + '_panel');
			var selecItems = $(comboItems).children('.ui-selectonemenu-items-wrapper');
			var ulSelect = $(selecItems).children('.ui-selectonemenu-items');
			var dat = $('.comboLike .ui-selectonemenu.likeSame.open');

			$(comboItems).css({
				'top' : ($(this).offset().top + 33) + 'px',
				'left' : (parseFloat(comboItems.css('left')) - 191) + 'px'
			});

			$(ulSelect).children('.ui-selectonemenu-item:first').text('');
			$(ulSelect).children('.ui-selectonemenu-item:first').css("padding", "0px");

			if ($(dat).length >= 1 && $(dat).attr('id') != $(this).attr('id')) {
				$(dat).blur();
			}

			if (!$(this).hasClass('open')) {
				$(this).addClass('open');
				$(this).children('.ui-selectonemenu-label').addClass('open');
				$(this).children('.ui-selectonemenu-trigger').addClass('open');
			} else {
				$(this).blur();
			}
		},

		'blur' : function() {
			var comboItems = $('#' + this.id.replace(/:/g, '\\:') + '_panel');
			$(this).children('.ui-selectonemenu-trigger').removeClass('open');
			$(this).children('.ui-selectonemenu-label').removeClass('open');
			$(comboItems).css("display", "none");
			$(this).removeClass('open');
		}
	});

	$('.comboLike').children('.ui-selectonemenu').one("click", function() {
		var comboItems = $('#' + this.id.replace(/:/g, '\\:') + '_panel');
		var selectItems = $(comboItems).children('.ui-selectonemenu-items-wrapper');
		$(selectItems).before("<div style='width:" + (260 - $(this).width()) + "px;' class='likeBord'/>");
		$(selectItems).before("<div style='width:" + ($(this).width() - 1) + "px;' class='likeDif'/>");
	});
});

$(window).load(function() {
	PF('statusDialog').hide()
});

$(window).load(function() {
	/* Message Container */
	var styleBody = $('.ui-growl-item-container').length;

	/* abrir el modal de mensajes Growl */
	if (styleBody >= 1) {
		var heightB = $(document).height();
		var overlay = "<div id='modal' class='ui-widget-overlay' style='height:" + heightB + "px !important; z-index: 1000;'> </div>";
		$('body').append(overlay);
	}

	/* cerrar el modal de mensajes Growl */
	$('.ui-growl').find('div.ui-growl-icon-close').click(function() {
		if (styleBody == 1) {
			$('#modal').remove();
		}
	});
});