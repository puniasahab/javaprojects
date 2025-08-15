import controller.GameController;
import exceptions.InvalidBotFoundException;
import models.Game;
import models.GameStatus;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InvalidBotFoundException {
        GameController gc = new GameController();
        Game g1 = gc.startGame(3,new ArrayList<>(),new ArrayList<>());

        gc.disPlayBoard(g1);

        while(g1.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            gc.takeMove(g1);
            gc.disPlayBoard(g1);

        }

        if(g1.getGameStatus().equals(GameStatus.SUCCESS)){
            System.out.println("winner is "+g1.getWinner().getName());
        }else if(g1.getGameStatus().equals(GameStatus.DRAW)){
            System.out.println("Game ended in draw");
        }

    }
}