package com.ccsit.tictac.botstratagy;

import com.ccsit.tictac.enums.DifficultyLevel;

public class BotPlayingFactory {

    public static BotPlayingStratagy getInstance(DifficultyLevel difficultyLevel){

        if(difficultyLevel == DifficultyLevel.EASY){
            return new BotEasyPlayStratagy();
        }else{
            return null;
        }
    }
}
