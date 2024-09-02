package com.vmware.ensemble.rules.i18n.ScoreUpdater;

import com.vmware.ensemble.rules.i18n.model.Innings.BallDetails;

public interface ScoreUpdaterObserver {
    public void update(BallDetails ballDetails);
}
