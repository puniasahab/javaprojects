package models;

import java.util.Scanner;

public class Player {
    private int ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    private String name;

    private PlayerType playerType;

    private Symbol symbol;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    Scanner scanner;

    public Player(String name,int id , PlayerType playerType , Symbol s){
        this.name = name ;
        this.playerType = playerType;
        this.ID = id;
        this.symbol = s;
        this.scanner = new Scanner(System.in);
    }

    public boolean validateInput(int row , int col){
        // todo implement to validate the user input
        return true;
    }
    public Cell decideCell(Board b){
        System.out.println("Please mention a row ...");
        int row = scanner.nextInt();
        System.out.println("Please mention a Col ...");
        int col = scanner.nextInt();

        if(!validateInput(row,col) ){
            System.out.println("Invalid input ...");
            return null;
        }
        return b.getGrid().get(row).get(col);

    }

}