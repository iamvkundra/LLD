package com.vmware.ensemble.rules.i18n.model.Team.player;

import com.vmware.ensemble.rules.i18n.enums.PlayerType;

public class Player {
    public Person person;
    public PlayerType playerType;
    public BattingScoreCard battingScoreCard;
    public BowlingScoreCard bowlingScoreCard;

    public Player (Person person, PlayerType playerType) {
        this.person = person;
        this.playerType = playerType;
        battingScoreCard = new BattingScoreCard();
        bowlingScoreCard = new BowlingScoreCard();

    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public BattingScoreCard getBattingScoreCard() {
        return battingScoreCard;
    }

    public void setBattingScoreCard(BattingScoreCard battingScoreCard) {
        this.battingScoreCard = battingScoreCard;
    }

    public BowlingScoreCard getBowlingScoreCard() {
        return bowlingScoreCard;
    }

    public void setBowlingScoreCard(BowlingScoreCard bowlingScoreCard) {
        this.bowlingScoreCard = bowlingScoreCard;
    }

    public void printBattingScoreCard() {
        System.out.println("Player name: "+person.getName() + " totalRun: "+ battingScoreCard.getTotalRuns() +
                " total Ball Played: " + battingScoreCard.getTotalBallsPlayed()
                + " 4's: " + battingScoreCard.getTotalFours() + " 6's: "
        + battingScoreCard.getTotalSix() + " strike Rate: "+battingScoreCard.getStrikeRate());
    }

    public void printBowlingScoreCard() {
        System.out.println("PlayerName: " + person.getName() + " -- totalOversThrown: " + bowlingScoreCard.totalOversCount
                + " -- totalRunsGiven: " + bowlingScoreCard.runsGiven + " -- WicketsTaken: " + bowlingScoreCard.wicketsTaken);

    }
}
