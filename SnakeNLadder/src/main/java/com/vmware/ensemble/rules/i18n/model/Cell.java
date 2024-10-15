package com.vmware.ensemble.rules.i18n.model;

public class Cell {
    private Jump jump;

    public Cell() {
        this.jump = null;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }

    public boolean hasJump() {
        return jump != null;
    }
}
