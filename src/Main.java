import Factories.BotDifficultyFactory;
import Factories.PlayerFactory;
import Factories.WinningStrategyFactory;
import Models.*;
import Strategies.WinningStrategy.*;

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

            players.add(PlayerFactory.createBotPlayer(name, symbol, BotDifficulty.Easy));
        }

        for(int i = 0;i < numberOfPlayers; i++){
            System.out.println("Name of Player " + (i-numberOfBots+1));
            String name = scanner.next();

            System.out.println("Symbol of Player " + (i-numberOfBots+1));
            Character symbol = scanner.next().charAt(0);

            players.add(PlayerFactory.createHumanPlayer(name, symbol));
        }

        Game game = Game.getbuilder().setPlayerList(players).build();

        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            game.makeMove();
        }

    }
}