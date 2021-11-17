package com.example.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        /*
         * Create some products to add and remove from order
         */
        Product p1 = new Product(1, "Wooden Chair", ProductCategory.CHAIR, new BigDecimal(30));
        Product p2 = new Product(2, "Plastic Table", ProductCategory.TABLE, new BigDecimal(25));
        Product p3 = new Product(3, "Wooden Desk", ProductCategory.DESK, new BigDecimal(50));
        Product p4 = new Product(4, "Steel Chair", ProductCategory.CHAIR, new BigDecimal(40));

        Order o1 = new Order(1, "John");
        o1.addItem(p1);
        o1.addItem(p1);
        o1.addItem(p1);
        o1.addItem(p1);
        o1.addItem(p2);
        o1.removeItem(p1);

        displayOrderContents(o1);
        applyCustomerDiscounts(o1);
        displayOrderContents(o1);
    }

    /*
     * method to display the contents of the order
     */
    private static void displayOrderContents(Order order)
    {
        System.out.println(String.format("Customer id: %s -----   Order id: %s", order.getCustomerName(), order.getOrderId()));
        order.getItems().values()
            .forEach(o -> System.out.println(String.format("%s ..... %s ..... x %s ..... - %s ..... = %s",
                    o.getProductName(),
                    o.getStandardPrice(),
                    o.getQuantity(),
                    o.getAppliedDiscount(),
                    o.getStandardPrice().multiply(new BigDecimal(o.getQuantity())).subtract(o.getAppliedDiscount()))));
        System.out.println("===================================================");
        System.out.println("");
    }
    /*
     * method that calculate and applies discounts for an order based on the customer agreement
     */
    private static void applyCustomerDiscounts(Order order)
    {
        Customer customer = getCustomers().stream()
            .filter(c -> c.getCustomerName().equals(order.customerName))
            .findFirst()
            .orElse(null);

        if (customer != null)
        {
            customer.getDiscountAgreements().stream()
                .forEach(discount -> discount.applyDiscount(order));
        }
    }

    private static List<Customer> getCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        Customer c1 = new Customer("John");
        c1.getDiscountAgreements().add(new ProductDiscountAgreement(1,new BigDecimal(10)));
        c1.getDiscountAgreements().add(new ProductDiscountAgreement(1,new BigDecimal(9)));
        c1.getDiscountAgreements().add(new TotalDiscountAgreement(new BigDecimal(8)));
        c1.getDiscountAgreements().add(new BulkDiscountAgreement(1, 4, 2));

        customers.add(c1);
        return customers;
    }
}
