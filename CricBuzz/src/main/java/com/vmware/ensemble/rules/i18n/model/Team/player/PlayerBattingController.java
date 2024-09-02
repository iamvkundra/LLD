package com.vmware.ensemble.rules.i18n.model.Team.player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    Queue<Player> yetToBat;
    Player striker;
    Player nonStriker;

    public PlayerBattingController(Queue<Player> playing11) {
        this.yetToBat = new LinkedList<>();
        this.yetToBat.addAll(playing11);
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }

    public Player getStriker() {
        return striker;
    }

    public void setStriker(Player striker) {
        this.striker = striker;
    }

    public Queue<Player> getYetToBat() {
        return yetToBat;
    }

    public void setYetToBat(Queue<Player> yetToBat) {
        this.yetToBat = yetToBat;
    }

    public void getNextPlayer() throws Exception{
        if (yetToBat.isEmpty()) {
            throw new Exception("");
        }
        if (striker == null) {
            striker = yetToBat.poll();
        }
        if (nonStriker == null) {
            nonStriker = yetToBat.poll();
        }
    }

}
