package strategy;

import models.Board;
import models.Player;

public interface WinningStrategy {
    public boolean checkWinninr(Player p, Board b);
}
