package strategy;

import models.Board;
import models.Cell;
import models.Player;

public interface WinningStrategy {
    public boolean checkWinninr(Cell c, Board b);
}
