'use strict';
$.fn.windowonrow = function(){
    var row = $(this);
    row.detailRow = null;
    row.close = null;
    var route = null;

    var makeDetailRow = function(){
        var addDetailRow = function(row, detailRow){
            row.after(detailRow);
        };
        var setEventClose = function(btn){
            btn.click(function(){
                new switchVisibility().closeDetail();
                return false;
            });
        }

        if($('section').hasClass('tab-savingAccount')) {
            route = './partials/account/savingsAccount/movements-detail.html';
        } else {
            route = './partials/account/acquireAccount/movements-detail.html';
        }

        var detailRow = $("<tr>", {class: "detail-row"});
        detailRow.load(route, addDetailRow(row, detailRow), function(){
            row.detailRow = row.next();
            row.close = row.detailRow.find('.table-detail-close');
            detailRow.find('td').show(0);
            setEventClose(row.close);
        });
    };

    var switchVisibility = function(){
        var deleteDetailRow = function(detailRowE){
            detailRowE.remove();
        };

        var setVisibleRow = function(rowE){
            rowE.show(0);
        };
        var setHiddenRow = function(rowE){
            rowE.hide(0);
        };

        var close = function(){
            deleteDetailRow(row.detailRow);
            setVisibleRow(row);
        }

        var resetRows = function(){
            var rows = row.closest('table').find('tr');
            var detailsRow = row.closest('table').find('.detail-row');
            setVisibleRow(rows);
            deleteDetailRow(detailsRow);
        }

        return{
            closeDetail: close,
            hideRow: setHiddenRow,
            resetRows: resetRows
        };
    };

    row.click(function(){
        var actionsVisibility = new switchVisibility();
        actionsVisibility.resetRows();
        makeDetailRow();
        actionsVisibility.hideRow(row);
    });

    this.closeAll = new switchVisibility().resetRows;

    return this;
};