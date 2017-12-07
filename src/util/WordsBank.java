package util;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WordsBank {

  private List<String> words;
  private int index;

  public WordsBank() {
    index = 0;
    words = new ArrayList<>();
    URL url = getClass().getResource("../complements/words_bank.txt");
    File file = new File(url.getPath());
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        words.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Collections.shuffle(words);
  }

  public String getWord() {
    String word = words.get(index);
    if (index < words.size()) {
      index += 1;
    } else {
      index = 0;
    }
    return word;
  }
}
