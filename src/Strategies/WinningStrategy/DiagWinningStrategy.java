package Strategies.WinningStrategy;

import Models.Board;
import Models.Cell;
import Models.Move;

public class DiagWinningStrategy implements WinningStrategy{


    @Override
    public boolean checkVictory(Board board, Move lastMove) {
        int currRow = lastMove.getRow();
        int currCol = lastMove.getCol();

        if(currRow != currCol || currCol+currRow != board.getSize()-1){
            return false;
        }

        if(currRow == currCol){
            currCol = 0; currRow = 0;
            while (currRow < board.getSize()){
                Cell currCell = board.getCell(currRow, currCol);
                if(currCell.getPlayer() == null || currCell.getPlayer().getSymbol().getCharacter() != lastMove.getPlayer().getSymbol().getCharacter()){
                    return false;
                }
                currRow++;
                currCol++;
            }
        } else if (currCol+currRow == board.getSize()-1) {
            currCol = board.getSize()-1; currRow = 0;
            while (currRow < board.getSize()){
                Cell currCell = board.getCell(currRow, currCol);
                if(currCell.getPlayer() == null || currCell.getPlayer().getSymbol().getCharacter() != lastMove.getPlayer().getSymbol().getCharacter()){
                    return false;
                }
                currRow++;
                currCol--;
            }
        }

        return true;
    }
}
