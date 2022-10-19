import WinningStrategy.WinningStrategy;

import java.util.List;

public class Game {
    private List<Player> playerList;

    private List<Move> moveList;

    private Board board;

    private int LastMovedPlayerIndex;

    private Player playerWinner;

    private boolean GameState;

    private List<WinningStrategy> winningStrategyList;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getLastMovedPlayerIndex() {
        return LastMovedPlayerIndex;
    }

    public void setLastMovedPlayerIndex(int lastMovedPlayerIndex) {
        LastMovedPlayerIndex = lastMovedPlayerIndex;
    }

    public Player getPlayerWinner() {
        return playerWinner;
    }

    public void setPlayerWinner(Player playerWinner) {
        this.playerWinner = playerWinner;
    }

    public boolean isGameState() {
        return GameState;
    }

    public void setGameState(boolean gameState) {
        GameState = gameState;
    }

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
    }
}
