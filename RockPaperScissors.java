/**
RockPaperScissors.java	-- an instantiable class for the programme RockPaperScissors
@author Dean McGuinness
studentID xxxxxxxxx
@date 19/11/2014
*/

import java.util.Scanner;
public class RockPaperScissors{

	private	int games;

	private String compShape[];

	private String userChoice,
  	               userChoiceLowerCase;

	private int storeRoundResults[];

	private String 	userStoredShapes[] = new String[50];
  	private String 	compStoredShapes[] = new String[50];
	private int 	position = 0;
    private int 	index = 0;


//numberOfGames
public int numberOfGames(){

	System.out.println("\t Let's play a game of 'Rock, Paper, Scissors'!\n");

	Scanner sc = new Scanner(System.in);
	System.out.println("HOW MANY GAMES WOULD YOU LIKE TO PLAY?");
	games = sc.nextInt();

	if(games > 0){																//Statement to validate that the user's input is a valid number.
		return games;
	}else{
		System.out.println("Not a valid input. Please enter a valid number.");
		System.out.println("");
	}
	return games;
	}


//User must choose more than '0' to play the game
public void invalidEntry(int numGames){
	while(numGames < 1){ 			  						//Play game condition: user must choose more than 0 to play the game.
		numGames = this.numberOfGames();
	}
}


//computerChoice
    public String computerChoice(){

			compShape = new String[3];
				compShape[0] =  "rock";
				compShape[1] =  "paper";
				compShape[2] =  "scissors";
			int randomNum = (int)(Math.random()*3);							//Random number to be chosen for the computer's selection.

			return compShape[randomNum]; //remove '1' and insert randomNum			//returned is the randomly selected shape

	}

//print computer's choice
public void printCompShape(String computerShape){
		System.out.println("The computer chose " + computerShape + "."); 	//Printing the computer's selected shape at each round.
}

//userChoice
    public String userChoice(){

		Scanner sc = new Scanner(System.in);
		System.out.println("");
        System.out.println("PLEASE ENTER YOUR CHOICE.");
        userChoice = sc.next();


        if (userChoice.equalsIgnoreCase("rock") || userChoice.equalsIgnoreCase("paper")
                || userChoice.equalsIgnoreCase("scissors")){				//Entry is not case sensitive.
           userChoiceLowerCase = userChoice.toLowerCase();					//Initialize user's choice to lower case before returning it.
        }
       else{
           userChoiceLowerCase = null;
		}
        return userChoiceLowerCase;											//Value is returned in lower case
    }


//computeWinner: computing the result of the round
    public void computeWinner(String computerShape, String userShape, int results[]){

        if (computerShape.equals(userShape)){
            System.out.println(" It is a draw in this round! Play again!");
					            results[4]++; //draw
	            				results[5]++; //number of rounds
		}
        else if (computerShape.equals("rock") && userShape.equalsIgnoreCase("paper")){
            System.out.println(" User wins the round! Paper beats rock.");
			  			      	results[0]++;  //userWins
								results[1]++;  //compLost
					            results[5]++; //number of rounds
		}
		else if (computerShape.equals("paper") && userShape.equalsIgnoreCase("rock")){
            System.out.println(" User lost the round. Paper beats rock.");
            					results[2]++;	//compWins
								results[3]++;	//userLost
					            results[5]++; //number of rounds
							    results[6]--; //decrement lives here
		}
        else if (computerShape.equals("scissors") && userShape.equalsIgnoreCase("rock")){
            System.out.println(" User wins the round! Rock beats scissors.");
			  			      	results[0]++;  //userWins
								results[1]++; //compLost
					            results[5]++; //number of rounds
		}
        else if (computerShape.equals("rock") && userShape.equalsIgnoreCase("scissors")){
            System.out.println(" User lost the round. Rock beats scissors.");
								results[2]++;	//compWins
								results[3]++;	//userLost
					            results[5]++; 	//number of rounds
							    results[6]--;	//decrement lives here
		}
        else if (computerShape.equals("paper") && userShape.equalsIgnoreCase("scissors")){
            System.out.println(" User wins the round! Scissors beats paper.");
			  			      	results[0]++; 	//userWins
								results[1]++; 	//compLost
					            results[5]++; 	//number of rounds

		}
        else{
            System.out.println(" User lost the round. Scissors beats paper.");
								results[2]++;	//compWins
								results[3]++;	//userLost
					            results[5]++; 	//number of rounds
							    results[6]--; 	//decrement lives here
		}


	}


//store the chosen shapes into an array
public void createStoredShapes(String userShape, String computerShape){
							userStoredShapes[position] = userShape;
							position++;
							compStoredShapes[index] = computerShape;
							index++;
}


//display the shapes chosen by the user and the computer
public void displayStoredShapes(){
						position = 0;
						index = 0;

						System.out.println(" User's shapes:");
						for(int row = 0; row < userStoredShapes.length; row++){
							if(userStoredShapes[row]!= null){
								System.out.print("  " + userStoredShapes[row]+", ");
							}
						}
						System.out.println("\n Computer's shapes:");
						for(int row = 0; row < userStoredShapes.length; row++){
							if(compStoredShapes[row]!= null){
								System.out.print("  " + compStoredShapes[row]+", ");
							}
						}
						System.out.println();
}


//Display number of Rounds played with results
	public void displayRounds(int results[]){
		System.out.println(" You played " + results[5] + " rounds(s).");
		System.out.println(" Lives: " + results[6]);
		System.out.println("\n Round Stats: \n  User Rounds Won: " + results[0] + ".\n  User Rounds Lost: " + results[3] + ".\n  Computer Rounds Won: " + results[2] + ".\n  Computer Rounds Lost :" + results[1] + ". \n  Draws: " + results[4]);


	}

//Display number of Games played
public int displayGames(int results[]){
	if(results[6] == 0){ //lives											//When Lives reach 0 then one game ends.
		results[7]++;	 //numberOfGames									//Number of Games increment.
		}
	return results[7];
	}

//End of game statistics
	public void gameStats(int results[]){

		storeRoundResults = new int [5];

		System.out.println("");
		System.out.println("GAME STATISTICS: \n You played " + results[7] + " game(s)\n You played " + results[5] + " rounds(s).");
		System.out.println(" Lives: " + results[6]);

				//storing the shapes manually
				storeRoundResults[0] = results[0]; //User Rounds Won
				storeRoundResults[1] = results[3]; //User Rounds Lost
				storeRoundResults[2] = results[2]; //Computer Rounds Won
				storeRoundResults[3] = results[1]; //Computer Rounds Lost
				storeRoundResults[4] = results[4]; //Draw

				//printing the shapes manually
				System.out.println("\n Game " + results[7] + ": ");
				System.out.println("  User: rounds won: " + storeRoundResults[0]);
				System.out.println("  User: rounds lost: " + storeRoundResults[1]);
				System.out.println("  Computer: rounds won: " + storeRoundResults[2]);
				System.out.println("  Computer: rounds lost: " + storeRoundResults[3]);
				System.out.println("  Draws: " + storeRoundResults[4]);
	}

//when lives reach '0' or when one game is over, we then produce results
public void produceGameOverStats(int results[]){
	if(results[6] == 0){ //If lives equal to zero
		this.gameStats(results);											//End of game statistics
		this.overallWinner(results);
	}
}

//Overall winner
public void overallWinner(int results[]){								//Method to decide on the game winner.

if(results[0] > results[2]){											//userWins, compWins
	System.out.println("\n Overall winner:\n  User.\n");
	}else if(results[2] > results [0]){
		System.out.println("\n Overall winner:\n  Computer.\n");
		}else{
			System.out.println("\n Overall result:\n  Draw.\n");
	}
}



}//Class end.
