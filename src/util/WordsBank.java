package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordsBank {
	private List<String> words;

	public WordsBank() {
		words = new ArrayList<String>();
		try {
			File wordsBank = new File("C:\\Users\\fabri\\repositories\\word_scramble\\complements\\words_bank.txt");
			Scanner sc = new Scanner(wordsBank);
			while (sc.hasNextLine()) {
				String word = sc.nextLine();
				words.add(word);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getWord() {
		Random rand = new Random();
		return words.get(rand.nextInt(words.size()));
	}
}
