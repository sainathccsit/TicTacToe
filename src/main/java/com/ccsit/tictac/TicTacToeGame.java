package com.ccsit.tictac;

import com.ccsit.tictac.enums.PlayerType;
import com.ccsit.tictac.models.Player;

import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {
        System.out.println("Please Enter the Size of the Board: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Size of the board is "+size+" X "+size);
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
