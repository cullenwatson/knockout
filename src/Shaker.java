
public class Shaker {

	private Die die1, die2;

	public Shaker() {

		// creates 2 dice
		die1 = new Die();
		die2 = new Die();
	}

	public void shake() {

		// randomizes two dice
		die1.roll();
		die2.roll();

	}

	public int getDie1() {

		// returns value of die 1
		return die1.getValue();

	}

	public int getDie2() {

		// returns value of die 2
		return die2.getValue();

	}

	public int getSum() {

		// returns the value of die 1 + die 2
		return getDie1() + getDie2();

	}

	public String toString() {

		// returns a string with single value if both values are equal
		if (die1.getValue() == die2.getValue())
			return die1 + "";
		
		// returns a string with both values
		return die1 + " and " + die2;

	}
}
