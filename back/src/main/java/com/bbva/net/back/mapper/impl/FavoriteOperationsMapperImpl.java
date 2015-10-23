package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.eiaq.commons.v01.Destination;
import com.bbva.eiaq.commons.v01.Origin;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.FavoriteOperationsMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.mapper.converter.StringToDateConverter;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.core.pattern.VisitorCommand;
import com.bbva.zic.agileoperations.v01.AgileOperation;

/**
 * @author Entelgy
 */
@Mapper(value = "favoriteOperationsMapper")
public class FavoriteOperationsMapperImpl extends ConfigurableMapper implements FavoriteOperationsMapper {

    // <!-- Entelgy / GP13137 / 22102015 / INICIO -->
    /**
     *
     */
    @Override
    protected void configure(final MapperFactory factory) {

        factory.getConverterFactory().registerConverter(new MoneyConverter());
        factory.getConverterFactory().registerConverter(new StringToDateConverter("yyyy-MM-dd HH:MM:SS"));

        // Map AgileOperation to FavoriteOperationDto
        factory.classMap(AgileOperation.class, FavoriteOperationDto.class).field("contractId", "contractId")
        .field("amount", "amount").field("id", "idOperation").field("name", "name")
        .field("transactionDate", "transactionDate").field("transactionReference", "transactionReference")
        .field("origin.cardNumber.number", "numberOrigin").field("origin.ccc.bankCode", "bankCodeOrigin")
        .field("origin.ccc.branchCode", "branchCodeOrigin").field("origin.ccc.controlDigit", "controlDigitOrigin")
        .field("origin.ccc.accountNumber", "accountNumberOrigin").field("origin.clabe.bankCode", "bankCodeOrigin")
        .field("origin.clabe.regionCode", "regionCodeOrigin").field("origin.clabe.accountNumber", "accountNumberOrigin")
        .field("origin.clabe.controlDigit", "controlDigitOrigin").field("origin.mobilePhoneNumber.number", "numberOrigin")
        .field("origin.creditNumber.number", "numberOrigin").field("destination.cardNumber.number", "numberDest")
        .field("destination.ccc.bankCode", "bankCodeDest").field("destination.ccc.branchCode", "branchCodeDest")
        .field("destination.ccc.controlDigit", "controlDigitDest").field("destination.ccc.accountNumber", "accountNumberDest")
        .field("destination.clabe.bankCode", "bankCodeDest").field("destination.clabe.regionCode", "regionCodeDest")
        .field("destination.clabe.accountNumber", "accountNumberDest").field("destination.clabe.controlDigit", "controlDigitDest")
        .field("destination.mobilePhoneNumber.number", "numberDest").field("destination.creditNumber.number", "numberDest")
        .byDefault().register();
    }

    @Override
    public AgileOperation map(FavoriteOperationDto favOperation) {
        AgileOperation agileOperation = map(favOperation, AgileOperation.class);
        return agileOperation;
    }

    /**
     * Mapper of Favorite Operations
     */
    @Override
    public List<FavoriteOperationDto> map(final List<AgileOperation> favOperations) {
        final List<FavoriteOperationDto> favOperationsDto = new ArrayList<FavoriteOperationDto>();

        new VisitorCommand<AgileOperation>(favOperations) {

            FavoriteOperationDto fav;

            @Override
            public void execute(final AgileOperation operation) {
                fav = new FavoriteOperationDto();
                fav = map(operation, FavoriteOperationDto.class);
                fav.setOrigin(getNameClassOrigin(operation.getOrigin()));
                fav.setDestination(getNameClassDestination(operation.getDestination()));
                favOperationsDto.add(fav);
            }
        };
        return favOperationsDto;
    }

    /**
     * Asigna tipo de origen
     *
     * @param origen
     * @return
     */
    public String getNameClassOrigin(final Origin origen) {
        String tipoOrigen = "";
        if ( origen.getCardNumber() != null ) {
            tipoOrigen = "cardNumber";
        }
        if ( origen.getCcc() != null ) {
            tipoOrigen = "ccc";
        }
        if ( origen.getClabe() != null ) {
            tipoOrigen = "clabe";
        }
        if ( origen.getCreditNumber() != null ) {
            tipoOrigen = "creditNumber";
        }
        if ( origen.getMobilePhoneNumber() != null ) {
            tipoOrigen = "mobilePhoneNumber";
        }
        return tipoOrigen;
    }

    /**
     * Asigna tipo de destino
     *
     * @param destination
     * @return
     */
    public String getNameClassDestination(final Destination destination) {
        String tipoDestination = "";
        if ( destination.getCardNumber() != null ) {
            tipoDestination = "cardNumber";
        }
        if ( destination.getCcc() != null ) {
            tipoDestination = "ccc";
        }
        if ( destination.getClabe() != null ) {
            tipoDestination = "clabe";
        }
        if ( destination.getCreditNumber() != null ) {
            tipoDestination = "creditNumber";
        }
        if ( destination.getMobilePhoneNumber() != null ) {
            tipoDestination = "mobilePhoneNumber";
        }
        return tipoDestination;
    }
    // <!-- Entelgy / GP13137 / 22102015 / FIN -->
}
