package com.bbva.net.back.model.globalposition;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ProductDtoTest extends AbstractBbvaDTOTest<ProductDto> {

    private ProductDto product;

    public ProductDtoTest() {
        this.product = new ProductDto();
        getAndSet();
        this.product = new ProductDto("10172689182791776545", "Account", "10172689182791776545", true, false, true,
                "Account Home", new Money(), new Money(), new Money(), "23123213", "Fund", EnumProductType.PC);
        getAndSet();
    }

    @Override
    protected ProductDto getInstance() {
        return new ProductDto();
    }

    public void getAndSet() {
        this.product.isSetProductId();
        this.product.isSetProductName();
        this.product.isSetProductNumber();
        this.product.isSetAlias();
        this.product.isSetTotalCash();
        this.product.isSetCashAvailable();
        this.product.isSetAsset();
        this.product.isVisible();
        this.product.isAsset();
    }

    /**
     * Invoke Equals Method
     */
    @Override
    public void checkEqualsMethod() {
        // Inicializar entrada
        ProductDto productInEquals = new ProductDto();
        // Cuando el objeto es nulo
        this.product.equals(null);
        // Cuando el dto comparado no es el mismo
        this.product.equals(new MovementCriteriaDto());
        // Caso exitoso
        productInEquals.setProductId("10172689182791776545");
        this.product.equals(productInEquals);
        // el id del objeto es diferente
        productInEquals.setProductId("10172689182791776543");
        this.product.equals(productInEquals);
        // Cuando el id del objeto entrante es nulo
        productInEquals.setProductId(null);
        this.product.equals(productInEquals);
        // Cuando el id global es nulo
        this.product.setProductId(null);
        this.product.equals(productInEquals);
    }
}