package com.bbva.net.back.service.impl;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.DateFilterService;

/**
 * Clase que implementa el método para calcular periodo en filtros
 *
 * @author Entelgy
 */
@Service(value = "dateFilterService")
public class DateFilterServiceImpl implements DateFilterService {
    
    /**
     * Método encargado de calcular el periodo de consulta en un filtro
     */
    @Override
    public DateRangeDto getPeriodFilter(final EnumPeriodType comboFilter) {
        
        DateRangeDto dateRange = new DateRangeDto();
        final Date currentDate = new Date();
        
        // <!-- Entelgy / SPRING 3 / 26102015 / INICIO -->
        if ( comboFilter != null ) {
            
            switch (comboFilter) {
                case YESTERDAY:
                    dateRange.setDateSince(DateUtils.addDays(currentDate,
                            EnumPeriodType.YESTERDAY.getQuantityPeriod()));
                    break;
                case TODAY:
                    dateRange.setDateSince(currentDate);
                    break;
                case LAST_WEEK:
                    dateRange.setDateSince(DateUtils.addWeeks(currentDate,
                            EnumPeriodType.LAST_WEEK.getQuantityPeriod()));
                    break;
                case LAST_TWO_WEEK:
                    dateRange.setDateSince(DateUtils.addWeeks(currentDate,
                            EnumPeriodType.LAST_TWO_WEEK.getQuantityPeriod()));
                    break;
                case LAST_MONTH:
                    dateRange.setDateSince(DateUtils.addMonths(currentDate,
                            EnumPeriodType.LAST_MONTH.getQuantityPeriod()));
                    break;
                case LAST_45_DAYS:
                    dateRange.setDateSince(DateUtils.addDays(currentDate,
                            EnumPeriodType.LAST_45_DAYS.getQuantityPeriod()));
                    break;
                case LAST_TWO_MONTH:
                    dateRange.setDateSince(DateUtils.addMonths(currentDate,
                            EnumPeriodType.LAST_TWO_MONTH.getQuantityPeriod()));
                    break;
                case LAST_THREE_MONTH:
                    dateRange.setDateSince(DateUtils.addMonths(currentDate,
                            EnumPeriodType.LAST_THREE_MONTH.getQuantityPeriod()));
                    break;
                case LAST_SIX_MONTH:
                    dateRange.setDateSince(DateUtils.addMonths(currentDate,
                            EnumPeriodType.LAST_SIX_MONTH.getQuantityPeriod()));
                    break;
                case LAST_TWELVE_MONTH:
                    dateRange.setDateSince(DateUtils.addMonths(currentDate,
                            EnumPeriodType.LAST_TWELVE_MONTH.getQuantityPeriod()));
                    break;
                case LAST_ALL_OLD:
                    dateRange.setDateSince(DateUtils.addYears(currentDate,
                            EnumPeriodType.LAST_ALL_OLD.getQuantityPeriod()));
                    break;
            }
        }
        return dateRange;
    }
    // <!-- Entelgy / SPRING 3 / 26102015 / FIN -->
}
