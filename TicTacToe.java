/* Tic Tac Toe game created as an independent project. This is the main class; the board class is in the 
other file. */

import java.util.Scanner;

public class TicTacToe 
{
  public static void main(String[] args) 
  {
      char[][] board =
      {
      {' ', ' ', ' '},
      {' ', ' ', ' '},
      {' ', ' ', ' '}
      };
      
      int row = 0;
      int col = 0;
      char c = ' ';
      boolean done = false;
      int player = 1;
      String name = " ";
      String name2 = " ";
      
      TicTacToeBoard myBoard = new TicTacToeBoard(board, row, col, c, player);
      myBoard.toString(board);
          
      Scanner input = new Scanner(System.in);
      System.out.println("Enter player one's name");
      name = input.nextLine();
      System.out.println("Enter player two's name");
      name2 = input.nextLine();
      
      do 
      {
          if (player == 1)
          System.out.println("It is  " + name + "s  " + "turn");
          if (player == 2)
          System.out.println("It is  " + name2 + "s  " + "turn");
          System.out.println("Pick a row between 1 and 3");
          row = input.nextInt();
          System.out.println("Pick a column between 1 and 3");
          col = input.nextInt();
          myBoard.makeMove(board, row, col, c, player);
          done = myBoard.isWin(board);
          
          if (done == true)
          {
              if (player==1) System.out.println("Game over  " + name + "  wins");
              else if (player==2) System.out.println("Game over  " + name2 + "  wins");
          }
          
          if (player == 1) player = 2;
          else if (player == 2) player = 1;

      } while (done != true);
  }
}
