package Models;

import Exceptions.DuplicateSymbolException;
import Strategies.WinningStrategy.*;

import java.util.*;

public class Game {
    private List<Player> playerList;

    private List<Move> moveList;

    private Board board;

    private int LastMovedPlayerIndex;

    private Player playerWinner;

    private GameStatus GameStatus;

    private int filledCells = 0;

    public static Builder getbuilder(){
        return new Builder();
    }

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



    public GameStatus getGameStatus() {
        return GameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.GameStatus = gameStatus;
    }

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
    }

    public void makeMove(){
        board.display();

        this.LastMovedPlayerIndex += 1;
        this.LastMovedPlayerIndex %= playerList.size();
        System.out.println(this.playerList.get(this.LastMovedPlayerIndex).getName() + " 's turn");
        Move potentialMove = this.playerList.get(this.LastMovedPlayerIndex).makeMove(this.board);

        if(this.board.getCell(potentialMove.getRow(), potentialMove.getCol()).getPlayer() != null){
            System.out.println("Bad Move Try Again!");
            return;
        }

        this.moveList.add(potentialMove);
        this.board.getCell(potentialMove.getRow(), potentialMove.getCol()).setPlayer(this.playerList.get(this.LastMovedPlayerIndex));

        if(this.playerList.get(this.LastMovedPlayerIndex).getPlayerType() == PlayerType.Human){
            Scanner scanner = new Scanner(System.in);
            System.out.println("If you want to undo the last move, press u else press alphabet");
            String doUndo = scanner.next();
            if(doUndo.toLowerCase().contains("u")) {
                undo(potentialMove);
                return;
            }
        }

        filledCells += 1;

        for (WinningStrategy winningStrategy : winningStrategyList) {
            if (winningStrategy.checkVictory(this.board, potentialMove)) {
                GameStatus = Models.GameStatus.END;
                playerWinner = this.playerList.get(this.LastMovedPlayerIndex);
                this.board.display();
                System.out.println(playerWinner.getName() + " has won!!!");
                return;
            }
        }

        if (filledCells == (this.playerList.size() + 1) * (this.playerList.size() + 1)) {
            GameStatus = Models.GameStatus.DRAW;
            this.board.display();
            System.out.println("Game is Draw!!!");
        }

    }

    public void undo(Move move){
        board.undo(move);
    }

    public static class Builder{
        private List<Player> playerList;
        private List<WinningStrategy> winningStrategyList = new ArrayList<>();;

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        private void setWinningStrategyList() {
            this.winningStrategyList.add(new ColWinningStrategy());
            this.winningStrategyList.add(new CornerWinningStrategy());
            this.winningStrategyList.add(new DiagWinningStrategy());
            this.winningStrategyList.add(new RowWinningStrategy());
        }

        public Game build(){
            Set<Character> alreadyExistingCharacters = new HashSet<>();

            for(Player player : playerList){
                if(alreadyExistingCharacters.contains(player.getSymbol().getCharacter())){
                    throw new DuplicateSymbolException(player.getSymbol().getCharacter());
                }
                alreadyExistingCharacters.add(player.getSymbol().getCharacter());
            }
            setWinningStrategyList();

            Game game = new Game();
            game.board = new Board(playerList.size() + 1);
            game.GameStatus = Models.GameStatus.IN_PROGRESS;
            game.playerList = playerList;
            game.winningStrategyList = winningStrategyList;
            game.LastMovedPlayerIndex = -1;
            game.moveList = new ArrayList<>();

            return game;
        }
    }
}
