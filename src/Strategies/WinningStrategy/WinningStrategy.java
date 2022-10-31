package Strategies.WinningStrategy;

import Models.Board;
import Models.Move;

public interface WinningStrategy {

    boolean checkVictory(Board board, Move lastMove);
}
