
public class Die {

	private int value;

	public Die() {

		// sets default value of die to 1
		value = 1;
	}

	public void roll() {

		// sets die equal to a random value from 1 to 6
		value = (int) (Math.random() * 6 + 1);
	}

	public int getValue() {

		// returns die value
		return value;
	}

	public void setValue(int value) {

		// sets fixed value if value is from 1 to 6, otherwise just randomize
		if (1 <= value && value <= 6) {
			this.value = value;
		} else {
			roll();
		}

	}

	public String toString() {

		// converts integer value to a string value and returns it
		return Integer.toString(value);
	}

}
