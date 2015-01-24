package com.bbva.net.back.mapper.factory;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.ObjectFactory;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.CreditCardDto;
import com.bbva.net.back.model.globalposition.DepositDto;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;
import com.bbva.net.back.utils.ProductUtils;

/**
 * @author Entelgy
 */
public class ProductDTOFactory implements ObjectFactory<ProductDto> {

	/**
	 * 
	 */
	@Override
	public ProductDto create(Object source, MappingContext mappingContext) {

		ProductDto productDto = null;
		final Product product = (Product)source;

		switch (ProductUtils.getEnumProductTypeBySubType(product.getType())) {
		case PC:
			productDto = new AccountDto();
			break;
		case AQ:
			productDto = new AdquirenceAccountDto();
			break;
		case TC:
			productDto = new CreditCardDto();
			break;
		case RQ:
			productDto = new RotatingAccountDto();
			break;
		case LI:
			productDto = new LeasingDto();
			break;
		case LO:
			productDto = new LoanDto();
			break;
		case SI:
			productDto = new FundDto();
			break;
		case ED:
			productDto = new DepositDto();
			break;
		default:
			break;
		}
		
		productDto.setTypeProd(ProductUtils.getEnumProductTypeBySubType(product.getType()));

		return productDto;
	}

}
