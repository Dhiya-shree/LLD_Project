package src.design03_Tic_Tac_Toe;

import java.util.*;

public class Board {
 private final int size;
 private final PieceType board[][];

 // Row Matrix to check if user got BINGO
 /**
  * Row Frequency
  *  List1 Row1 { player1-1 , player3-4}   player2 no entry so no value
  *  List2 Row2  { player x-n} BINGO
  *  .
  *  ListN RowN
  */
 private final List<HashMap<Integer,Integer>> rowFrequency;
 private final List<HashMap<Integer,Integer>> colFrequency;
 private final HashMap<Integer,Integer> mainDiagonal;
 private final HashMap<Integer,Integer> crossDiagonal;


    public Board(int size) {
        this.size = size;
        this.board = new PieceType[size][size];
        this.rowFrequency = new ArrayList<HashMap<Integer, Integer>>(size) ;
        this.colFrequency = new ArrayList<HashMap<Integer, Integer>>(size) ;
        for(int i=0;i<size;i++){
            rowFrequency.add(new HashMap<Integer,Integer>());
            colFrequency.add(new HashMap<Integer,Integer>());
        }
        this.mainDiagonal = new HashMap<Integer, Integer>(size);
        this.crossDiagonal= new HashMap<Integer, Integer>(size);
    }

    /**
     *
     * @param x
     * @param y
     * @param player
     * @return
     *   true -> if player won
     *   false -> if player not win
     *   Exception -> if position not exist/already occupied
     *
     * @throws IllegalArgumentException
     */
    public boolean move(Move move) throws IllegalArgumentException {
        // Not able to set
        int x=move.getX();int y=move.getY();Player player=move.getPlayer();

        if (x < 0 ||  x >= size ){
            throw new IllegalArgumentException(" Row limit exceeded !!!");
        }
        else if(y<0|| y >= size){
            throw new IllegalArgumentException(" Col limit exceeded !!!");
        }
        else if(board[x][y] != null){
            throw new IllegalArgumentException(" Position already occupied !!!");
        }

        // Set value successful
        board[x][y] = player.getPieceType();

        //Set Frequency
        int val = player.getValue();
        rowFrequency.get(x).put(val, rowFrequency.get(x).getOrDefault(val, 0) + 1);
        colFrequency.get(y).put(val, colFrequency.get(y).getOrDefault(val, 0) + 1);
        if (x == y) {//mainDiagonal
            mainDiagonal.put(val, mainDiagonal.getOrDefault(val, 0) + 1);
        }
        if (x == size - y - 1) {//crossDiagonal
            crossDiagonal.put(val, crossDiagonal.getOrDefault(val, 0) + 1);
        }

        //check if win
        if (rowFrequency.get(x).getOrDefault(val,0) == size || colFrequency.get(y).getOrDefault(val,0) == size ||
                crossDiagonal.getOrDefault(val,0) == size || mainDiagonal.getOrDefault(val,0) == size) {
            return true;
        }
        return false;
    }
        /** INSTEAD of Multiple if..else use getOrDefault func
        // Check if moves makes a win
        // Update in row freq
        int rowFreq=1;
        if(rowFrequency.get(x).containsKey(val)){
            rowFreq=rowFrequency.get(x).get(val)+rowFreq;
            rowFrequency.get(x).put(val,rowFreq);
            if(rowFreq==size){
                return true;
            }
        }
        else{
            rowFrequency.get(x).put(val,rowFreq);
        }

        // Update in col Freq
        int colFreq=1;
        if(colFrequency.get(y).containsKey(val)){
           colFreq=colFrequency.get(y).get(val)+colFreq;
            colFrequency.get(y).put(val,colFreq);
            if(colFreq==size){
                return true;
            }
        }
        else{
            colFrequency.get(y).put(val,colFreq);
        }


        // Update in main Diagonal
        // if x == size-y-1 it is main diagonal
        // if x==y it is cross diagonal
        if(x == size-y-1) {
            if (mainDiagonal.size() > 2) {// already diagonal has two values no update needed
                //skip
            } else {
                if (mainDiagonal.containsKey(val)) {
                    mainDiagonal.put(val, mainDiagonal.get(val) + 1);
                }
                else{
                    mainDiagonal.put(val,1);
                }
            }
        }
        if(x==y) {
            if (crossDiagonal.size() > 2) {// already diagonal has two values no update needed
                //skip
            } else {
                if (crossDiagonal.containsKey(val)) {
                    crossDiagonal.put(val, crossDiagonal.get(val) + 1);
                }
                else{
                    crossDiagonal.put(val,1);
                }
            }
        }


        return false;
    }
         */

    public int getSize() {
        return size;
    }

    public void print(){
        System.out.print(" +|");
        for(int i=0;i<size;i++){
            System.out.print(" | "+i+" | ");
        }
        System.out.println();
        for(int i=0;i<size;i++){
          //  System.out.println("--------------------");
            System.out.print((i)+"+|");
            for(int j=0;j<size ;j++){
                if(board[i][j]==null){
                    System.out.print(" |   | ");
                }
                else{
                    System.out.print(" | "+board[i][j].getCodePoint()+" | ");
                }
              //  System.out.print(" ");
            }
            System.out.println();

        }
    }

    public void deleteMoves(Player player){
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
              if(board[i][j].getValue()==player.getPieceType().getValue()){
                  board[i][j]=null;
              }
            }
        }
    }

    public PieceType[][] getBoard() {
        return board;
    }

    public List<HashMap<Integer, Integer>> getRowFrequency() {
        return rowFrequency;
    }

    public List<HashMap<Integer, Integer>> getColFrequency() {
        return colFrequency;
    }

    public HashMap<Integer, Integer> getMainDiagonal() {
        return mainDiagonal;
    }

    public HashMap<Integer, Integer> getCrossDiagonal() {
        return crossDiagonal;
    }

    public boolean remove(Move move) {
        int x=move.getX();
        int y=move.getY();
        Player player=move.getPlayer();
        if(board[x][y].getValue()== player.getValue()){
            board[x][y]=null;
            //Set Frequency
            int val = player.getValue();
            if(rowFrequency.get(x).containsKey(val)){
                rowFrequency.get(x).put(val, rowFrequency.get(x).get(val)-1);
            }

            if(colFrequency.get(y).containsKey(val)){
                colFrequency.get(y).put(val, colFrequency.get(y).get(val)-1);
            }

            if (x == y && mainDiagonal.containsKey(val)) {//mainDiagonal
                mainDiagonal.put(val, mainDiagonal.get(val)-1);
            }
            if (x == size - y - 1 && crossDiagonal.containsKey(val)) {//crossDiagonal
                crossDiagonal.put(val, crossDiagonal.get(val)-1);
            }

            return true;
        }
        else{
            System.out.println(" Not able to undo !!!");
            return false;
        }
    }
}
