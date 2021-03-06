//Checkers class

public class AdvancedCheckers
{
    //initialize all our instance variables, including checker board and pieces
    
    private int black;
    private int red;
    private char whoismoving;
    private char[][] checkerboard;
    private boolean threeblack;
    private boolean threered;

    //constructor creates the checker board and sets instance variables to default values
    
    public AdvancedCheckers()
    {
        checkerboard = new char[8][8];
        black = 12;
        red = 12;
        whoismoving = 'r';
        threered = false;
        threeblack = false;

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                checkerboard[i][j] = '_';
            }
        }

        //creates the board with pieces in order
        for(int k = 1; k < 8; k+=2)
        {
            checkerboard[k][1] = 'r';
            checkerboard[k][5] = 'b';
            checkerboard[k][7] = 'b';
        }

        for(int l = 0; l < 8; l+=2)
        {
            checkerboard[l][0] = 'r';
            checkerboard[l][2] = 'r';
            checkerboard[l][6] = 'b';
        }

        checkerboard[5][7] = 'B';
        checkerboard[5][0] = 'R';
    }

    //displays the checker board, including numbered rows and columns
    
    public void display()
    {
        System.out.println("  1 2 3 4 5 6 7 8 x");
        for(int i = 0; i < 8; i++)
        {
            System.out.print((i+1) + " ");
            for(int j = 0; j < 8; j++)
            {
                System.out.print(checkerboard[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("y");
    }

    //this method move each piece, depending on whose turn it is.
    
    public void move() throws IOException
    {
        Scanner S = new Scanner(System.in);
        if(whoismoving == 'r') System.out.println("Red's turn");
        else if (whoismoving == 'b') System.out.println("Black's turn");
        else if (whoismoving == 'R') System.out.println("Big red's turn");
        else if (whoismoving == 'B') System.out.println("Big black's turn");
        
        //start by inputting coordinates of current position and destination position
        
        boolean didmove = false;
        
        while(!didmove)
        {
            System.out.println("Enter your current coordinates");
            int from = S.nextInt();
            System.out.println("Enter the destination coordinates");
            int to = S.nextInt();
            doMove(from, to);
            didmove = true;
        }
        
        //change pieces after current one makes a move
        
        if (whoismoving == 'r') whoismoving = 'b';
    	  else if (whoismoving == 'b') whoismoving = 'R';
        else if(whoismoving == 'R') whoismoving = 'B';
        else if(whoismoving == 'B') whoismoving = 'r';
    }

    //do the actual move; checker piece moves from one position on the board to another.
    //if a piece eats an opponents piece, opponents piece reduces by 1.
    
    public void doMove(int F, int T)
    {
        int xfrom = F/10 - 1;
        int yfrom = F%10 - 1;
        int xto = T/10 - 1;
        int yto = T%10 - 1;

        checkerboard[xfrom][yfrom] = '_';
        checkerboard[xto][yto] = whoismoving;
        if(Math.abs(xto - xfrom) == 2)
        {
            checkerboard[(xfrom + xto)/2][(yfrom+yto)/2] = '_';
    	    if (whoismoving == 'r') red--;
            //decrease red and black every time it is eaten
    	    else if(whoismoving == 'b') black--;
        }
    }

    //boolean method checks if game is over. Game can be over if either all red or black is gone,
    //or if at least three of an opponents pieces are on the other side
    
    public boolean gameIsOver() {return red == 0 || black == 0 || threePiecesInEnd();}

    //checks if at least three of the opponents pieces are on the other side, to end the game
    
    public boolean threePiecesInEnd()
    {
        int redcount = 0, blackcount = 0;
        for(int i = 0; i < 8; i++)
        {
            if(checkerboard[i][0] == 'b')
            {
                blackcount++;
                threeblack = true;
            }
            else if(checkerboard[i][7] == 'r')
            {
                redcount++;
                threered = true;
            }
        }
        
        //if redcount or balckcount is at last three, game over and that player wins
        
        if(redcount >= 3 || blackcount>= 3) return true;
        else return false;
    }

    //returns the string of whoever won the game at the end
    
    public String whoWon()
    {
        if(threered) return "red";
        else if(threeblack) return "black";
        else if(red == 0) return "red";
        else if(black == 0) return "black";
        else return null;
    }
    
}


