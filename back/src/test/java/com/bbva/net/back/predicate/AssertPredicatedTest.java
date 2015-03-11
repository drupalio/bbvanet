package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bbva.net.back.model.globalposition.ProductDto;

public class AssertPredicatedTest {

	@Test
	public void checkAssetPredicatedTrue() {

		// Check Null
		final AssetPredicated assetPredicated = new AssetPredicated();
		assertTrue(assetPredicated.eval(null));

		final ProductDto productDto = new ProductDto();
		// Check asset Null
		assertTrue(assetPredicated.eval(productDto));

		// Check asset true
		productDto.setAsset(true);
		assertTrue(assetPredicated.eval(productDto));
	}

	@Test
	public void checkAssetPredicatedFalse() {

		final AssetPredicated assetPredicated = new AssetPredicated();

		// Check asset false
		final ProductDto productDto = new ProductDto();
		productDto.setAsset(false);
		assertFalse(assetPredicated.eval(productDto));

	}
}
