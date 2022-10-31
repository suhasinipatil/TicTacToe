import Factories.BotDifficultyFactory;
import Factories.PlayerFactory;
import Factories.WinningStrategyFactory;
import Models.Game;
import Models.GameStatus;
import Models.Player;
import Strategies.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many players?");
        int numberOfPlayers = scanner.nextInt();

        System.out.println("How many Bots?");
        int numberOfBots = scanner.nextInt();

        List<Player> players = new ArrayList<>();

        for(int i = 0;i < numberOfBots; i++){
            System.out.println("Name of Bot " + (i+1));
            String name = scanner.next();

            System.out.println("Symbol of Bot " + (i+1));
            Character symbol = scanner.next().charAt(0);

            System.out.println("Difficulty level of Bot " + (i+1));
            String botDifficulty = scanner.next();

            players.add(PlayerFactory.createBotPlayer(name, symbol, BotDifficultyFactory.getBotDifficultyLevelByName(botDifficulty)));
        }

        for(int i = 0;i < numberOfPlayers; i++){
            System.out.println("Name of Player " + (i-numberOfBots+1));
            String name = scanner.next();

            System.out.println("Symbol of Player " + (i-numberOfBots+1));
            Character symbol = scanner.next().charAt(0);

            players.add(PlayerFactory.createHumanPlayer(name, symbol));
        }

        System.out.println("How many strategies?");
        int numberOfStrategies = scanner.nextInt();

        List<WinningStrategy> winningStrategyList = new ArrayList<>();
        for(int i = 0; i < numberOfStrategies; i++){
            System.out.println("Name strategy " + (i+1));
            winningStrategyList.add(WinningStrategyFactory.getWinningStrategyByName(scanner.next()));
        }

        Game game = Game.getbuilder().setWinningStrategyList(winningStrategyList).setPlayerList(players).build();

        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            game.makeMove();
        }

    }
}