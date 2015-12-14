/**
 *
 */
package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.CheckBookMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.mapper.converter.StringToDateConverter;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;

/**
 * @author User
 */

@Mapper(value = "checkBookMapper")
public class CheckBookMapperImpl extends ConfigurableMapper implements CheckBookMapper {
    
    @Override
    protected void configure(final MapperFactory factory) {
        
        // Add Money Converter
        factory.getConverterFactory().registerConverter(new MoneyConverter());
        
        // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
        factory.getConverterFactory().registerConverter(new StringToDateConverter("yyyy-MM-dd"));
        // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
        
        // Map Check DTO
        factory.classMap(Check.class, CheckDto.class).field("id", "id").field("issueDate", "issueDate")
                .field("value", "value").field("status", "status").field("modifiedDate", "modifiedDate").byDefault()
                .register();
        
        // Map CheckBook DTO
        factory.classMap(Checkbook.class, CheckbookDto.class).field("id", "id").field("firstCheck", "firstCheck")
                .field("lastCheck", "lastCheck").field("totalCheck", "totalCheck").field("requestDate", "requestDate")
                .field("deliveryDate", "deliveryDate").field("actualState", "actualState").field("checks", "checks")
                .byDefault().register();
        
    }
    
    @Override
    public List<CheckbookDto> mapCheckBookList(List<Checkbook> checkbook) {
        final List<CheckbookDto> checkBookList = mapAsList(checkbook, CheckbookDto.class);
        return checkBookList;
    }
    
    // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
    @Override
    public CheckbookDto mapCheckBookDto(Checkbook checkBook) {
        final CheckbookDto checkbookDto = map(checkBook, CheckbookDto.class);
        return checkbookDto;
    }
    
    // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
    
    @Override
    public CheckDto mapCheck(Check check) {
        final CheckDto checkDto = map(check, CheckDto.class);
        return checkDto;
    }
    
    @Override
    public List<CheckDto> mapCheckList(List<Check> check) {
        final List<CheckDto> checksList = mapAsList(check, CheckDto.class);
        return checksList;
    }
}