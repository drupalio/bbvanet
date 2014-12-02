$.fn.selectquiero = function(configItems){
	var itemSelect = configItems;

	var ControlSelect = function(containerSelect){
		var createCode = function(){
			var code = 	'<button type="button" class="btn dropdown-toggle btn-default">';
			code +=		'	<span class="background-btn"><span class="pull-left">Quiero</span>&nbsp;<span class="caret"></span></span>';
			code +=		'</button>';
			code +=		'<div class="dropdown-menu open">';
			code +=		'	<ul class="dropdown-menu inner" role="menu">';

			$.each(itemSelect, function(key, item){
				code += '		<li class="'+item.className+'">';
				code += '			<a href="'+item.href+'">'+item.label+'</a>';
				code += '		</li>';
			});
			code +=		'	</ul>';
			code +=		'</div>';

			return code;
		};

		var addCode = function(){
			containerSelect.append(createCode());
		};

		return{
			addCode: addCode
		};
	};

	new ControlSelect($(this)).addCode();



	$(this).find('button').on('click',function() {
		$(this).next().find('.dropdown-menu').slideToggle(400, function(){
			

			if(!$(this).is(':visible'))
				$(this).closest('.select-tab-quiero').removeClass('open');
			


		});
		
		if(!$(this).parent().hasClass('open'))
			$(this).parent().addClass('open');
		
	});
	


	$(this).find('button').next().show(0).find('.dropdown-menu').hide(0);
	return this;
};

$(window).on('load', function () {
	var itemsToSelectQuiero = [
		{className: '', href: './savingsAccount.html', title: 'Ir a ...', label: 'Ver saldos y movimientos'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Realizar transferencias'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Gestionar transferencias'}
	];
	var selectsQuiero = $('.select-tab-quiero-default');
	selectsQuiero.each(function(){
		$(this).selectquiero(itemsToSelectQuiero);
	});
	
    var itemsToSelectQuiero = [
        {className: '', href: './acquireAccount.html', title: 'Ir a ...', label: 'Ver saldos y movimientos'}, 
        {className: '', href: '#', title: 'Ir a ...', label: 'Realizar transferencias'}, 
        {className: '', href: '#', title: 'Ir a ...', label: 'Gestionar transferencias'}
    ];
    var selectsQuiero = $('.select-tab-quiero-acquire');
    selectsQuiero.each(function(){
        $(this).selectquiero(itemsToSelectQuiero);
    });

	var itemsToSelectQuiero = [
		{className: '', href: './cupo.html', title: 'Ir a ...', label: 'Ver movimientos'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Pagar préstamo'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Domiciliar préstamos'}
	];
	var selectsQuiero = $('.select-tab-quiero-cupo');
	selectsQuiero.each(function(){
		$(this).selectquiero(itemsToSelectQuiero);
	});


	var itemsToSelectQuiero = [
		{className: '', href: './cupo.html', title: 'Ir a ...', label: 'Ver movimientos'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Pagar préstamo'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Domiciliar préstamos'}
	];
	var selectsQuiero = $('.select-tab-quiero-loans');
	selectsQuiero.each(function(){
		$(this).selectquiero(itemsToSelectQuiero);
	});

	var itemsToSelectQuiero = [
		{className: '', href: './cards.html', title: 'Ir a ...', label: 'Ver movimientos'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Bloquear tarjeta'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Pagar compras'}
	];
	var selectsQuiero = $('.select-tab-quiero-cards');
	selectsQuiero.each(function(){
		$(this).selectquiero(itemsToSelectQuiero);
	});

	var itemsToSelectQuiero = [
		{className: '', href: './depositos.html', title: 'Ir a ...', label: 'Ver movimientos'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Renovar mis depósitos'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Rescatar mis depósitos'}
	];
	var selectsQuiero = $('.select-tab-quiero-deposits');
	selectsQuiero.each(function(){
		$(this).selectquiero(itemsToSelectQuiero);
	});

	var itemsToSelectQuiero = [
		{className: '', href: './fondos.html', title: 'Ir a ...', label: 'Ver saldos y movimientos'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Invertir en este fondo mutuo'}, 
		{className: '', href: '#', title: 'Ir a ...', label: 'Rescatar'},
		{className: '', href: '#', title: 'Ir a ...', label: 'Reinvertir a otro fondo mutuo'}
	];
	var selectsQuiero = $('.select-tab-quiero-funds');
	selectsQuiero.each(function(){
		$(this).selectquiero(itemsToSelectQuiero);
	});

});