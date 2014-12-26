package com.bbva.net.back.mapper.factory;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.ObjectFactory;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDTO;
import com.bbva.net.back.model.globalposition.CreditCardDTO;
import com.bbva.net.back.model.globalposition.DepositDTO;
import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;

/**
 * @author Entelgy
 */
public class ProductDTOFactory implements ObjectFactory<ProductDTO> {

	/**
	 * 
	 */
	@Override
	public ProductDTO create(Object source, MappingContext mappingContext) {

		ProductDTO productDto = null;
		final Product product = (Product)source;

		switch (product.getType()) {
		case PC:
			productDto = new AccountDTO();
			break;
		case AQ:
			productDto = new AdquirenceAccountDTO();
			break;
		case TDC:
			productDto = new CreditCardDTO();
			break;
		case RQ:
			productDto = new RotatingAccountDTO();
			break;
		case LI:
			productDto = new LeasingDTO();
			break;
		case LO:
			productDto = new LoanDTO();
			break;
		case SI:
			productDto = new FundDTO();
			break;
		case ED:
			productDto = new DepositDTO();
			break;
		default:
			break;
		}

		return productDto;
	}

}
