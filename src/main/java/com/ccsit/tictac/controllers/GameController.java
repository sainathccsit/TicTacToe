package com.ccsit.tictac.controllers;

import com.ccsit.tictac.enums.GameStatus;
import com.ccsit.tictac.models.Cell;
import com.ccsit.tictac.models.Game;
import com.ccsit.tictac.models.Move;
import com.ccsit.tictac.models.Player;

import java.util.List;
import java.util.Scanner;

public class GameController {


    public static Game createGame(int size, List<Player> playerList) throws Exception {
        Game game = Game.getBuilder()
                .setDimension(size)
                .setPlayers(playerList)
                .build();

        return game;
    }

    public static void executeMove(Game game) {

            game.nexMove();
    }
}
