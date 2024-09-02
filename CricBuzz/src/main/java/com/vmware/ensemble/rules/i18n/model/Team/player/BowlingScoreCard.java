package com.vmware.ensemble.rules.i18n.model.Team.player;

public class BowlingScoreCard {

    public int totalOversCount;
    public int runsGiven;
    public int wicketsTaken;
    public int noBallCount;
    public int wideBallCount;
    public double economyRate;

    public int getTotalOversCount() {
        return totalOversCount;
    }

    public void setTotalOversCount(int totalOversCount) {
        this.totalOversCount = totalOversCount;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public int getNoBallCount() {
        return noBallCount;
    }

    public void setNoBallCount(int noBallCount) {
        this.noBallCount = noBallCount;
    }

    public int getWideBallCount() {
        return wideBallCount;
    }

    public void setWideBallCount(int wideBallCount) {
        this.wideBallCount = wideBallCount;
    }

    public double getEconomyRate() {
        return economyRate;
    }

    public void setEconomyRate(double economyRate) {
        this.economyRate = economyRate;
    }
}
