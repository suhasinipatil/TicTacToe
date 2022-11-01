package Strategies.BotPlayingStrategy;

import Models.Board;
import Models.Bot;
import Models.Move;

import java.util.Random;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board, Bot bot) {
        Random random = new Random();

        int row = random.nextInt(board.getSize());

        int col = random.nextInt(board.getSize());

        Move move = new Move(row, col, bot);

        return move;
    }
}
