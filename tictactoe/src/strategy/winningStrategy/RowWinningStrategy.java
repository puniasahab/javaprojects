package strategy.winningStrategy;

import models.Board;
import models.Cell;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    Map<Integer,HashMap<Symbol,Integer>> counts = new HashMap<>();
    public boolean checkWinninr(Cell c, Board b) {

        int row = c.getRow();
        Symbol s = c.getPlayer().getSymbol();

        if(!counts.containsKey(row)){
            counts.put(row,new HashMap<>());
        }
        HashMap<Symbol,Integer> hs =  counts.get(row);
        if(!hs.containsKey(s)){
            hs.put(s,0);
        }
        hs.put(s,hs.get(s)+1);


        return hs.get(s) == b.getSize();
    }
}
