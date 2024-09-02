package com.vmware.ensemble.rules.i18n.decorator;

import com.vmware.ensemble.rules.i18n.products.FurnitureProduct;
import com.vmware.ensemble.rules.i18n.products.Product;

public class ProductTypeDiscountCoupon extends AddOnDecorator {
    Product product;

    public ProductTypeDiscountCoupon(Product product) {
        super(product.getProductId(), product.getProductName());
        this.product = product;
    }

    @Override
    public long getPrice() {
        if (this.product instanceof FurnitureProduct) {
            return Math.round(this.product.getPrice() * 0.85); // 15% discount
        } else {
            return Math.round(this.product.getPrice() * 0.95); /// 5% discount
        }
    }
}
