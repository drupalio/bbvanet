'use strict';

(function($) {

    $(document).ready(function () {

        var tableGroup = $('.detail-table-group'),
            table = tableGroup.find('.detail-table-body'),
            columns = table.find('th'),
            tableBody = table.find('tbody'), 
            moreBtn = tableGroup.find('.btn-more-results');
            
        moreBtn.click(function () {
            tableBody.children().not('.detail-row').slice(0, 10).clone().appendTo(tableBody);
        });
    
        columns.each(function (index, value) {

            columns.eq(index).click( function () {
                var header = $(this);
                    
                if (!header.hasClass('sorted')) {
                    columns.filter('.sorted').toggleClass('sorted');
                    header.toggleClass('sorted');
                }
                
                header.toggleClass('desc').toggleClass('asc');
               
                return false;
            });

        });

    });
    
})(jQuery);
