/* Advanced Checkers is a game made as an independent project. Advanced checkers is like regular checkers,
but in order to win either all of the opponent's pieces must be gone, OR, three of an opponent's pieces must reach the other
opponent's last row. This is the tester class, and the game class is in the other file. */


import java.io.*;
import java.util.*;

//Tester class
public class AdvancedCheckersTester
{
    public static void main(String[] args) throws IOException
    {
        //initialize class object, print out directions of the game and if game is over display the winner
        
        AdvancedCheckers AC = new AdvancedCheckers();
        System.out.println("Welcome to AdvancedCheckers. To win the game, eliminate all pieces of your opponent or get three of your pieces to the other side.");
        System.out.println("Big red and Big Black can move one step in all four directions");
        System.out.println("All other pieces can move one step forward diagonally");
        AC.display();
        
        //display the board and run the game
        
        while(!AC.gameIsOver())
        {
            AC.move();
            AC.display();
        }
        
        //at the end, print the winner
        
        System.out.println(AC.whoWon() + " won the game");
    }
}

