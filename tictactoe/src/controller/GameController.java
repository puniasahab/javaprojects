package controller;

import exceptions.InvalidBotFoundException;
import models.Game;
import models.Player;
import strategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int size, List<Player> players , List<WinningStrategy> winningStrategies) throws InvalidBotFoundException {
        Game g = Game.getBuilder().setDimension(size).setPlayers(players).setWinningStrategies(winningStrategies).build();
        return g;
    }
}
