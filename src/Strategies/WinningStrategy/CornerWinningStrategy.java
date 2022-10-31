package Strategies.WinningStrategy;

import Models.Board;
import Models.Move;

public class CornerWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkVictory(Board board, Move lastMove) {
        return false;
    }
}
