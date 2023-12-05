package com.ccsit.tictac.models;

public class Move {
     Cell cell;
     Player player;

     public Move(Cell cell, Player player) {
          this.cell = cell;
          this.player = player;
     }
}
