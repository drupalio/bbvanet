'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};
orquidea.visibility.dropdown = orquidea.visibility.dropdown || {}

orquidea.visibility.dropdown.mobile = function(){

    /* button variables */
    var mobileMenuBtn = $('.mobile-main-menu-button');
    var accessClientBtn = $('.mobile-menu .form-client-access-trigger');
    var initialBtn = $('.mobile-menu .initial-button');
    var searchBtn = $('.mobile-menu .search');

    /* dropdown variables */
    var mobileMenu = $('.mobile-menu');
    var accessDropdown = $('.mobile-menu .form-client-access').children('.dropdown-menu');
    var mainMenuDropdown = $('.main-items .dropdown .dropdown-toggle');

    /* other variables */
    var mobileScreen = 768;

    accessClientBtn.on('click', function() {
        if(accessDropdown.is(':hidden') && $(document).innerWidth() <= mobileScreen) {
            accessClientBtn.hide();
            initialBtn.hide();
            searchBtn.hide();
            $('.container-header').addClass('access-dropdown-mobile-visible');
            $('.mobile-menu').addClass('access-dropdown-mobile-visible');
        } 
    });


    mainMenuDropdown.on('click', function(event) {
        event.stopPropagation();
        $(this).next().slideToggle('slow', function(){
            if ($(this).is(':visible')) {
                $(this).prev().parent().addClass('open');
            } else {
                $(this).prev().parent().removeClass('open');
            }
        });
                
        $(this).closest('.main-items').find('.open .dropdown-toggle').next().slideUp('slow', function(){
            $(this).prev().parent().removeClass('open');
        });
    });


    mobileMenuBtn.on('click',function(event) {
        $('.form-client-access').removeClass('open');
        if(mobileMenu.is(':visible')) {
            accessDropdown.hide();
            $('.container-header').removeClass('access-dropdown-mobile-visible')
            $('.mobile-menu').removeClass('access-dropdown-mobile-visible');
        } else {
            accessClientBtn.show();
            initialBtn.show();
            searchBtn.show();
        }

    });

    $('.footer-menu .menu-trigger').on('click', function(event) {
        event.stopPropagation();
        $(this).next().slideToggle('slow', function(){
            if ($(this).is(':visible')) {
                $(this).prev().addClass('open');
            } else {
                $(this).prev().removeClass('open');
            }
        });
                
        $(this).closest('.row').find('.open').next().slideUp('slow', function(){
            $(this).prev().removeClass('open');
        });
    });
};
