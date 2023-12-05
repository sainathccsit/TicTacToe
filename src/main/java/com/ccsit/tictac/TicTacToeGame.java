package com.ccsit.tictac;

import com.ccsit.tictac.controllers.GameController;
import com.ccsit.tictac.enums.GameStatus;
import com.ccsit.tictac.enums.PlayerType;
import com.ccsit.tictac.models.Cell;
import com.ccsit.tictac.models.Game;
import com.ccsit.tictac.models.Move;
import com.ccsit.tictac.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

     Game game = GameController.createGame(size,playerList);
        while(game.getGameStatus() == GameStatus.INPROGRESS){
            game.display();
            GameController.executeMove(game);
        }
        // Get the Size of the boar N X N
        // GEt the (N-1) player details ( name ,symbol)
        // check is Bot playing in Game

        // validate and Initialize the Game

        /*
             run game until it status moved to either won or drawn
             while(game.status != GameStatus.INPROGRESS){

             }
         */

    }


}
