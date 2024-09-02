package com.vmware.ensemble.rules.i18n.model.account;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import com.vmware.ensemble.rules.i18n.enums.account.LicenseType;

@Getter
@Setter
public class LicenseInfo {
    private String licenceNumber;
    private LocalDateTime issueDate;
    private LocalDateTime expiryDate;
    private String issuedAtPlace;
    private String issuedInState;
    private String issuedInCountry;
    private LicenseType licenseType;
}
