package com.ccsit.tictac.botstratagy;

import com.ccsit.tictac.enums.CellStatus;
import com.ccsit.tictac.enums.DifficultyLevel;
import com.ccsit.tictac.models.Board;
import com.ccsit.tictac.models.Cell;
import com.ccsit.tictac.models.Move;
import com.ccsit.tictac.models.Player;

public class BotEasyPlayStratagy implements BotPlayingStratagy{
    private  int size = 0;
    private Board board;

    public BotEasyPlayStratagy(int size, Board board) {
        this.size = size;
        this.board = board;
    }

    public BotEasyPlayStratagy() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public Move getMove(Player bot) {
        DifficultyLevel difficultyLevel = DifficultyLevel.EASY;
        Move move = null;
        if(difficultyLevel == DifficultyLevel.EASY){
            for(int i=0;i<size+1;i++){
                for(int j=0;j<size+1;j++){
                    if(this.board.getBoard().get(i).get(j).getCellStatus() == CellStatus.EMPTY){
                        Cell cell = this.board.getBoard().get(i).get(j);
                        cell.setSymbol(bot.getSymbol());
                        cell.setCellStatus(CellStatus.FILLED);
                        move = new Move(cell,bot);
                        return move;
                    }
                }
            }
        }
        return move;
    }
}
