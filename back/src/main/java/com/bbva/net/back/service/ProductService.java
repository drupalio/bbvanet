/**
 *
 */
package com.bbva.net.back.service;

import java.util.List;
import java.util.Map;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public interface ProductService {
    
    /**
     * @param products
     * @return
     */
    <T extends ProductDto> Money getTotal(final List<T> products);
    
    /**
     * @param products
     * @return
     */
    <T extends ProductDto> Money getTotalAvailable(final List<T> products);
    
    /**
     * @param products
     * @return
     */
    
    <T extends ProductDto> List<String> getNameProduct(final List<T> products);
    
    /**
     * @param products
     * @return
     */
    Money getTotalAssets(List<ProductDto> products);
    
    /**
     * @param products
     * @return
     */
    Money getTotalFinanciacion(List<ProductDto> products);
    
    /**
     * @param products
     * @return
     */
    Money getTotalProductsByType(List<ProductDto> products, EnumProductType type);
    
    /***
     * @param globalProduct
     * @return
     */
    List<ProductDto> getProducts(GlobalProductsDto globalProducts);
    
    /**
     * @param globalProducts
     * @return
     */
    Map<String, BalanceDto> getTotals(GlobalProductsDto globalProducts);
    
    /**
     * @param globalProducts
     * @param predicate
     * @return
     */
    
    GlobalProductsDto select(final GlobalProductsDto globalProducts, BbvaPredicate<ProductDto> predicate);
    
    /**
     * @param globalProducts
     * @return
     */
    
    Map<String, List<String>> getProductsName(GlobalProductsDto globalProducts);
    
    // <!-- Entelgy / SPRING 3 / 17112015 / INICIO -->
    
    /**
     * @param products
     * @param subProductType
     * @return
     */
    Money getTotalProductsBySubType(List<ProductDto> products, String subProductType);
    
    /**
     * @param globalProducts
     * @return
     */

    Map<String, BalanceDto> getLoanTotals(final GlobalProductsDto globalProducts);
    
    /**
     * @param globalProducts
     * @return
     */
    Map<String, BalanceDto> getTotalsAccounts(final GlobalProductsDto globalProducts);
    
    // <!-- Entelgy / SPRING 3 / 17112015 / FIN -->
}
