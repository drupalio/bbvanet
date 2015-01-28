package com.bbva.net.back.mapper.impl;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.PersonalizeAccountProductMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.model.globalposition.ProductDto;

@Mapper(value = "personalizeProductMapper")
public class PersonalizeAccountProductMapperImpl extends ConfigurableMapper
		implements
			PersonalizeAccountProductMapper {

	public Product map(final ProductDto productDto) {
		Product product = new Product();
		product = map(productDto, Product.class);
		return product;
	}
	/**
	 *
	 */
	@Override
	protected void configure(MapperFactory factory) {

		factory.getConverterFactory().registerConverter(new MoneyConverter());
		// Map Loan QuotaDetailDto

		// Map parent Product DTO
		factory.classMap(ProductDto.class, Product.class)
				.field("alias", "alias").field("productId", "id")
				.field("operationOnline", "operable")
				.field("visible", "visible").byDefault().register();
	}
}
