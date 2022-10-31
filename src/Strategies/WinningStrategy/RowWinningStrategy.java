package Strategies.WinningStrategy;

import Models.Board;
import Models.Cell;
import Models.Move;

public class RowWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkVictory(Board board, Move lastMove) {
        int currRow = lastMove.getRow();

        for(int i = 0 ; i < board.getSize(); i++){
            Cell currCell = board.getCell(currRow, i);
            if(currCell.getPlayer() == null || currCell.getPlayer().getSymbol().getCharacter() != lastMove.getPlayer().getSymbol().getCharacter()){
                return false;
            }
        }


        return true;
    }
}
