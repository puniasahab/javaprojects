package models;

import exceptions.InvalidBotFoundException;
import strategy.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Cell> moves;
    private int nextPlayerTurn;

    private Player winner;
    private GameStatus gameStatus;

    private List<WinningStrategy> winningStrategies;

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Cell> getMoves() {
        return moves;
    }

    public void setMoves(List<Cell> moves) {
        this.moves = moves;
    }

    public int getNextPlayerTurn() {
        return nextPlayerTurn;
    }

    public void setNextPlayerTurn(int nextPlayerTurn) {
        this.nextPlayerTurn = nextPlayerTurn;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }


    private Game(int dimension,List<Player> players , List<WinningStrategy> winningStrategies){
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.nextPlayerTurn = 0;
        this.winner = null;
    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        int dimension;
        List<Player> players ;
        List<WinningStrategy> winningStrategies ;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Game build() throws InvalidBotFoundException {

            validate();
            return new Game(this.dimension,this.players,this.winningStrategies);

        }


        public void validate() throws InvalidBotFoundException {
            int botCount = 0 ;
            for (Player p : players ) {
                if(p.getPlayerType() == PlayerType.BOT){
                    botCount ++;
                }
            }
            if(botCount > 1){
                throw new InvalidBotFoundException();
            }
            if(players.size() > this.dimension -1){
                throw new RuntimeException();
            }
        }
    }
    public  void makeMove(){
        Player currentPlayer = players.get(nextPlayerTurn);
        Cell c = currentPlayer.decideCell(this.board);
        if(c ==null){
            System.out.println("Invalid input");
            return;
        }
        c.setPlayer(currentPlayer);
        c.setCellStatus(CellStatus.FILLED);
        moves.add(c);
        // now check winner
        if(checkWinner(board,c)){
            gameStatus = GameStatus.SUCCESS;
            winner = currentPlayer;
        }else if (moves.size() == board.getSize() * board.getSize()){
            gameStatus = GameStatus.DRAW;
        }
        this.nextPlayerTurn = (nextPlayerTurn + 1 ) % players.size() ;
    }

    public boolean checkWinner(Board b , Cell c){
        for(WinningStrategy ws : winningStrategies){
            if(ws.checkWinninr(c,b)){
                return true;
            }
        }
        return false;
    }


}
