package game_mechanics;

import scrambles.FactoryShuffler;
import scrambles.Shuffler;

public class GameModeOne implements GameMechanics {
	private Shuffler shuffler;
	private String shuffledWord;
	private String hiddenWord;
	private int attempts;

	public GameModeOne() {
		FactoryShuffler fs = new FactoryShuffler();
		shuffler = fs.chooseShuffler();
		attempts = 0;
	}
	
	@Override
	public String getScrambledWord() {
		shuffledWord = shuffler.getScrambledWord();
		return shuffledWord;
	}

	@Override
	public boolean compareWords(String digitedWord) {
		attempts+= 1;
		return shuffler.getHiddenWord().equals(digitedWord);
	}

	@Override
	public String getHiddenWord() {
		hiddenWord = shuffler.getHiddenWord();
		return hiddenWord;
	}

}
