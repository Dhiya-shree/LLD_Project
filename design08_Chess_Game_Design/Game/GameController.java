package src.design08_Chess_Game_Design.Game;
import src.design08_Chess_Game_Design.Board.Cell;
import src.design08_Chess_Game_Design.Board.Moves.Coordinate;
import src.design08_Chess_Game_Design.Board.Moves.Move;
import java.util.Scanner;

public class GameController {

    Game game;
    Scanner sc=new Scanner(System.in);
    Timer timer;

    public Player start(Player playerA,Player playerB){
        game=new Game(playerA,playerB);
        timer=new Timer();
        timer.setTime(2,1);
        timer.TimerStart();

        while(true){

            Player playerTurn= game.getPlayerTurn();
            boolean changed=false;
            timer.TimerStart();
            while(!changed && timer.CheckTime()) {
                Move move = getMoveInput();
                //game.getBoard().print();
                if(move==null){
                    System.out.println(playerTurn.getName()+" Draw !!!!");
                    return nextPlayerTurn();
                }

               changed= game.getBoard().setCell(move);

               if(changed){
                   nextPlayerTurn();
                   if(isCheckMate()){
                       return playerTurn;
                   }
                   else if(isCheck()){
                       System.out.println(game.getPlayerTurn().getName()+" You are in Check !!");
                   }
               }

            }

            if(!changed){
                System.out.println(" No moves from other player");
                return nextPlayerTurn();
            }
        }
    }

    private Move getMoveInput() {


        while(timer.CheckTime()){
        System.out.println(" Turn of " + game.getPlayerTurn().getName());
        System.out.println(" Move your piece " + game.getPlayerTurn().getColor());
        game.getBoard().print();

        System.out.println(" Enter the coordinates of current piece / 8 for draw ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x==8||y==8){
            System.out.println(" User "+game.getPlayerTurn().getName()+" Draw ");
            return null;
        }
        Coordinate startPos = new Coordinate(x, y);
        Cell startCell = game.getBoard().getCell(startPos);

        if (startCell.isFree()) {
            System.out.println(" No piece at the place !! Try again ");
          //  continue;
        } else if (startCell.getPiece().getColor() != game.getPlayerTurn().getColor()) {
            System.out.println(" Can not move opponent's piece");
         //   continue;
        } else {
            System.out.println(" Enter the coordinates of where you want to move "+startCell.getPiece().getPieceType());
            x = sc.nextInt();
            y = sc.nextInt();
            Coordinate endPos = new Coordinate(x, y);
            Cell end = game.getBoard().getCell(startPos);
            Move notCheckedMove=new Move(startPos,endPos,startCell.getPiece());
            if(isValidMove(notCheckedMove, game.getPlayerTurn())){
                if(game.getBoard().setCell(notCheckedMove)){
                    return notCheckedMove;
                }
            }
        }
    }

        return null;
    }

    private boolean isValidMove(Move move,Player playerTurn){

        return move.getPiece().isValidMove(move);
    }

    private Player nextPlayerTurn(){
        if(game.getPlayerTurn().equals(game.getPlayerA())){
           return game.getPlayerB();
        }
        else{
            return game.getPlayerA();
        }
    }

    private boolean isCheckMate(){
        return false;
    }

    private boolean isCheck(){

        return false;
    }





}
