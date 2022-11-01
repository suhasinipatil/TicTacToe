package Models;

import Factories.BotDifficultyFactory;
import Factories.BotPlayingStrategyFactory;
import Strategies.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{

    private BotPlayingStrategy botPlayingStrategy;

    private BotDifficulty botDifficulty;

    public Bot(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move makeMove(Board board) {
        BotPlayingStrategy botPlayingStrategy1 = BotPlayingStrategyFactory.getBotPlayingStrategy(this.botDifficulty);
        return botPlayingStrategy1.makeMove(board, this);
    }
}
