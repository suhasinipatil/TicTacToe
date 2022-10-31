package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;

    ArrayList<ArrayList<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();

        for(int i = 0; i < size; i++){
            this.board.add(new ArrayList<>());

            for(int j = 0; j < size; j++){
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void display(){
        for(List<Cell> row : board){
            for(Cell cell : row){
                if(cell.getPlayer() == null){
                    System.out.print(" - ");
                }else {
                    System.out.print(" " + cell.getPlayer().getSymbol().getCharacter() + " ");
                }
            }
            System.out.println();
        }
    }

    public Cell getCell(int row, int col){
        return board.get(row).get(col);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<ArrayList<Cell>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Cell>> board) {
        this.board = board;
    }
}
