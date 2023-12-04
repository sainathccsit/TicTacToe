package com.ccsit.tictac.models;

import com.ccsit.tictac.enums.CellStatus;

public class Cell {
    Player player;
    Symbol symbol;
    int row;
    int col;
    CellStatus cellStatus;
}
