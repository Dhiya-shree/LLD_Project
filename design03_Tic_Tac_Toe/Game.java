package src.design03_Tic_Tac_Toe;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Game {
    private final Board board;
    //Deque -> To make sure turns deciding are easy and Undo
    // Turn deciding - Queue and Deque both works
    // first element makes a moves
    // After move put the player in the end of queue
    // Undo func
    // Need to consider last user , so deque MUST
    private final Deque<Player> players;

    private int TIMEOUT=30;//30 sec timeout for each player

    private static final Scanner SCANNER=new Scanner(System.in);

    private final List<Move> moves;// To enable Undo Operation

    public Game(Board board, Deque<Player> players) {
        this.board = board;
        this.players = players;
        this.moves = new ArrayList<>();
    }

    /**
     *
     *
     * @return GameWinner
     */
    public Player startGame(){

        int totalMoves=board.getSize()*board.getSize();

        while(totalMoves-->0){
           // totalMoves--;
            Player curr=players.pop();// retrieve player to play
            players.add(curr);//put the player at the last
            System.out.printf("%s It's your chance, place %d on the board\n",curr.getName(),
                    curr.getPieceType().getValue());
            System.out.println(" Icon is : "+curr.getPieceType().getCodePoint());
            this.board.print();
          //  int xyz=SCANNER.nextInt();
            // take user input as x,y co-ordinate wth 0-based indexing
            long startTime=System.currentTimeMillis();
            boolean lastMovePlayed=false;
            while(true && !lastMovePlayed){
                long currTime=System.currentTimeMillis();
                long seconds= TimeUnit.MILLISECONDS.toSeconds(currTime-startTime);
                if(seconds>TIMEOUT){
                    System.out.println(" Your last turn .............");
                    lastMovePlayed=true;
                }
                System.out.println(" Please enter position :");
                int x=SCANNER.nextInt();
                int y=SCANNER.nextInt();
                //Stop curr user
                if(x==board.getSize()||y==board.getSize()){
                    stop(curr);
                    break;
                }

                Move currMove=new Move(x,y,curr);
                try{
                    // if move is true , user wins , Return player object
                    if(board.move(currMove)){
                        moves.add(currMove);
                        updateWins(curr);
                        board.print();
                        return curr;
                    }
                    else {
                        if(lastMovePlayed){
                            //NO Undo for last move
                            moves.add(currMove);
                            System.out.println(" Wait next turn for your move ......");

                        }
                        else {
                            board.print();
                            System.out.println(" Press 1 if you want to Undo current move ");
                            System.out.println("Else Press 0 and Wait next turn for your move ......");
                            int undo = SCANNER.nextInt();
                            if (undo == 1 && board.remove(currMove)){
                                  // continue; User undo and board removed piece
                               }
                            else{
                                // User final move
                                moves.add(currMove);
                                break;
                            }

                        }
                    }
                    }
                  catch (IllegalArgumentException e){
                      System.out.println(" Invalid move "+e.getMessage()+" \n Try again !!");
                }
            }

            if(players.size()==1){
                updateWins(players.getFirst());
                return players.getFirst();
            }

        }

        // All moves exhausted
        Player none=new Player("No Winner here !!!",board.getSize());
        updateWins();
        board.print();
        return none;
    }

    void stop(Player player){
        //Delete the user moves
        //Delete super from board
        board.deleteMoves(player);

        //Delete player from list
        players.removeLast();

    }

    void updateWins(){
        // update for all player draw
        for(Player player:players){
            player.getUser().setMatches(player.getUser().getMatches()+1);
            player.getUser().setDraw(player.getUser().getDraw()+1);
        }
    }

    void updateWins(Player win){
        for(Player player:players){
            player.getUser().setMatches(player.getUser().getMatches()+1);
        }

        // update winner
        win.getUser().setWins(win.getUser().getWins()+1);
    }

    void leaderBoard(){

        HashMap<Player,Integer> points=new HashMap<>();
        Iterator iterator=players.iterator();
        while(iterator.hasNext()){
            Player p= (Player) iterator.next();
            points.put(p,p.getUser().getWins()*10+p.getUser().getDraw()*5);
        }

        points=points.entrySet()
                .stream().sorted((p1,p2)->{
                    return p2.getValue()-p1.getValue();
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,Map.Entry::getValue,
                        (e1,e2)->e1,LinkedHashMap::new));
        int prev=0;int i=1;
        for(Map.Entry<Player,Integer> map:points.entrySet()){
            if(map.getValue()==prev || prev==0){
                // Do not increment I same value
            }
            else{
                i++;
            }
            prev=map.getValue();
            System.out.println("Position:"+i+" Points: "+map.getValue()+" -->"+map.getKey().getName());

        }
    }
}
