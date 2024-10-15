package com.vmware.ensemble.rules.i18n.model;

import com.vmware.ensemble.rules.i18n.enums.City;

public class Address {

    private City city;

    public Address (City city) {
        this.city = city;
    }

    public City getCity() {
        return this.city;
    }
}

