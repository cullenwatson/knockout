

public class Kid extends ScoreCard {

	public Kid() {
		super(8);
	}

	public String toString() {
		return "KIDS SCORE CARD \n" + super.toString();
	}

	public boolean isComplete() {
		boolean isCompleted = false;
		int knockedOuts = 0;

		// Loops through score card and changes isCompleted to true if all 8 values are 1
		for (int i = 1; i <= 8; i++) {
			
			if (isKnockedOut(i))
				knockedOuts++;
			
		}

		if (knockedOuts == 8)
			isCompleted = true;

		return isCompleted;
	}
}
