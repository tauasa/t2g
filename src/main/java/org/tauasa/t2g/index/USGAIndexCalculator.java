package org.tauasa.t2g.index;

import org.tauasa.t2g.model.Score;

public class USGAIndexCalculator implements IndexCalculator{
    
    @Override
    public Index calculateIndex(Score score){
        esc(score);//equitable stroke
        
        return null;

    }

    /**
     * Equitable Stroke Control
    */
    protected void esc(Score score){
        //iterate over HoleScores and sum strokes

    }

}
