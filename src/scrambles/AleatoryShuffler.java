package scrambles;

import java.util.ArrayList;
import java.util.Collections;
import util.WordsBank;

public class AleatoryShuffler implements Shuffler {
  private WordsBank wb;
  private String hiddenWord;

  AleatoryShuffler(){
    wb = new WordsBank();
  }

  @Override
  public String shufflerWord(String word) {
    ArrayList<Character> chars = new ArrayList<>(word.length());
    for ( char c : word.toCharArray() ) {
      chars.add(c);
    }
    Collections.shuffle(chars);
    char[] shuffled = new char[chars.size()];
    for ( int i = 0; i < shuffled.length; i++ ) {
      shuffled[i] = chars.get(i);
    }
    return new String(shuffled);
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
