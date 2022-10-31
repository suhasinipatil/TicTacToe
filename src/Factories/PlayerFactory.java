package Factories;

import Models.*;

public class PlayerFactory {

    public static Player createHumanPlayer(String name, Character character){
        Player player = new Player();
        player.setName(name);
        player.setSymbol(new Symbol(character));
        player.setPlayerType(PlayerType.Human);

        return player;
    }

    public static Player createBotPlayer(String name, Character character, BotDifficulty botDifficulty){
        Bot bot = new Bot(botDifficulty);
        bot.setName(name);
        bot.setSymbol(new Symbol(character));
        bot.setPlayerType(PlayerType.Bot);

        return bot;
    }
}
