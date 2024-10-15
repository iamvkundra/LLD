package com.vmware.ensemble.rules.i18n.model;

public class Player {
    private String playerId;
    private int position;

    public Player(String playerId, int position) {
        this.playerId = playerId;
        this.position = position;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
