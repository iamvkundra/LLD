package com.vmware.ensemble.rules.i18n.model.Team.player;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlayerBowlingController {

    Deque<Player> bowlerList;
    Map<Player, Integer> bowlerVsOverCount;
    Player currentBowler;

    public PlayerBowlingController(List<Player> bowlers) {
        setBowlerList(bowlers);
    }

    private void setBowlerList(List<Player> bowlers) {
        this.bowlerList = new LinkedList<>();
        bowlerVsOverCount = new HashMap<>();
        for (Player bowler : bowlers) {
            this.bowlerList.addLast(bowler);
            bowlerVsOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {

        Player playerDetails = bowlerList.poll();
        if(bowlerVsOverCount.get(playerDetails)+1 == maxOverCountPerBowler) {
            currentBowler = playerDetails;
        }
        else {
            currentBowler = playerDetails;
            bowlerList.addLast(playerDetails);
            bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails)+1);
        }
    }

    public Player getCurrentBowler(){
        return currentBowler;
    }
}
