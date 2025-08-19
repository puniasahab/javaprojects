package models;

public class Cell {
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Player player;

    private int row;
    private int col;
    private CellStatus cellStatus;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.player = null;
        this.cellStatus = CellStatus.EMPTY;
    }
    public void display(){
        if(player == null){
            System.out.print("| - |");
        }else {
            System.out.print("| " + this.player.getSymbol().getSymbol() + " |");
        }
    }
}
