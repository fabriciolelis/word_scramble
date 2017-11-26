package game_mechanics;

import scrambles.FactoryShuffler;
import scrambles.Shuffler;

public class GameModeOne implements GameMechanics {
	private Shuffler shuffler;
	private String shuffledWord;
	private String hiddenWord;
	private int totalWords;
	private int attempts;

	public GameModeOne() {
		FactoryShuffler fs = new FactoryShuffler();
		shuffler = fs.chooseShuffler();
		attempts = 0;
		totalWords = 1;
	}
	
	@Override
	public String getScrambledWord() {
		this.hiddenWord = shuffler.getWordOnBank();
		shuffledWord = shuffler.shufflerWord(this.hiddenWord);
		return shuffledWord.toUpperCase();
	}

	@Override
	public boolean compareWords(String typedWord) {
		attempts+= 1;
		return this.hiddenWord.toUpperCase().equals(typedWord.toUpperCase());
	}

	@Override
	public boolean continueGame() {
		totalWords+= totalWords;
		return totalWords < 9;
	}

	@Override
	public String getHiddenWord() {
		hiddenWord = shuffler.getHiddenWord();
		return hiddenWord;
	}
}
