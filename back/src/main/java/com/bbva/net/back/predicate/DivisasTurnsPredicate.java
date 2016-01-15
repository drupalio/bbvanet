/**
 *
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.turnsClient.turnsClientDetailDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class DivisasTurnsPredicate extends BbvaPredicate<turnsClientDetailDto> {

    private String typeBussiness;

    public DivisasTurnsPredicate(final String typeBussiness) {
        this.typeBussiness = typeBussiness;
    }

    /**
     * @param object
     * @return
     */
    @Override
    protected boolean eval(turnsClientDetailDto turns) {
        return turns != null && turns.getRates().getTypeBussiness() != null && turns.getRates().getTypeBussiness().equals(typeBussiness);
    }
}
