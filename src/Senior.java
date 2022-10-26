
public class Senior extends ScoreCard {

	public Senior() {
		super(6);
	}

	public String toString() {
		return "SENIOR SCORE CARD \n" + super.toString();
	}

	public boolean isComplete() {
		
		boolean isCompleted = false;
		int knockedOuts = 0;

		// Loops through score card and changes isCompleted to true if all 6 values are 1
		for (int i = 1; i <= 6; i++) {
			
			if (isKnockedOut(i))
				knockedOuts++;
		}

		if (knockedOuts == 6)
			isCompleted = true;

		return isCompleted;
	}

}
