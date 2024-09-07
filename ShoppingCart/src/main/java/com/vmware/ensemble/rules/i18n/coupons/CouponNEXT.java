package com.vmware.ensemble.rules.i18n.coupons;

import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.CouponType;
import com.vmware.ensemble.rules.i18n.enums.DeductionType;
import com.vmware.ensemble.rules.i18n.enums.ProductType;
import com.vmware.ensemble.rules.i18n.interfaces.CartItem;
import com.vmware.ensemble.rules.i18n.models.Coupon;
import com.vmware.ensemble.rules.i18n.models.Product;



public class CouponNEXT extends Coupon {

    private final ProductType productType;

    public CouponNEXT(int discount, ProductType productType) {
        super(discount);
        this.productType = productType;
    }

    @Override
    public void applyCoupon(List<CartItem> cartItems, int currentIndexOfCartItem) {
        for (int index=currentIndexOfCartItem+1; index<cartItems.size(); index++) {
            CartItem cartItem = cartItems.get(index);
            if (!cartItem.isCoupon()) {
                Product product = (Product) cartItem;
                if (product.getProductType() == null || product.getProductType() == getProductType()) {
                    product.applyCoupon(this);
                    break;
                }
            }
        }
    }

    @Override
    public CouponType getCouponType() {
        return CouponType.NEXT;
    }

    @Override
    public DeductionType getDeductionType() {
        return DeductionType.PERCENTAGE;
    }

    public ProductType getProductType() {
        return productType;
    }
}
