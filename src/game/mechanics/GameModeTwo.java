package game.mechanics;

import constants.NumericalConstants;
import constants.StringConstants;
import scrambles.FactoryShuffler;

public class GameModeTwo extends GameMode implements GameMechanics {

  GameModeTwo() {
    FactoryShuffler fs = new FactoryShuffler();
    this.shuffler = fs.chooseShuffler();
    this.totalWords = 0;
    this.hits = 0;
    this.mistakes = 0;
    this.attemptsPerWord = 0;
  }

  @Override
  public String getScrambledWord() {
    return super.getScrambledWord();
  }

  @Override
  public boolean areEquals(String typedWord) {
    return super.areEquals(typedWord);
  }

  @Override
  public boolean continueGame() {
    return this.mistakes < NumericalConstants.TOTAL_ERRORS;
  }

  @Override
  public boolean canTryAgain() {
    if (this.attemptsPerWord < NumericalConstants.ATTEMPTS_PER_WORD_GAME_TWO - 1) {
      this.attemptsPerWord += 1;
      return true;
    } else {
      this.attemptsPerWord = 0;
      return false;
    }
  }

  @Override
  public String printScore() {
    return String.format(StringConstants.GAME_SCORE, this.hits, this.mistakes);
  }
}
