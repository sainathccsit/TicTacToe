package com.ccsit.tictac.models;

import com.ccsit.tictac.botstratagy.BotEasyPlayStratagy;
import com.ccsit.tictac.botstratagy.BotPlayingFactory;
import com.ccsit.tictac.botstratagy.BotPlayingStratagy;
import com.ccsit.tictac.enums.CellStatus;
import com.ccsit.tictac.enums.DifficultyLevel;
import com.ccsit.tictac.enums.GameStatus;
import com.ccsit.tictac.enums.PlayerType;

import java.util.*;

public class Game {
    Board board;
    List<Player> players;
    GameStatus gameStatus;
    List<Move> moves;
    int nextPlayerIndex;
    int totalMoves =0;

    private Game(Builder builder){
       this.board = new Board(builder.getDimension());
        this.players = builder.getPlayers();
        this.gameStatus = GameStatus.INPROGRESS;
        this.moves = new ArrayList<Move>();
        this.nextPlayerIndex = 0;
        this.totalMoves = builder.getDimension()*builder.getDimension();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void nexMove() {

        Scanner sc = new Scanner(System.in);
        Player p =  this.getPlayers().get(this.getNextPlayerIndex());
        Move move = null;
        if(p.playerType == PlayerType.BOT){
            move =  getBoatMove(p);

        }else{
            System.out.println("Please Enter "+p.getName()+"'s move details");
            System.out.println("Enter Row: ");
            int row = sc.nextInt();
            System.out.println("Enter col: ");
            int col = sc.nextInt();
            while(!isValidMove(row,col)){
                System.out.println("Please Enter "+p.getName()+"'s valid move details");
                System.out.println("Enter Row: ");
                row = sc.nextInt();
                System.out.println("Enter col: ");
                col = sc.nextInt();
            }
            Cell cell = board.getBoard().get(row).get(col);
            cell.setCellStatus(CellStatus.FILLED);
            cell.setPlayer(p);
            cell.setSymbol(p.getSymbol());
             move = new Move(cell,p);

        }
        moves.add(move);
        totalMoves--;
        this.nextPlayerIndex = (this.nextPlayerIndex+1)%this.players.size();

        if(CheckForWinner(move)){
            this.setGameStatus(GameStatus.WON);
            return;
        }
        if(totalMoves == 0) {
            this.setGameStatus(GameStatus.DRAWN);
        }
    }

    private Move getBoatMove(Player player) {
        Bot bot = (Bot)player;

       BotPlayingStratagy stratagy = BotPlayingFactory.getInstance(bot.getDifficultyLevel());
        Move move = stratagy.getMove(bot);

            return move;
    }

    /*
            Please implement winning logic
     */
    private boolean CheckForWinner(Move move) {

            boolean status = checkRowWiseWinning(move);
            if(status) return true;

            status = checkColWiseWinning(move);
            if(status) return true;
               status = checkDiagWiseWinning(move);
            if(status) return true;

        return false;
    }

    private boolean isValidMove(int row, int col) {
        if(row < 0 || col < 0 || row > this.players.size() || col > this.players.size()) return false;
        Cell cell = board.getBoard().get(row).get(col);
        if(cell.getCellStatus() == CellStatus.FILLED) return false;

        return true;
    }

    public boolean checkRowWiseWinning(Move move){
        Cell cell = move.getCell();
        Player p = move.getPlayer();

        // check row wise
        int r = cell.getRow();
        int c  = cell.getCol();
        for(int i=0;i<board.board.size();i++){
            if(board.board.get(r).get(i).symbol != p.getSymbol()){
                return false;
            }
        }
        return true;
    }

    public boolean checkColWiseWinning(Move move){
        Cell cell = move.getCell();
        Player p = move.getPlayer();

        // check row wise
        int r = cell.getRow();
        int c  = cell.getCol();
        for(int i=0;i<board.board.size();i++){
            if(board.board.get(i).get(r).symbol != p.getSymbol()){
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagWiseWinning(Move move){
        Cell cell = move.getCell();
        Player p = move.getPlayer();
        int size = this.players.size();
        // check row wise
        Boolean status = true;
            for(int i=0;i<board.board.size();i++){
                if(board.board.get(i).get(i).symbol != p.getSymbol()){
                    status = false;
                    break;
                }
            }

            if(status) return true;
            status = true;

            for(int i=size;i>=0;i--){

                if(board.board.get(i).get(size-i).symbol != p.getSymbol()){
                    status= false;
                    break;
                }
            }

        return status;

    }
    /*

    *
     */
    public void display() {

        for(int i=0;i<board.board.size();i++){
            for(int j=0;j<board.getBoard().size();j++){
                System.out.print(board.getBoard().get(i).get(j).symbol+" ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public static class Builder{
        private List<Player> players;
        private int dimension;

        Builder(){

        }
        public Builder(List<Player> players, int dimension) {
            this.players = players;
            this.dimension = dimension;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Game build() throws Exception {
             if(!isValid()) throw new Exception("NO TWO PLAYERS SHOULD HAVE SAME SYMBOL");
            return new Game(this);
        }
        public boolean isValid(){
            if(this.players.size() >= this.dimension) return false;
            if(!validatePlayersDetails()) return false;
            return true;
        }
        public  boolean validatePlayersDetails(){
            Set<Character> symbols = new HashSet<>();
            for(int i=0;i<this.players.size();i++){
                char c = this.players.get(i).getSymbol();
                if(symbols.contains(c)) return false;
                symbols.add(c);
            }
            return true;
        }
    }
}


