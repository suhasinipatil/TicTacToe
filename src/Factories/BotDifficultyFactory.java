package Factories;

import Models.BotDifficulty;

public class BotDifficultyFactory {

    public static BotDifficulty getBotDifficultyLevelByName(String name){
        if(name.equals("EASY")){
            return BotDifficulty.Easy;
        } else if (name.equals("MEDIUM")) {
            return  BotDifficulty.Medium;
        }

        return BotDifficulty.Hard;
    }
}
