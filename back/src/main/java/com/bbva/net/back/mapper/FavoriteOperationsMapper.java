package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.zic.agileoperations.v01.AgileOperation;

public interface FavoriteOperationsMapper {

    /**
     * @param CardCharges
     * @return
     */
    List<FavoriteOperationDto> map(List<AgileOperation> favOperations);

    /**
     * @param favOperation
     * @return
     */
    AgileOperation map(FavoriteOperationDto favOperation);

}
