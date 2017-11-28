package util;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsBank {
	private List<String> words;
	private Random rand;

	public WordsBank() {
		words = new ArrayList<>();
		URL url = getClass().getResource("../complements/words_bank.txt");
		File file = new File(url.getPath());
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = br.readLine()) != null) {
				words.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rand = new Random();
	}

	public String getWord() {
		return words.get(rand.nextInt(words.size()));
	}
}
