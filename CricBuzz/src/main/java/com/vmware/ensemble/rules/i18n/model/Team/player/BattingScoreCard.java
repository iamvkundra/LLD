package com.vmware.ensemble.rules.i18n.model.Team.player;

import com.vmware.ensemble.rules.i18n.model.Team.Wicket;

public class BattingScoreCard {

    public int totalRuns;
    public int totalBallsPlayed;
    public int totalFours;
    public int totalSix;
    public double strikeRate;
    public Wicket wicketDetails;

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalBallsPlayed() {
        return totalBallsPlayed;
    }

    public void setTotalBallsPlayed(int totalBallsPlayed) {
        this.totalBallsPlayed = totalBallsPlayed;
    }

    public int getTotalFours() {
        return totalFours;
    }

    public void setTotalFours(int totalFours) {
        this.totalFours = totalFours;
    }

    public int getTotalSix() {
        return totalSix;
    }

    public void setTotalSix(int totalSix) {
        this.totalSix = totalSix;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public Wicket getWicketDetails() {
        return wicketDetails;
    }

    public void setWicketDetails(Wicket wicketDetails) {
        this.wicketDetails = wicketDetails;
    }
}
