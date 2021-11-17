package com.example.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductDiscountAgreement extends DiscountAgreement {
    int productId;
    BigDecimal percentDiscount;

    public ProductDiscountAgreement(int productId,
                                    BigDecimal percentDiscount)
    {
        this.productId = productId;
        this.percentDiscount = percentDiscount;
    }

    /*
     * method that tries to apply a percent discount on a certain product if no higher discount is currently applied
     */
    public void applyDiscount(Order order)
    {
        CartItem item = order.getItems().get(productId);
        if (item != null)
        {
            BigDecimal discount = item.getStandardPrice()
                    .multiply(new BigDecimal(item.getQuantity()))
                    .multiply(percentDiscount)
                    .divide(new BigDecimal(100), RoundingMode.UP);

            if (discount.compareTo(item.getAppliedDiscount()) > 0)
            {
                item.setAppliedDiscount(discount);
            }
        }
    }
}
