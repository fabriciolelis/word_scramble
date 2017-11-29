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
	private boolean canTryAgain;

	GameModeOne() {
		FactoryShuffler fs = new FactoryShuffler();
		shuffler = fs.chooseShuffler();
		totalWords = 0;
		hits = 0;
		mistakes = 0;
    canTryAgain = true;
	}
	
	@Override
	public String getScrambledWord() {
		totalWords+= 1;
		this.hiddenWord = shuffler.getWordOnBank();
    String shuffledWord = shuffler.shufflerWord(this.hiddenWord);
		return shuffledWord.toUpperCase();
	}

	@Override
	public String compareWords(String typedWord) {
	  String response;
	  if (this.hiddenWord.toUpperCase().equals(typedWord.toUpperCase())) {
	    hits += 1;
	    response = StringConstants.HIT_WORD;
    } else {
      response = StringConstants.MISSED_WORD;
	    mistakes += 1;
    }
		return response;
	}

	@Override
	public boolean areEquals(String typedWord){
	  if (this.hiddenWord.toUpperCase().equals(typedWord.toUpperCase())){
	    this.hits+= 1;
	    this.canTryAgain = false;
	    this.attemptsPerWord = 0;
	    return true;
    } else {
      this.mistakes+= 1;
      this.attemptsPerWord+= 1;
      this.canTryAgain = this.attemptsPerWord < 3;
      return false;
    }
  }

	@Override
	public boolean continueGame() {
		return totalWords < NumericalConstants.TOTAL_WORDS_PER_GAME;
	}

	@Override
	public boolean canTryAgain() {
		return this.canTryAgain && this.attemptsPerWord < NumericalConstants.ATTEMPTS_PER_WORD;
	}

	@Override
  public String printScore() {
    return String.format(StringConstants.GAME_SCORE, this.hits, this.mistakes);
  }
}
