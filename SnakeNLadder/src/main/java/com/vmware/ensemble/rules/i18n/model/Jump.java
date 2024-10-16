package com.vmware.ensemble.rules.i18n.model;

import com.vmware.ensemble.rules.i18n.enums.JumpType;

public class Jump {

    private int start;
    private int end;
    private JumpType jumpType;

    public Jump(int start, int end, JumpType type) {
        this.start = start;
        this.end = end;
        this.jumpType = type;
    }

    public JumpType getJumpType() {
        return jumpType;
    }

    public void setJumpType(JumpType jumpType) {
        this.jumpType = jumpType;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return jumpType + " to (" + start + "," + end + ")";
    }
}
