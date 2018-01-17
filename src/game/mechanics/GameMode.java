package game.mechanics;

import scrambles.Shuffler;

public class GameMode {

  Shuffler shuffler;
  private String hiddenWord;
  int totalWords;
  int hits;
  int mistakes;
  int attemptsPerWord;

  public String getScrambledWord() {
    this.totalWords += 1;
    this.attemptsPerWord = 0;
    this.hiddenWord = this.shuffler.getWordOnBank();
    String shuffledWord = this.shuffler.shufflerWord(this.hiddenWord);
    return shuffledWord.toUpperCase();
  }

  public boolean areEquals(String typedWord) {
    if (this.hiddenWord.toUpperCase().equals(typedWord.toUpperCase())) {
      this.hits += 1;
      return true;
    } else {
      this.mistakes += 1;
      return false;
    }
  }
}
