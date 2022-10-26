
public class ScoreCard {

	private int numbers[];

	public ScoreCard() {
		
		// creates integer array of size 12
		numbers = new int[12];
		
	}

	public ScoreCard(int size) {
		
		// creates integer array of size [size]
		numbers = new int[size];
		
	}

	// Knocks out value by changing array value to 1
	public void knockOut(int value) {
		value = value - 1;
		
		// checks for valid value
		if (value < numbers.length)
			numbers[value] = 1;
	}

	public boolean isKnockedOut(int value) {

		// check if the value is from range 1-12
		if (value < 1)
			return false;
		
		if (value > numbers.length)
			return true;
		
		// checks if the value has been already knocked out
		if (this.numbers[value - 1] == 1)
			return true;
		else
			return false;
	}

	public boolean isComplete() {

		// sets isComplete variable to value
		boolean isCompleted = false;
		int knockedOuts = 0;

		// loops through ScoreCard and changes isCompleted to true if all 12 values are 1
		for (int i = 1; i <= numbers.length; i++) {
			
			if (isKnockedOut(i))
				knockedOuts++;
		}

		if (knockedOuts == numbers.length)
			isCompleted = true;

		return isCompleted;
	}

	public String toString() {

		// method returns ScoreBoard with knocked out values
		String result = "   Remaining:";
		
		for (int i = 1; i <= numbers.length; i++) {
			if (!isKnockedOut(i)) {
				result += " " + Integer.toString((i));
				
			} else {
				result += " " + "_";
			}
		}

		return result;
	}
}
