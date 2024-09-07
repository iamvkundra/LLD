package com.vmware.ensemble.rules.i18n.enums;

public enum City {

    RANCHI("JHARKHAND"),
    PUNE("MAHARASHTRA"),
    BANGALORE("KARNATAKA"),
    CHENNAI("TAMIL NADU"),
    MUMBAI("MAHARASHTRA");

    private String state;

    City(String value) {
        this.state = value;
    }

    public String getState() {
        return this.state;
    }
}
