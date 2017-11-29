package game_mechanics;

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

	GameModeTwo(){
    FactoryShuffler fs = new FactoryShuffler();
    this.shuffler = fs.chooseShuffler();
    this.hits = 0;
    this.mistakes = 0;
    this.attemptsTotal = 0;
    this.totalWords = 0;
  }

	@Override
	public String getScrambledWord() {
	  this.totalWords+= 1;
		this.hiddenWord = shuffler.getWordOnBank();
		return shuffler.shufflerWord(this.hiddenWord).toUpperCase();
	}

	@Override
	public String compareWords(String typedWord) {
    String response;
		if(this.hiddenWord.toUpperCase().equals(typedWord.toUpperCase())) {
		  this.hits+=1;
      response = StringConstants.HIT_WORD;
    }
    else {
		  this.attemptsTotal +=1;
		  this.mistakes+=1;
      response = StringConstants.MISSED_WORD;
    }
	  return response;
	}

	@Override
	public boolean continueGame() {
	  return (this.attemptsTotal < 5 && this.totalWords < 10);
	}

	@Override
	public boolean canTryAgain() {
		return false;
	}

	@Override
	public boolean areEquals(String typedWord) {
		return false;
	}

	@Override
	public String printScore() {
		return String.format(StringConstants.GAME_SCORE, this.hits, this.mistakes);
	}
}
