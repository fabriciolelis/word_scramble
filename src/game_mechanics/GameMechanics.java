package game_mechanics;

public interface GameMechanics {
	
	String getScrambledWord();
	String compareWords(String typedWord);
  boolean continueGame();
  String printScore();
}
