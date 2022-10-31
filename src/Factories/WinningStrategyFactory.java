package Factories;

import Strategies.WinningStrategy.*;

public class WinningStrategyFactory {

    public static WinningStrategy getWinningStrategyByName(String Name){
        if(Name.equals("ROW")){
            return new RowWinningStrategy();
        } else if (Name.equals("COLUMN")) {
            return new ColWinningStrategy();
        } else if (Name.equals("CORNER")) {
            return new CornerWinningStrategy();
        }

        return new DiagWinningStrategy();
    }
}
