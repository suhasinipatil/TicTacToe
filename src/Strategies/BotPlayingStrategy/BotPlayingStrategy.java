package Strategies.BotPlayingStrategy;

import Models.Board;
import Models.Bot;
import Models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Bot bot);
}
