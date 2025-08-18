package models;

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


    public Player(String name,int id , PlayerType playerType , Symbol s){
        this.name = name ;
        this.playerType = playerType;
        this.ID = id;
        this.symbol = s;
    }

}