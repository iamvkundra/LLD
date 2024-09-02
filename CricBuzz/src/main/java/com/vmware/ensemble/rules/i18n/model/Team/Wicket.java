package com.vmware.ensemble.rules.i18n.model.Team;

import com.vmware.ensemble.rules.i18n.enums.WicketType;
import com.vmware.ensemble.rules.i18n.model.Innings.BallDetails;
import com.vmware.ensemble.rules.i18n.model.Innings.OverDetails;
import com.vmware.ensemble.rules.i18n.model.Team.player.Player;

public class Wicket {
    public WicketType wicketType;
    public Player takenBy;
    public OverDetails overDetail;
    public BallDetails ballDetail;

    public Wicket(WicketType wicketType, Player takenBy,
                  OverDetails overDetail, BallDetails ballDetail){

        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetail = overDetail;
        this.ballDetail = ballDetail;
    }


}
