package com.vmware.ensemble.rules.i18n.model.account;

import lombok.Getter;
import lombok.Setter;

import com.vmware.ensemble.rules.i18n.model.common.Address;

@Getter
@Setter
public class Contact {
    private String phone;
    private String email;
    private Address address;
    private PersonalInfo personalInfo;
}
