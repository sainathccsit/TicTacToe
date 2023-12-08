package com.ccsit.tictac.models;

import com.ccsit.tictac.enums.DifficultyLevel;
import com.ccsit.tictac.enums.PlayerType;

public class Bot extends Player{

    private DifficultyLevel difficultyLevel;

    public Bot(String name, char symbol, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {

        this.difficultyLevel = difficultyLevel;
    }
}

