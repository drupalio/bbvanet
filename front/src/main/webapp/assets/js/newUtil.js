// metodo que habilita o desabilita el boton cuando se escribe en el input
function enableDisableButton(inputId) {
	var valueInput = $(inputId).val().length;
	if (valueInput > 0) {
		$('#tabMenu\\:tabPersonal\\:personaliz\\:upAlias\\:inputContent\\:buttonUpdate').removeClass('buttonDisabled');
		$('#quotaDetail\\:tabMenu\\:tabQuota\\:personaliz\\:upAlias\\:inputContent\\:buttonUpdate').removeClass('buttonDisabled');
		return;
	} else {
		$('#tabMenu\\:tabPersonal\\:personaliz\\:upAlias\\:inputContent\\:buttonUpdate').addClass('buttonDisabled');
		$('#quotaDetail\\:tabMenu\\:tabQuota\\:personaliz\\:upAlias\\:inputContent\\:buttonUpdate').addClass('buttonDisabled');
	}
}

// metodo que habilita o desabilita el boton cuando hay 4 digitos en el input
function enableDisable(inputId) {
	var valueInput = $(inputId).val().length;
	if (valueInput >= 5) {
		$('.operKey').removeClass('buttonDisabled');
		return;
	} else {
		$('.operKey').addClass('buttonDisabled');
	}

}

// Metodo que cambia el estilo del divOperationkey
function checkFilled() {
	$(document).ready(function() {
		$('button.verifySucess').css('visibility', 'hidden');
		$('#divClass').css("cssText", "width: 100% !important;");
		$('input.verifySucess').css("cssText", "width: 63% !important;");
		$('input.verifySucess').after('<div class="pass-valid" style="width: 20px !important; float: right; height: 32px; padding: 0px; margin-right: 38px;"></div>');
	});
}

// Metodo que cambia el estilo del divOperationkey
function mistakeFilled() {
	$(document).ready(function() {
		$('button.verifySucess').css('visibility', 'hidden');
		$('#divClass').css("cssText", "width: 100% !important;");
		$('input.verifySucess').css("cssText", "width: 63% !important;");
		$('input.verifySucess').after('<div class="mistake-operation" style="width: 20px !important; float: right; height: 32px; padding: 0px; margin-right: 38px;"></div>');
	});
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

function addTool(spanT) {
	$(document).ready(function() {
		var div = "<div class='tooltip-arrow'></div><div class='tooltip-inner'>" + $(spanT).attr('data-original-title') + "</div>";
		$(spanT).parent().prepend("<div style='display: block;" + $(spanT).attr('data-style-toggle') + "' id='" + $(spanT).attr('id') + "tooltip' class='tooltip fade top in' role='tooltip'>" + div + " </div>");
	});
}

function removeTool(spanT) {
	$(document).ready(function() {
		$(spanT).prev().remove();
	});
}

function dataCalendar(picker) {
	$(document).ready(function() {
		var currentTo = $('.ui-datepicker-current');
		var tableCalen = $('.ui-datepicker-calendar');

		$('#ui-datepicker-div').css({
			'top' : ($(picker).offset().top + 30) + 'px',
		});

		var heigthCa = $(tableCalen).height();
		$(currentTo).css('margin-top', '-' + (heigthCa + 40) + 'px');
	});
}

function extractsEvent() {
	$(document).ready(function() {
		$('.extractOnePage').empty();
		$('.extractTwoPage').removeClass('renderExtract');
	});
}

function keyOtte(combo) {
	$(document).ready(function() {
		if (event.keyCode === 13) {
			$(this).blur();
		}
	});
}

function styleOtte(combo) {
	$(document).ready(function() {
		var actual = $(combo);
		var parent = $(combo).parents('.selectorCombo');
		var comboItems = $('#' + combo.id.replace(/:/g, '\\:') + '_panel');
		var selecItems = $(comboItems).children('.ui-selectonemenu-items-wrapper');
		var ulSelect = $(selecItems).children('.ui-selectonemenu-items');
		var selectDisa = $(ulSelect).children('.ui-selectonemenu-item.ui-state-disabled');
		var dat = $('.selectorCombo .ui-selectonemenu.open');

		$(comboItems).css({
			'top' : ($(combo).offset().top + 33) + 'px',
			'width' : ($(parent).width()) + 'px'
		});

		$(selectDisa).each(function() {
			$(combo).css('display', 'none');
		});

		$(dat).each(function() {
			if ((dat).attr('id') != $(actual).attr('id')) {
				$(dat).removeClass('open');
				$(dat).children('.ui-selectonemenu-label').removeClass('open');
				$(dat).children('.ui-selectonemenu-trigger').removeClass('open');
			}
		});

		if (!$(combo).hasClass('open')) {
			$(combo).addClass('open');
			$(combo).children('.ui-selectonemenu-label').addClass('open');
			$(combo).children('.ui-selectonemenu-trigger').addClass('open');
		} else {
			$(combo).removeClass('open');
			$(combo).children('.ui-selectonemenu-label').removeClass('open');
			$(combo).children('.ui-selectonemenu-trigger').removeClass('open');
		}
	});
}

$(document).delegate('.ui-datepicker-prev', 'click', function() {
	var currentTo = $('.ui-datepicker-current');
	var tableCalen = $('.ui-datepicker-calendar');
	var heigthCa = $(tableCalen).height();
	$(currentTo).css('margin-top', '-' + (heigthCa + 40) + 'px');
});

$(document).delegate('.ui-datepicker-next', 'click', function() {
	var currentTo = $('.ui-datepicker-current');
	var tableCalen = $('.ui-datepicker-calendar');
	var heigthCa = $(tableCalen).height();
	$(currentTo).css('margin-top', '-' + (heigthCa + 40) + 'px');
});

$(document).ready(function() {

	/* close de consultas */
	$('.close-button').click(function() {
		var parent = $(this).parents('.operation-tabs');
		parent.find('.active').removeClass('active');
	});

	/* Quitar estilo de tabs de consultas */
	$('#headerTab').click(function() {
		$(this).removeClass('setStyle');
	});

	/* Exception blur combos */
	$('.ui-selectonemenu').mouseup(function(event) {
		event.stopPropagation();
	});

	$(document).delegate('body', 'mouseup', function() {
		$('.ui-selectonemenu').removeClass('open');
		$('.ui-selectonemenu').children('.ui-selectonemenu-label').removeClass('open');
		$('.ui-selectonemenu').children('.ui-selectonemenu-trigger').removeClass('open');
	});

	$(document).delegate('.ui-selectonemenu-panel', 'mouseup', function(event) {
		event.stopPropagation();
	});

	$(document).delegate('.ui-selectonemenu-items-wrapper', 'mouseup', function(event) {
		event.stopPropagation();
	});

	$(document).delegate('.ui-selectonemenu-item', 'mouseup', function(event) {
		if (event.which === 1) {
			$('.ui-selectonemenu').removeClass('open');
			$('.ui-selectonemenu').children('.ui-selectonemenu-label').removeClass('open');
			$('.ui-selectonemenu').children('.ui-selectonemenu-trigger').removeClass('open');
		} else {
			event.stopPropagation();
		}
	});

	$(document).delegate('.ui-selectonemenu', 'keyup', function(event) {
		if (event.keyCode === 13) {
			$('.ui-selectonemenu').removeClass('open');
			$('.ui-selectonemenu').children('.ui-selectonemenu-label').removeClass('open');
			$('.ui-selectonemenu').children('.ui-selectonemenu-trigger').removeClass('open');
		}
	});

	/* Events Combo Like */
	$(document).delegate('.comboLike .ui-selectonemenu', 'click', function(event) {
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
			$(dat).children('.ui-selectonemenu-trigger').removeClass('open');
			$(dat).children('.ui-selectonemenu-label').removeClass('open');
			$(dat).removeClass('open');
		}

		if (!$(this).hasClass('open')) {
			$(this).addClass('open');
			$(this).children('.ui-selectonemenu-label').addClass('open');
			$(this).children('.ui-selectonemenu-trigger').addClass('open');
		} else {
			$(this).removeClass('open');
			$(this).children('.ui-selectonemenu-label').removeClass('open');
			$(this).children('.ui-selectonemenu-trigger').removeClass('open');
		}
	});

	$('.comboLike').children('.ui-selectonemenu').one("click", function() {
		var comboItems = $('#' + this.id.replace(/:/g, '\\:') + '_panel');
		var selectItems = $(comboItems).children('.ui-selectonemenu-items-wrapper');
		$(selectItems).before("<div style='width:" + (249 - $(this).width()) + "px;' class='likeBord'/>");
		$(selectItems).before("<div style='width:" + ($(this).width() + 10) + "px;' class='likeDif'/>");
	});

	$(document).delegate('.selectorCombo .ui-selectonemenu', 'click', function(event) {
		var actual = $(this);
		var parent = $(this).parents('.selectorCombo');
		var comboItems = $('#' + this.id.replace(/:/g, '\\:') + '_panel');
		var selecItems = $(comboItems).children('.ui-selectonemenu-items-wrapper');
		var ulSelect = $(selecItems).children('.ui-selectonemenu-items');
		var selectDisa = $(ulSelect).children('.ui-selectonemenu-item.ui-state-disabled');
		var dat = $('.selectorCombo .ui-selectonemenu.open');

		$(comboItems).css({
			'top' : ($(this).offset().top + 30) + 'px',
			'width' : ($(parent).width()) + 'px'
		});

		$(selectDisa).each(function() {
			$(this).text('');
			$(this).css("padding", "0px");
		});

		$(dat).each(function() {
			if ((dat).attr('id') != $(actual).attr('id')) {
				$(dat).removeClass('open');
				$(dat).children('.ui-selectonemenu-label').removeClass('open');
				$(dat).children('.ui-selectonemenu-trigger').removeClass('open');
			}
		});

		if (!$(this).hasClass('open')) {
			$(this).addClass('open');
			$(this).children('.ui-selectonemenu-label').addClass('open');
			$(this).children('.ui-selectonemenu-trigger').addClass('open');
		} else {
			$(this).removeClass('open');
			$(this).children('.ui-selectonemenu-label').removeClass('open');
			$(this).children('.ui-selectonemenu-trigger').removeClass('open');
		}
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
		if (styleBody >= 1) {
			$('#modal').remove();
		}
	});

	$('#tabsOperations li').each(function(event) {
		var sdas = $(this).attr('data-origin-value');
		var div = "<div class='tooltip-arrow' /><div class='tooltip-inner' style='font-size: 11px !important;'>" + $(this).attr('data-original-title') + "</div>";
		if (sdas == 'false') {
			$(this).children('.tab-head').addClass('buttonDisabled');

			$(this).hover(function() {
				$(this).prepend("<div style='display: block; top: -87px; left: -3px; z-index: 10000;' id='" + $(this).attr('id') + "tooltip' class='tooltip fade top in' role='tooltip'>" + div + " </div>");
			}, function() {
				$(this).children('.tooltip').remove();
			});
		}
	});
});

function localize() {
	/* Si se puede obtener la localización */
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(mapa, error);
	}
	/* Si el navegador no soporta la recuperación de la geolocalización */
	else {
		alert('¡Oops! Tu navegador no soporta geolocalización.');
	}
}

function mapa(pos) {
	/* Obtenemos los parámetros de la API de geolocalización HTML */
	var latitud = pos.coords.latitude;
	var longitud = pos.coords.longitude;
	var precision = pos.coords.accuracy;

	/* A través del DOM obtenemos el div que va a contener el mapa */
	var contenedor = document.getElementById("map")

	/*
	 * Posicionamos un punto en el mapa con las coordenadas que nos ha
	 * proporcionado la API
	 */
	var centro = new google.maps.LatLng(latitud, longitud);

	/* Definimos las propiedades del mapa */
	var propiedades = {
		zoom : 15,
		center : centro,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	/*
	 * Creamos el mapa pasandole el div que lo va a contener y las diferentes
	 * propiedades
	 */
	var map = new google.maps.Map(contenedor, propiedades);

	/*
	 * Un servicio que proporciona la API de GM es colocar marcadores sobre el
	 * mapa
	 */
	var marcador = new google.maps.Marker({
		position : centro,
		map : map,
		title : "Tu localizacion"
	});
}

/* Gestion de errores */
function error(errorCode) {
	if (errorCode.code == 1)
		alert("No has permitido buscar tu localizacion")
	else if (errorCode.code == 2)
		alert("Posicion no disponible")
	else
		alert("Ha ocurrido un error")
}

function imgError(image) {
	$(document).ready(function() {
		var imgWidth = $(image).attr("width");
		var imgHeight = $(image).attr("height");
		if (typeof imgWidth !== 'undefined' && typeof imgHeight !== 'undefined') {
			$(image).parents('.banner').css("cssText", "display: block !important;");
			return true;
		} else {
			$(image).parents('.banner').css("cssText", "display: none !important;");
			return false;
		}
	});
}

/* funcion que me genera la impresion de una segmento de pagina */

function imprimir(muestra) {
	var ficha = document.getElementById(muestra);
	var ventimp = window.open(' ', 'popimpr');
	ventimp.document.write(ficha.innerHTML);
	ventimp.document.close();
	ventimp.print();
	ventimp.close();
}

function start() {
}
