package game_mechanics;

public interface GameMechanics {
	
	String getScrambledWord();
	String getHiddenWord();
	String compareWords(String typedWord);
  boolean continueGame();
  String printScore();
}
