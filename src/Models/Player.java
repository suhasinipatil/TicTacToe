package Models;

import java.util.Scanner;

public class Player {

    private Symbol symbol;

    private String Name;

    private PlayerType playerType;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What row (starting from 0)");
        int row = scanner.nextInt();

        System.out.println("What col (starting from 0)");
        int col = scanner.nextInt();

        Move move = new Move(row, col, this);

        return move;
    }
}
