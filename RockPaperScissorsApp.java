/**
RockPaperScissorsApp.java  --  an initial programme to play the game RockPaperScissors
@author Dean McGuinness
studentID xxxxxxxxx
@date 19/11/2014
*/

import java.util.Scanner;

public class RockPaperScissorsApp{
    public static void main(String[] args){
//Input
		int 	numGames;
        String 	computerShape,
               	userShape;

		//myNote: This is to be moved into the RPS class along with any associated methods
      	int results [];
      	results = new int[9];
        	results[0] = 0; //userWins
			results[1] = 0;	//compLost
			results[2] = 0;	//compWins
			results[3] = 0;	//userLost
			results[4] = 0;	//draw
			results[5] = 0;	//number of rounds
			results[6] = 3;	//lives
			results[7] = 0;	//number of games

//Process

		Scanner sc = new Scanner(System.in);
		RockPaperScissors RPS = new RockPaperScissors(); 			//Creating an object of the class

		numGames = RPS.numberOfGames();								//Number of games is initialized.
		RPS.invalidEntry(numGames);									//Play game condition: user must choose more than 0 to play the game.

				for(int i = 0; i < numGames; i++){ 					//Game repeats continually: repeat the game according to the user's input.
					results[6] = 3;									//Lives
					while(results[6] > 0){							//Lives condition: lives must be greater than 0.
			        	computerShape = RPS.computerChoice();		//Here we initialize the computer's selected shape.
			        	userShape = RPS.userChoice();				//Here we initialize the user's selected shape.


//Execute and produce the winner

							while(userShape == null){											//validate that the user enters either rock, paper, or scissors only
								System.out.println("Incorrect Entry. Please enter 'rock', 'paper', or 'scissors'.");
 								userShape = RPS.userChoice();
							}
							RPS.printCompShape(computerShape);									//display the computer's chosen shape for this round
		     				RPS.computeWinner(computerShape, userShape, results);				//Computing the winners.
  		     				RPS.displayRounds(results);											//Displaying the winners.
							RPS.displayGames(results);

							RPS.produceGameOverStats(results);							//when lives reach '0' or when one game is over, we then produce results
							RPS.createStoredShapes(userShape, computerShape);

						}//while loop

						RPS.displayStoredShapes();

				}//for loop
	}// main method
}//Class end curly brackey.


