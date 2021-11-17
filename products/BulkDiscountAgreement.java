package com.example.products;

import java.math.BigDecimal;

public class BulkDiscountAgreement extends DiscountAgreement {
    int productId;
    int minProducts;
    int payForProducts;

    public BulkDiscountAgreement(int productId,
                                 int minProducts,
                                 int payForProducts)
    {
        this.productId = productId;
        this.minProducts = minProducts;
        this.payForProducts = payForProducts;
    }

    /*
     * method that checks if an order has more than a minimum number of products
     * If so, pay only for a certain quantity of that product
     */
    public void applyDiscount(Order order)
    {
        CartItem item = order.getItems().get(productId);
        if (item != null && item.getQuantity() >= minProducts)
        {
            BigDecimal discount = item.getStandardPrice()
                    .multiply(new BigDecimal(minProducts - payForProducts));
            if (discount.compareTo(item.getAppliedDiscount()) > 0)
            {
                item.setAppliedDiscount(discount);
            }
        }
    }
}
