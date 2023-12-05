package com.ccsit.tictac.models;

import com.ccsit.tictac.enums.DifficultyLevel;
import com.ccsit.tictac.enums.PlayerType;

public class Bot extends Player{

    DifficultyLevel difficultyLevel;

    public Bot(String name, char symbol, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }
}

