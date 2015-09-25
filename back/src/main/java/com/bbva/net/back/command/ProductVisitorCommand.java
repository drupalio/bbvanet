package com.bbva.net.back.command;

import java.util.List;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.utils.ProductUtils;
import com.bbva.net.core.pattern.VisitorCommand;

public abstract class ProductVisitorCommand extends VisitorCommand<Product> {

    public ProductVisitorCommand(List<Product> list) {
        super(list);
    }

    /************************************ ABSTRACT METHODS **********************************/

    /**
     * @param account
     */
    public abstract void executeAccount(final Product account);

    /**
     * @param adquirenceAccount
     */
    public abstract void executeAdquirenceAccount(final Product adquirenceAccount);

    /**
     * @param product
     */
    public abstract void executeCredictCard(final Product product);

    /**
     * @param product
     */
    public abstract void executeRotatingAccount(final Product product);

    /**
     * @param product
     */
    public abstract void executeLeasing(final Product product);

    /**
     * @param product
     */
    public abstract void executeLoan(final Product product);

    /**
     * @param product
     */
    public abstract void executeFund(final Product product);

    /**
     * @param product
     */
    public abstract void executeDeposit(final Product product);

    /**
     *
     */
    @Override
    protected void execute(Product product) {

        if (product.getType() != null) {
            
            switch (ProductUtils.getEnumProductTypeBySubType(product.getType())) {
                case PC:
                    this.executeAccount(product);
                    break;
                case AQ:
                    this.executeAdquirenceAccount(product);
                    break;
                case TC:
                    this.executeCredictCard(product);
                    break;
                case RQ:
                    this.executeRotatingAccount(product);
                    break;
                case LI:
                    this.executeLeasing(product);
                    break;
                case LO:
                    this.executeLoan(product);
                    break;
                case SI:
                    this.executeFund(product);
                    break;
                case ED:
                    this.executeDeposit(product);
                    break;
                default:
                    break;
            }
        }
    }

}
