package controller;

import exceptions.InvalidBotFoundException;
import models.Game;
import models.Player;
import strategy.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int size, List<Player> players , List<WinningStrategy> winningStrategies) throws InvalidBotFoundException {
        Game g = Game.getBuilder().setDimension(size).setPlayers(players).setWinningStrategies(winningStrategies).build();
        return g;
    }

    public void disPlayBoard(Game g){
        g.getBoard().printBoard();
    }

    public void takeMove(Game g){
        // TO DO
        g.makeMove();
    }
}
