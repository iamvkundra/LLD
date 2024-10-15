package com.vmware.ensemble.rules.i18n.enums;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    HUNDRED(100),
    FIVE_HUNDRED(500);

    private int value;

    Coin(int value) {
        this.value= value;
    }

    public static void printCoin() {
        for (Coin coin : Coin.values()) {
            System.out.println(coin.name());
        }
    }

    public int getValue() {
        return this.value;
    }
}
