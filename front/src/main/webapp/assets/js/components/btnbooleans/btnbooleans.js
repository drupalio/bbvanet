$.fn.btnbooleans = function(){
    var btn = $(this);
    var btnContent = btn.closest('.buttons');
    var radioBtn = btn.find('[type="radio"]');

    var changeActive = function(){
        btnContent.find('.active').removeClass('active');
        if(radioBtn.is(':checked')){
            btn.addClass('active');
        }
    }

    btn.click(function(){
        changeActive();
    });
    return btn;
};