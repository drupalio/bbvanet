'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};
orquidea.visibility.dropup = orquidea.visibility.dropup || {}

orquidea.visibility.dropup.mobile = function(){

  var loggedFooter = $('.logged-footer');
  var eventTrigger = loggedFooter.find('.dropdown-toggle');
  var executiveMenuTrigger = loggedFooter.find('.executive');
  var executiveSubMenu = executiveMenuTrigger.find('.dropdown-menu');
  var alertsMenuTrigger = loggedFooter.find('.alerts');
  var alertsSubMenu = alertsMenuTrigger.find('.dropdown-menu');

  eventTrigger.click(function() {

    $(this).next('.dropdown-menu').slideToggle(350,function() {
      
      if(alertsSubMenu.is(':visible')) {
          loggedFooter.addClass('alerts-submenu');
          executiveMenuTrigger.click(function() {
            loggedFooter.removeClass('alerts-submenu');
            alertsMenuTrigger.removeClass('open');
            alertsSubMenu.css('display','none');
            loggedFooter.addClass('executive-submenu');
          });
      } else {
        loggedFooter.removeClass('alerts-submenu');
      }

      if(executiveSubMenu.is(':visible')) {
          loggedFooter.addClass('executive-submenu');
          alertsMenuTrigger.click(function() {
            loggedFooter.removeClass('executive-submenu');
            executiveMenuTrigger.removeClass('open');
            executiveMenuTrigger.find('.dropdown-menu').css('display','none');
            loggedFooter.addClass('alerts-submenu');
          });
      } else {
        loggedFooter.removeClass('executive-submenu');
      }  

    });
  });

};