package game_mechanics;

import constants.NumericalConstants;
import constants.StringConstants;
import scrambles.FactoryShuffler;
import scrambles.Shuffler;

public class GameModeOne implements GameMechanics {
	private Shuffler shuffler;
  private String hiddenWord;
	private int totalWords;
	private int hits;
	private int mistakes;
	private int attemptsPerWord;

	GameModeOne() {
		FactoryShuffler fs = new FactoryShuffler();
		this.shuffler = fs.chooseShuffler();
		this.totalWords = 0;
		this.hits = 0;
		this.mistakes = 0;
		this.attemptsPerWord = 0;
	}
	
	@Override
	public String getScrambledWord() {
		this.totalWords+= 1;
		this.attemptsPerWord = 0;
		this.hiddenWord = this.shuffler.getWordOnBank();
    String shuffledWord = this.shuffler.shufflerWord(this.hiddenWord);
		return shuffledWord.toUpperCase();
	}

	@Override
	public boolean areEquals(String typedWord){
	  if (this.hiddenWord.toUpperCase().equals(typedWord.toUpperCase())){
	    this.hits+= 1;
	    return true;
    } else {
	  	this.mistakes+= 1;
      return false;
    }
  }

	@Override
	public boolean continueGame() {
	  return this.totalWords < NumericalConstants.TOTAL_WORDS_PER_GAME;
	}

	@Override
	public boolean canTryAgain() {
	  if (this.attemptsPerWord < NumericalConstants.ATTEMPTS_PER_WORD - 1) {
	    this.attemptsPerWord+= 1;
	    return true;
    } else {
	    this.attemptsPerWord= 0;
	    return false;
    }
	}

	@Override
  public String printScore() {
    return String.format(StringConstants.GAME_SCORE, this.hits, this.mistakes);
  }
}
