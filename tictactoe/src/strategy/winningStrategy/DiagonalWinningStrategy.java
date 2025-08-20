package strategy.winningStrategy;

import models.Board;
import models.Cell;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{

     Map<Symbol,Integer> counts1 = new HashMap<>();
     Map<Symbol,Integer> counts2 = new HashMap<>();
    public boolean checkWinninr(Cell c, Board b) {
        int row = c.getRow();
        int col = c.getCol();
        Symbol s = c.getPlayer().getSymbol();
        if(row==col){
            if(!counts1.containsKey(s)){
                counts1.put(s,0);
            }
            counts1.put(s,counts1.get(s)+1);
            if(counts1.get(s) == b.getSize()){
                return true;
            }
        } else if (row+col ==b.getSize() -1) {
            if(!counts2.containsKey(s)){
                counts2.put(s,0);
            }
            counts2.put(s,counts2.get(s)+1);
            if(counts2.get(s) == b.getSize()){
                return true;
            }
        }


        return false;
    }

    public void handleundo(Cell c, Board b) {
        int row = c.getRow();
        int col = c.getCol();
        Symbol s = c.getPlayer().getSymbol();
        if(row == col){
            counts1.put(s,counts1.get(s)-1);
        } else if (row +col == b.getSize()-1) {
            counts2.put(s,counts2.get(s)-1);
            
        }
    }
}
