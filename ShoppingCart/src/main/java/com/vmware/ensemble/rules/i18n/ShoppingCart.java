package com.vmware.ensemble.rules.i18n;

import com.vmware.ensemble.rules.i18n.decorator.ProductTypeDiscountCoupon;
import com.vmware.ensemble.rules.i18n.products.ElectricProduct;
import com.vmware.ensemble.rules.i18n.products.FurnitureProduct;
import com.vmware.ensemble.rules.i18n.products.Product;

public class ShoppingCart {
    public static void main(String[] args) {
        System.out.println("-----------------------------------SHOPPING CART--------------------------------------");
        Cart cart = new Cart();

        Product chair = new ProductTypeDiscountCoupon(new FurnitureProduct("Chair", 1000));
        Product table = new ProductTypeDiscountCoupon(new FurnitureProduct("Table", 1000));
        Product watch = new ProductTypeDiscountCoupon(new ElectricProduct("Watch", 2500));

        cart.addProduct(chair);
        cart.addProduct(table);
        cart.addProduct(watch);

        System.out.println("Cart Total Price: "+ cart.getTotalCartPrice());

        cart.removeProduct(watch.getProductId());

        System.out.println("Cart Total Price: "+ cart.getTotalCartPrice());

    }
}