/**
 *
 */
package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;

/**
 * @author User
 */
public interface CheckBookMapper {
    
    /**
     * @param CheckbookDto
     * @return List<CheckbookDto>
     */
    List<CheckbookDto> mapCheckBookList(final List<Checkbook> checkbook);
    
    /**
     * @param Check
     * @return List CheckDto
     */
    List<CheckDto> mapCheckList(final List<Check> check);
    
    /**
     * @param Check
     * @return List CheckDto
     */
    CheckDto mapCheck(final Check check);
    
    // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
    /**
     * @param checkBook
     * @return
     */
    CheckbookDto mapCheckBookDto(Checkbook checkBook);

    // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
    
}
