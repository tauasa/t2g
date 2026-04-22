package org.tauasa.t2g.index;

import java.time.LocalDateTime;

import org.tauasa.t2g.model.Golfer;

public class Index {

    private float value;
    private LocalDateTime effectiveDate;
    private Golfer golfer;
    
    public float getValue() {
        return value;
    }
    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }
    public Golfer getGolfer() {
        return golfer;
    }
    public void setValue(float value) {
        this.value = value;
    }
    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    public void setGolfer(Golfer golfer) {
        this.golfer = golfer;
    }


}
