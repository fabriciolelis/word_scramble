package game_mechanics;

public interface GameMechanics {
	
	String getScrambledWord();
	String getHiddenWord();
	boolean compareWords(String typedWord);
    boolean continueGame();
}
