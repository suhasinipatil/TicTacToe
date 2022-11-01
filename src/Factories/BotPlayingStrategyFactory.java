package Factories;

import Models.BotDifficulty;
import Strategies.BotPlayingStrategy.BotPlayingStrategy;
import Strategies.BotPlayingStrategy.EasyBotPlayingStrategy;
import Strategies.BotPlayingStrategy.HardBotPlayingStrategy;
import Strategies.BotPlayingStrategy.MedBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficulty botDifficulty){
        if(botDifficulty == BotDifficulty.Easy)
            return new EasyBotPlayingStrategy();
        else if (botDifficulty == BotDifficulty.Medium) {
            return new MedBotPlayingStrategy();
        }

        return new HardBotPlayingStrategy();
    }
}
