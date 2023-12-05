package com.ccsit.tictac.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> board;

    public Board(int dimension) {
        this.board  = new ArrayList<List<Cell>>();
        for(int i=0;i<dimension;i++){
            List<Cell> li = new ArrayList<>();
            for(int j=0;j<dimension;j++){
                Cell cell = new Cell(i,j);
                li.add(cell);
            }
            this.board.add(li);
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
