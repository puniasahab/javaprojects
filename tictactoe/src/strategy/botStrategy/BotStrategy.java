package strategy.botStrategy;

import models.Board;
import models.Cell;

public interface BotStrategy {
    public Cell decideMove(Board b);
}
