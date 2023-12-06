package com.ccsit.tictac;

import com.ccsit.tictac.controllers.GameController;
import com.ccsit.tictac.enums.GameStatus;
import com.ccsit.tictac.enums.PlayerType;
import com.ccsit.tictac.models.Cell;
import com.ccsit.tictac.models.Game;
import com.ccsit.tictac.models.Move;
import com.ccsit.tictac.models.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TicTacToeGame {

    public static void main(String[] args) throws Exception {
        System.out.println("Please Enter the Size of the Board: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Size of the board is "+size+" X "+size);
        System.out.println("Please Enter Details of Players");
        List<Player> playerList = new ArrayList<Player>();
        for(int i=1;i<size;i++){
            System.out.println("Enter Player "+i+" Details: ");
            String name = sc.next();
            System.out.println("Enter Player "+i+" Symbol: ");
            String symbol = sc.next();
            Player p = new Player(name,symbol.charAt(0),PlayerType.HUMAN);
            playerList.add(p);
        }
        Game game;
        try {
        game= GameController.createGame(size,playerList);
    }catch (Exception e){
        System.out.println(e.getMessage());
         return;
    }

        while(game.getGameStatus() == GameStatus.INPROGRESS){
            game.display();
            GameController.executeMove(game);
        }

        System.out.println("GAME STATUS: "+game.getGameStatus());
        if(game.getGameStatus() == GameStatus.WON){
            int lastMoveidx = game.getMoves().size();
            Move lastMove = game.getMoves().get(lastMoveidx-1);
            System.out.println("--------------");
            System.out.println("Player "+lastMove.getPlayer().getName());
            System.out.println("Player Symbol: "+lastMove.getPlayer().getSymbol());
        }else{
            System.out.println();
        }

    }


}
