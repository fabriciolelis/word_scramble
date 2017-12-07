package game_mechanics;

import constants.NumericalConstants;
import constants.StringConstants;
import scrambles.FactoryShuffler;
import scrambles.Shuffler;

public class GameModeTwo implements GameMechanics {
	private Shuffler shuffler;
	private String hiddenWord;
  private int hits;
  private int mistakes;
  private int attemptsTotal;
  private int totalWords;
  private int attemptsPerWord;

	GameModeTwo(){
    FactoryShuffler fs = new FactoryShuffler();
    this.shuffler = fs.chooseShuffler();
    this.hits = 0;
    this.mistakes = 0;
    this.attemptsTotal = 0;
    this.totalWords = 0;
    this.attemptsPerWord = 0;
  }

	@Override
	public String getScrambledWord() {
	  this.totalWords+= 1;
	  this.attemptsPerWord = 0;
		this.hiddenWord = shuffler.getWordOnBank();
		return shuffler.shufflerWord(this.hiddenWord).toUpperCase();
	}

	@Override
	public boolean continueGame() {
	  return (this.attemptsTotal < NumericalConstants.ATTEMPTS_TOTAL_GAME_MODE_TWO && this.totalWords < NumericalConstants.TOTAL_WORDS_PER_GAME_MODE_TWO);
	}

	@Override
	public boolean canTryAgain() {
	  return this.attemptsPerWord < NumericalConstants.ATTEMPTS_PER_WORD;
	}

	@Override
	public boolean areEquals(String typedWord) {
		if (this.hiddenWord.toUpperCase().equals(typedWord.toUpperCase())) {
		  this.hits+= 1;
		  return true;
    } else {
      this.attemptsTotal+= 1;
		  this.mistakes+= 1;
      return false;
    }
	}

	@Override
	public String printScore() {
		return String.format(StringConstants.GAME_SCORE, this.hits, this.mistakes);
	}
}
