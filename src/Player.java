
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Player {

	// creates ScoreCard objects for each player
	public ScoreCard myScoreCard;
	public Scanner scan = new Scanner(System.in);

	private String name;

	public Player(String name, String scoreCardType) {

		// set player name from passed string
		this.name = name;
		
		if (scoreCardType.toLowerCase().equals("senior")) {
			
			// creates an instance for Senior class
			myScoreCard = new Senior();
			
		} else if (scoreCardType.toLowerCase().equals("kid")) {
			
			// Creates an instance for Kid class
			myScoreCard = new Kid();
			
		} else {
			myScoreCard = new ScoreCard();
		}

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String takeTurn(Shaker shaker) {
		
		String str = "";
		String toReturn = "", toDisplay = "";
		
		// creates Scanner and rolls die
		shaker.shake();
		
		// Outputs shake results to user
		str = "Rolled " + shaker.toString();
		System.out.println(str);
		toDisplay += str + "\n\n";
		toReturn += str + "\n";
		
		str = myScoreCard.toString();
		System.out.println(str);
		toDisplay += str + "\n";
		toReturn += str + "\n";

		// stores shaker output
		int die1 = shaker.getDie1();
		int die2 = shaker.getDie2();
		int sum = shaker.getSum();

		// check if there is anything left to knock out.
		if (myScoreCard.isKnockedOut(die1) && myScoreCard.isKnockedOut(die2) && myScoreCard.isKnockedOut(sum)) {

			// if there is nothing left to knock out, player's move is skipped
			str = "Nothing to knock out. Next player's turn.";
			JOptionPane.showMessageDialog(null, str, "Nothing To Knock Out", JOptionPane.WARNING_MESSAGE);
			System.out.println(str);

		} else {

			// sorts the dice in ascending order and displays to user
			if (die1 != die2) {
				if (die1 > die2) {
					
					int temp = die1;
					die1 = die2;
					die2 = temp;
				}
				
				str = "  Knock out " + die1 + ", " + die2 + " or " + sum + "? ";
				System.out.print(str);
				
			} else {
				
				str = "  Knock out " + die1 + " or " + sum + "? ";
				System.out.print(str);
				
			}

			// loops through while loop until a correct value is selected by the user
			boolean isDone = false;

			while (isDone != true) {

				// gets user input
				int choice = -1;
				
				// handles inputs
				try {
					choice = Integer.parseInt((String) JOptionPane.showInputDialog(null, toDisplay + " " + str,
							name + "'s Turn", JOptionPane.INFORMATION_MESSAGE));
				} catch (Exception e) {
				}
				
				// get the size of the board
				int size = myScoreCard instanceof Senior ? 6 : myScoreCard instanceof Kid ? 8 : 12;

				// knocks out value if value hasn't been knocked out yet
				if (!myScoreCard.isKnockedOut(choice) && (choice == die1 || choice == die2 || choice == sum)
						&& choice <= size) {

					// knock out the choice if its valid
					myScoreCard.knockOut(choice);
					isDone = true;

				} else {

					// prints two possible errors to user if incorrect value is inputed
					String error = "", errorTitle = "Invalid Response";

					if ((choice == die1 || choice == die2 || choice == sum) && choice < size) {
						
						error = "  That value has already been knocked out. Select again.";
						errorTitle = "Already Knocked Out";
						
					} else
						error = "  Invalid response. Try again.";

					System.out.println(error);
					JOptionPane.showMessageDialog(null, error, errorTitle, JOptionPane.ERROR_MESSAGE);

				}

			}

		}

		// prints current score card after player's move
		str = myScoreCard.toString();
		System.out.println(str);
		
		toReturn += str + "\n";
		return toReturn;

	}

	public boolean isDone() {

		return myScoreCard.isComplete();

	}

	public String toString() {

		return getName();

	}

	public String printResult() {
		String str = "";
		try {
			
			// creates a new file with output.txt as name
			File myObj = new File("output.txt");
			
			myObj.createNewFile();
			FileWriter fw = new FileWriter("output.txt");

			str = "Game Results:\n************************************\n" + name + " Wins!!!\n" + myScoreCard.toString()
					+ "\n************************************";
			
			// read characters from string and writes them into FileWriter
			for (int i = 0; i < str.length(); i++)
				fw.write(str.charAt(i));

			// close the file
			fw.close();
		}
		
		// catches exception in file handling
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			
		}
		return str;
	}

}