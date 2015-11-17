package com.bbva.net.back.facade;

import java.util.List;
import java.util.Map;

import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;

/**
 * @author Entelgy
 */
public interface LoanFacade {

    // <!-- Entelgy / SPRING 3 / 17112015 / removeMethod -->

    /**
     * @return
     */
    List<LeasingDto> getLeasingByUser(final GlobalProductsDto globalProducts);

    /**
     * @return
     */
    List<LeasingDto> getLeasingByUserHidden(final GlobalProductsDto globalProducts);

    /**
     * @return
     */
    List<RotatingAccountDto> getRotatingAccountByUserHidden(final GlobalProductsDto globalProducts);

    /**
     * @return
     */
    List<RotatingAccountDto> getRotatingAccountByUser(final GlobalProductsDto globalProducts);

    /**
     * @return
     */
    List<LoanDto> getLoansByUser(final GlobalProductsDto globalProducts);

    /**
     * @return
     */
    List<LoanDto> getLoansByUserHidden(final GlobalProductsDto globalProducts);

    /**
     * @return
     */
    Map<String, BalanceDto> getLoanTotals(final GlobalProductsDto globalProducts);

}
