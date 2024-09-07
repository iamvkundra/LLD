package com.vmware.ensemble.rules.i18n.coupons;

import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.CouponType;
import com.vmware.ensemble.rules.i18n.enums.DeductionType;
import com.vmware.ensemble.rules.i18n.enums.ProductType;
import com.vmware.ensemble.rules.i18n.interfaces.CartItem;
import com.vmware.ensemble.rules.i18n.models.Coupon;
import com.vmware.ensemble.rules.i18n.models.Product;

public class CouponNTH extends Coupon {

    private ProductType productType;
    private int offSet;

    public CouponNTH(int discount, ProductType productType, int offSet) {
        super(discount);
        this.productType = productType;
        this.offSet = offSet;
    }

    @Override
    public void applyCoupon(List<CartItem> cartItems, int currentIndexOfCartItem) {
        int index = 0;
        for (CartItem item : cartItems) {
            if (!item.isCoupon()) {
                Product product = (Product) item;
                if (product.getProductType() == this.getProductType()) {
                    index++;
                    if (getOffSet() == index) {
                        product.applyCoupon(this);
                    }
                }
            }
        }
    }

    @Override
    public CouponType getCouponType() {
        return CouponType.NTH;
    }

    @Override
    public DeductionType getDeductionType() {
        return DeductionType.PERCENTAGE;
    }

    public ProductType getProductType() {
        return productType;
    }

    public int getOffSet() {
        return offSet;
    }

}
