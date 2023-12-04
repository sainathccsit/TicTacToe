package com.ccsit.tictac.models;

import com.ccsit.tictac.enums.PlayerType;

public class Player {
    String name;
    Symbol symbol;
    PlayerType playerType;

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
}
