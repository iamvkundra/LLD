package com.vmware.ensemble.rules.i18n;

import com.vmware.ensemble.rules.i18n.coupons.CouponNEXT;
import com.vmware.ensemble.rules.i18n.coupons.CouponNTH;
import com.vmware.ensemble.rules.i18n.enums.ProductType;
import com.vmware.ensemble.rules.i18n.models.Product;
import com.vmware.ensemble.rules.i18n.services.ShoppingCartService;

public class Main {
    public static void main(String[] args) {
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        shoppingCartService.addItem(new Product(ProductType.FURNITURE, 0));
        shoppingCartService.addItem(new Product(ProductType.ELECTRONICS, 0));

        shoppingCartService.addItem(new CouponNEXT(10, ProductType.FURNITURE));

        shoppingCartService.addItem(new Product(ProductType.FURNITURE, 2100));
        shoppingCartService.addItem(new Product(ProductType.FURNITURE, 0));


        shoppingCartService.addItem(new CouponNTH(10, ProductType.FURNITURE, 2));

        System.out.println(shoppingCartService.checkOut());
    }
}