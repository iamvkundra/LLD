package com.vmware.ensemble.rules.i18n.model.Innings;

import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.BallType;
import com.vmware.ensemble.rules.i18n.model.Team.Team;
import com.vmware.ensemble.rules.i18n.model.Team.player.Player;


public class OverDetails {

    int overNumber;
    List<BallDetails> balls;
    int extraBallsCount;
    Player bowledBy;

    OverDetails(int overNumber, Player bowledBy){
            this.overNumber = overNumber;
            balls = new ArrayList<>();
            this.bowledBy = bowledBy;
    }
    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception{

        int ballCount = 1;
        while(ballCount<=6){
            BallDetails ball = new BallDetails(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            if(ball.ballType == BallType.NORMAL) {
                balls.add(ball);
                ballCount++;
                if(ball.wicket != null) {
                    battingTeam.chooseNextBatsMan();
                }

                if( runsToWin != -1 && battingTeam.getTotalRun() >= runsToWin){
                    battingTeam.isWinner = true;
                    return true;
                }
            }
            else {
                extraBallsCount++;
            }
        }
        return false;
    }
}
