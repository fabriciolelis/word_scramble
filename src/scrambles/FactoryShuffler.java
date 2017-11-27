package scrambles;

import java.util.Random;

public class FactoryShuffler {
	private static final int shuffles = 1;

	private int randomShuffles() {
		Random rand = new Random();
		int randomValue = rand.nextInt(shuffles);
		return randomValue;
	}
	
	public Shuffler chooseShuffler() {
		int shuffleNumber = randomShuffles();
		switch (shuffleNumber) {
		case 1:
			return new ReverseShuffler();

		default:
			return new ReverseShuffler();
		}
		
	}
	
	

}
