package com.vmware.ensemble.rules.i18n.model.Team;

import java.util.List;
import java.util.Queue;

import com.vmware.ensemble.rules.i18n.model.Team.player.Player;
import com.vmware.ensemble.rules.i18n.model.Team.player.PlayerBattingController;
import com.vmware.ensemble.rules.i18n.model.Team.player.PlayerBowlingController;

public class Team {
    public String teamName;
    public Queue<Player> player11;
    public List<Player> bench;
    public PlayerBattingController playerBattingController;
    public PlayerBowlingController playerBowlingController;
    public boolean isWinner;

    public Team(String teamName, Queue<Player> player11, List<Player> bench, List<Player> bowlers) {
        this.teamName = teamName;
        this.player11 = player11;
        this.bench = bench;
        this.playerBattingController = new PlayerBattingController(player11);
        this.playerBowlingController = new PlayerBowlingController(bowlers);
    }
    public String getTeamName() {
        return teamName;
    }

    public void chooseNextBatsMan() throws Exception{
        playerBattingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler){
        playerBowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public Player getStriker() {
        return playerBattingController.getStriker();
    }

    public Player getNonStriker() {
        return playerBattingController.getNonStriker();
    }

    public void setStriker(Player player) {
        playerBattingController.setStriker(player);
    }

    public void setNonStriker(Player player) {
        playerBattingController.setNonStriker(player);
    }

    public Player getCurrentBowler() {
        return playerBowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard() {
        for (Player player : player11) {
            player.printBattingScoreCard();
        }
    }
    public void printBowlingScoreCard() {
        for (Player player : player11) {
            if (player.getBowlingScoreCard().getTotalOversCount() > 0) {
                player.printBattingScoreCard();
            }
        }
    }

    public int getTotalRun() {
        int totalRun = 0;
        for (Player player : player11) {
            totalRun += player.getBattingScoreCard().getTotalRuns();
        }
        return totalRun;
    }

}
