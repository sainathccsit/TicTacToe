package com.ccsit.tictac.botstratagy;

import com.ccsit.tictac.models.Move;
import com.ccsit.tictac.models.Player;

public interface BotPlayingStratagy {

    public Move getMove(Player player);
}
