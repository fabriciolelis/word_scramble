package game_mechanics;

import constants.StringConstants;
import scrambles.FactoryShuffler;
import scrambles.Shuffler;

public class GameModeOne implements GameMechanics {
	private Shuffler shuffler;
  private String hiddenWord;
	private int totalWords;
	private int hits;
	private int mistakes;

	GameModeOne() {
		FactoryShuffler fs = new FactoryShuffler();
		shuffler = fs.chooseShuffler();
		totalWords = 1;
		hits = 0;
		mistakes = 0;
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
	public boolean continueGame() {
		return totalWords <= 9;
	}

  @Override
  public String printScore() {
    return String.format(StringConstants.GAME_SCORE, this.hits, this.mistakes);
  }

  @Override
	public String getHiddenWord() {
		hiddenWord = shuffler.getHiddenWord();
		return hiddenWord;
	}
}
