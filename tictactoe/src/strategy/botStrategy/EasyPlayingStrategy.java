package strategy.botStrategy;

import models.Board;
import models.Cell;
import models.CellStatus;

import java.util.List;

public class EasyPlayingStrategy implements BotStrategy{

    @Override
    public Cell decideMove(Board b) {

        for (List<Cell> cells:b.getGrid()) {
            for (Cell c : cells ){
                if(c.getCellStatus().equals(CellStatus.EMPTY)){
                    return c;
                }
            }
        }
        return null;
        
        
    }
}
