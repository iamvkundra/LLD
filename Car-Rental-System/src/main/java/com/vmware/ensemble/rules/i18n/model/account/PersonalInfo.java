package com.vmware.ensemble.rules.i18n.model.account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonalInfo {
    private String firstName;
    private String lastName;
    private String middleName;
    private String initials;
    private String dob;
}
