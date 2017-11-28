package game_mechanics;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String compareWords(String typedWord) {
		return null;
	}

	@Override
	public boolean continueGame() {
		return false;
	}

	@Override
	public String printScore() {
		return null;
	}
}
