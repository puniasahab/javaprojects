package strategy.botStrategy;

import models.BotDifficulty;

public class BotPlayingFactory {
    public static BotStrategy getStrategyForBot(BotDifficulty botDifficulty){
        if(botDifficulty.equals(BotDifficulty.EASY)){
            return new EasyPlayingStrategy();
        } else if (botDifficulty.equals(BotDifficulty.HARD)) {
            return  new HardPlayingStrategy();
        }else if(botDifficulty.equals(BotDifficulty.MEDIUM)){
            return new MediumPlayingStrategy();
        }else{
            return null;
        }
    }
}
