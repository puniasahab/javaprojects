package models;

public class Bot extends Player{
    private BotDifficulty botDifficulty;

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }
    public Bot(String name,int id ,  Symbol s,BotDifficulty d){
        super(name,id,PlayerType.BOT,s);
        this.botDifficulty = d;
    }
}
