import controller.GameController;
import exceptions.InvalidBotFoundException;
import models.*;
import strategy.winningStrategy.ColumnWinningStrategy;
import strategy.winningStrategy.RowWinningStrategy;
import strategy.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InvalidBotFoundException {

        Scanner s = new Scanner(System.in);
        int dimension = 3;
        GameController gc = new GameController();
        List<Player> p= new ArrayList<>() ;
        p.add(new Player("Parveen",1, PlayerType.HUMAN,new Symbol('o')));
        //p.add(new Player("Pooja",2, PlayerType.HUMAN,new Symbol('x')));
        p.add(new Bot("Bot1",2,new Symbol('x'),BotDifficulty.EASY));

        List<WinningStrategy>  ws = List.of(
                new RowWinningStrategy(), new ColumnWinningStrategy()
        );
        Game g1 = gc.startGame(dimension,p,ws);

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