package Strategies.WinningStrategy;

import Models.Board;
import Models.Cell;
import Models.Move;

public class CornerWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkVictory(Board board, Move lastMove) {
        int currRow = lastMove.getRow();
        int currCol = lastMove.getCol();

        if((currRow == 0 || currRow == board.getSize()-1) && (currCol == 0 || currCol == board.getSize()-1)){
            currRow = 0; currCol = 0;
            Cell firstCornerCell = board.getCell(currRow, currCol);
            if(firstCornerCell.getPlayer() == null || firstCornerCell.getPlayer().getSymbol().getCharacter() != lastMove.getPlayer().getSymbol().getCharacter()){
                return false;
            }

            currRow = board.getSize()-1; currCol = 0;
            Cell secondCornerCell = board.getCell(currRow, currCol);
            if(secondCornerCell.getPlayer() == null || secondCornerCell.getPlayer().getSymbol().getCharacter() != lastMove.getPlayer().getSymbol().getCharacter()){
                return false;
            }

            currRow = 0; currCol = board.getSize()-1;
            Cell thirdCornerCell = board.getCell(currRow, currCol);
            if(thirdCornerCell.getPlayer() == null || thirdCornerCell.getPlayer().getSymbol().getCharacter() != lastMove.getPlayer().getSymbol().getCharacter()){
                return false;
            }

            currRow = board.getSize()-1; currCol = board.getSize()-1;
            Cell fourthCornerCell = board.getCell(currRow, currCol);
            if(fourthCornerCell.getPlayer() == null || fourthCornerCell.getPlayer().getSymbol().getCharacter() != lastMove.getPlayer().getSymbol().getCharacter()){
                return false;
            }

            return true;
        }

        return false;
    }
}
