package com.vmware.ensemble.rules.i18n.decorator;

import com.vmware.ensemble.rules.i18n.products.Product;

public abstract class AddOnDecorator extends Product {
    public AddOnDecorator(String productId, String productName) {
        super(productId, productName);
    }
}
