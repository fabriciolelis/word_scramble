package game_mechanics;

import constants.StringConstants;
import scrambles.FactoryShuffler;
import scrambles.Shuffler;

public class GameModeTwo implements GameMechanics {
	private Shuffler shuffler;
	private String hiddenWord;
  private int hits;
  private int mistakes;
  private int attempts;

	GameModeTwo(){
    FactoryShuffler fs = new FactoryShuffler();
    this.shuffler = fs.chooseShuffler();
    this.hits = 0;
    this.mistakes = 0;
    this.attempts = 0;
  }

	@Override
	public String getScrambledWord() {
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
		  this.attempts+=1;
		  this.mistakes+=1;
      response = StringConstants.MISSED_WORD;
    }
	  return response;
	}

	@Override
	public boolean continueGame() {
	  return this.attempts <= 5;
	}

	@Override
	public String printScore() {
		return String.format(StringConstants.GAME_SCORE, this.hits, this.mistakes);
	}
}
