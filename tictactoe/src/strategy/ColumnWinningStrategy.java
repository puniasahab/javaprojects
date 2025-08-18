package strategy;

import models.Board;
import models.Cell;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{

    Map<Integer, HashMap<Symbol,Integer>> counts = new HashMap<>();
    public boolean checkWinninr(Cell c, Board b) {

        int col = c.getCol();
        Symbol s = c.getPlayer().getSymbol();

        if(!counts.containsKey(col)){
            counts.put(col,new HashMap<>());
        }
        HashMap<Symbol,Integer> hs =  counts.get(col);
        if(!hs.containsKey(s)){
            hs.put(s,0);
        }
        hs.put(s,hs.get(s)+1);


        return hs.get(s) == b.getSize();
    }
}
