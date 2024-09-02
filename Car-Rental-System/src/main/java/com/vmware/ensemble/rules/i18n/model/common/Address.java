package com.vmware.ensemble.rules.i18n.model.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}
