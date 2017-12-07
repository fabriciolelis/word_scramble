package game_mechanics;

public interface GameMechanics {

  String getScrambledWord();
  String printScore();
  boolean continueGame();

  boolean canTryAgain();
  boolean areEquals(String typedWord);
}
