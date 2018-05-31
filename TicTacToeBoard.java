import java.util.Scanner;

public class TicTacToeBoard
{
  private char[][] Board =
  {
  {' ', ' ', ' '},
  {' ', ' ', ' '},
  {' ', ' ', ' '}
  };
  
  private int Row = 0;
  private int Col = 0;
  private char C = ' ';
  private boolean Done = false;
  private int player = 1;

  public TicTacToeBoard(char[][] board, int row, int col, char c, int player)
  {
    char[][] Board = board;
    int Row = row;
    int Col = col;
    char C = c;
    boolean done = false;
  }
  
  public void toString(char[][] board) 
  {
    for (int row = 0; row <= 2; row++) 
    {
        System.out.print("|");
        for (int col = 0; col <= 2; col++) 
        {
            System.out.print(board[row][col]);
        }
        
        System.out.println("|");
    }
  }

  public void makeMove(char[][] board, int row, int col, char c, int player) 
  {
    if (player == 1) board[row-1][col-1] = 'X';
    else board[row-1][col-1] = 'O';
    toString(board);
  }

  public boolean isWin(char[][] board) 
  {
    boolean flag = false;
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;

    // checks the contents of each row for matching data
    for (int i = 0; i <= 2; i++) 
    {
        if ((board[i][0] == board[i][1] && board[i][1] == board[i][2]) && board[i][2] != ' ')
            flag1 = true;
    }
    
    // checks the contents of each column for matching data
    for (int j = 0; j <= 2; j++) 
    {
        if ((board[0][j] == board[1][j] && board[1][j] == board[2][j]) && board[2][j] != ' ')
            flag2 = true;
    }
    
    // checks the contents of one diagonal for matching data
    if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[2][2] != ' ')
        flag3 = true;
        
    // checks the contents of the other diagonal for matching data
    if ((board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[2][0] != ' ')
        flag4 = true;
        
    // checks if any of the previous conditions evaluated to true
    if (flag1 == true || flag2 == true || flag3 == true || flag4 == true)
        flag = true;
        
    // returns true if a winner was found; returns false is no winner
    return flag;
  } // end of checkForWinner method

}
