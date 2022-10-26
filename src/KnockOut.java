

import java.io.File;
import java.io.FileNotFoundException; 
import java.util.*;

public class KnockOut {

	public boolean gameOver = false;
	List<Player> playerArray = new ArrayList<>();

	int currentPlayer = 0, totalPlayers = 0;

	public KnockOut() {

	}

	public void createPlayers() {
		try {
			
			File myObj = new File("players.txt");
			Scanner myReader = new Scanner(myObj);
			
			// reads in player's names and type of ScoreCard from file
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] dataArr = data.split(",");
				
				// Creates player objects and adds to ArrayList
				playerArray.add(new Player(dataArr[0], dataArr[1]));
				totalPlayers++;
				
			}
			myReader.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public String playGame() {

		// creates new shaker class and player array
		Shaker theShaker = new Shaker();
		createPlayers();
		String toReturn = "";
		
		// loops until the game is over
		while (gameOver != true) {

			// current player's turn
			toReturn += playerArray.get(currentPlayer).takeTurn(theShaker);
			
			// checks if current player has won
			if (playerArray.get(currentPlayer).isDone()) {
				
				System.out.println("Game over. " + playerArray.get(currentPlayer).toString() + " is the winner!");
				toReturn += playerArray.get(currentPlayer).printResult();
				gameOver = true;
				
			} else {

				// changes the id of the active player
				currentPlayer = (currentPlayer + 1) % totalPlayers;
			}

		}
		// return logs to TextArea
		return toReturn;
	}

}