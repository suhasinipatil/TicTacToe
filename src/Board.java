import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;

    ArrayList<ArrayList<Cell>> matrix = new ArrayList<ArrayList<Cell>>(size);

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<ArrayList<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<Cell>> matrix) {
        this.matrix = matrix;
    }
}
