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
		this.hiddenWord = this.shuffler.getWordOnBank();
    String shuffledWord = this.shuffler.shufflerWord(this.hiddenWord);
		return shuffledWord.toUpperCase();
	}

	@Override
	public String compareWords(String typedWord) {
	  String response;
	  if (this.hiddenWord.toUpperCase().equals(typedWord.toUpperCase())) {
	    this.hits += 1;
	    response = StringConstants.HIT_WORD;
    } else {
      response = StringConstants.MISSED_WORD;
	    this.mistakes += 1;
    }
		return response;
	}

	@Override
	public boolean areEquals(String typedWord){
	  if (this.hiddenWord.toUpperCase().equals(typedWord.toUpperCase())){
	    this.hits+= 1;
	    this.attemptsPerWord = 0;
	    return true;
    } else {
      this.mistakes+= 1;
      this.attemptsPerWord+= 1;
      return false;
    }
  }

	@Override
	public boolean continueGame() {
		return this.totalWords < NumericalConstants.TOTAL_WORDS_PER_GAME;
	}

	@Override
	public boolean canTryAgain() {
		return this.attemptsPerWord < NumericalConstants.ATTEMPTS_PER_WORD;
	}

	@Override
  public String printScore() {
    return String.format(StringConstants.GAME_SCORE, this.hits, this.mistakes);
  }
}
