
package backend;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Scanner;

public class HangmanApp extends Hangman
{
    public HangmanApp() {
        super();
    }
    
    public void startGame() {
        System.out.println ("Welcome to Hangman by Ritchie!");
        boolean doYouWantToPlay = true;
        
        System.out.println ("Let's Begin!");
        System.out.println ();
        this.question();
    }
    
    // TODO: this print a new layout everytime
    public void question() {
        System.out.println (this.drawPicture());
        System.out.println ();
        System.out.println (this.getFormalCurrentGuess());
        System.out.println (this.mysteryWord);
    }
    
    public static void main(String[] args) throws IOException, AWTException, InterruptedException
    {
        Scanner sc = new Scanner (System.in);
        System.out.println ("Welcome to Hangman by Ritchie!");
        boolean doYouWantToPlay = true;

        while (doYouWantToPlay)
        {
            System.out.println ("Let's Begin!");
            Hangman game = new Hangman();

            do
            {
                //Setup the board
                System.out.println ();
                System.out.println (game.drawPicture());
                System.out.println ();
                System.out.println (game.getFormalCurrentGuess());
                System.out.println (game.mysteryWord);

                //Get the guess
                System.out.println ("Enter a character.");
                char guess = (sc.next().toLowerCase()).charAt(0);
                System.out.println ();

                //check ifa the character have been guessed
                while (game.isGuessed(guess))
                {
                    System.out.println ("Try again. Character already guessed");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }

                game.clearConsole();
                
                if (game.playGuess(guess))
                {
                    System.out.println ("Good guess!");
                }
                else
                {
                    System.out.println ("Character not in the word.");
                }
            }
            while (!game.gameOver());

            System.out.println ();
            System.out.println ("Enter Y to keep playing"
                + " or anything else to exit.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');
        }
    }
    
    public void buttonDecider(char input, javax.swing.JTextArea area) {
        area.setText("");
        // TODO: the word might contains y
        if (input == 'y') {
            this.startGame();
        }else {
            if (this.isGuessed(input))
            {
                System.out.println ("Try again. Character already guessed");
    //            input = (sc.next().toLowerCase()).charAt(0);
            }else {
                if (this.playGuess(input))
                {
                    System.out.println ("Good guess!");
                }
                else
                {
                    System.out.println ("Character not in the word.");
                }
            }
        }
        if (this.gameOver()){
            System.out.println ();
            System.out.println ("Enter Y to keep playing" + " or anything else to exit.");
        }else {
            this.question();
        }
    }
}