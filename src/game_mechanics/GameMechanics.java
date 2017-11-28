package game_mechanics;

public interface GameMechanics {
	
	String getScrambledWord();
	String compareWords(String typedWord);
  String printScore();
  boolean continueGame();
}
