package scrambles;

import java.util.Random;
import util.WordsBank;

public class AleatoryShuffler implements Shuffler {
  private WordsBank wb;
  private String hiddenWord;

  AleatoryShuffler(){
    wb = new WordsBank();
  }

  @Override
  public String shufflerWord(String word) {
    StringBuilder scrambledWord = new StringBuilder();
    Random rand = new Random();
    for(int i = 0; i < word.length()-1; i++) {
      scrambledWord.append(word.charAt(rand.nextInt(word.length())));
    }
    return scrambledWord.toString();
  }

  @Override
  public String getHiddenWord() {
    return this.hiddenWord;
  }

  @Override
  public String getWordOnBank() {
    this.hiddenWord = wb.getWord();
    return this.hiddenWord;
  }
}
