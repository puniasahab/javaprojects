package models;

import strategy.botStrategy.BotPlayingFactory;
import strategy.botStrategy.BotStrategy;

public class Bot extends Player{
    private BotDifficulty botDifficulty;

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    private BotStrategy bs ;
    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }
    public Bot(String name,int id ,  Symbol s,BotDifficulty d){
        super(name,id,PlayerType.BOT,s);
        this.botDifficulty = d;
        this.bs = BotPlayingFactory.getStrategyForBot(d);
    }

    public Cell decideCell(Board b){
        System.out.println("Bot is playing");
        return bs.decideMove(b);
    }
}
