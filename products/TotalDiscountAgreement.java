package com.example.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TotalDiscountAgreement extends DiscountAgreement {
    BigDecimal totalDiscount;

    public TotalDiscountAgreement(BigDecimal totalDiscount)
    {
        this.totalDiscount = totalDiscount;
    }

    /*
     * method that tries to apply a percent discount to all items in the cart if no higher discount is currently applied
     */
    public void applyDiscount(Order order)
    {
        order.getItems().values()
                .forEach(item -> {
                    BigDecimal discount = item.getStandardPrice()
                            .multiply(new BigDecimal(item.getQuantity()))
                            .multiply(totalDiscount)
                            .divide(new BigDecimal(100), RoundingMode.UP);
                    if (discount.compareTo(item.getAppliedDiscount()) > 0)
                    {
                        item.setAppliedDiscount(discount);
                    }
                });
    }
}
