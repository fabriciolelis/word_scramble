package scrambles;

import util.WordsBank;

public class ReverseShuffler implements Shuffler {
	private WordsBank wb;
	private String hiddenWord;

	public ReverseShuffler() {
		wb = new WordsBank();
	}

	@Override
	public String shufflerWord(String word) {
		StringBuilder reverse = new StringBuilder();
		for (int i = word.length()-1; i >=0; i--) {
			reverse.append(word.substring(i, i + 1));
		}
		return reverse.toString();
	}

	@Override
	public String getHiddenWord() {
		return hiddenWord;
	}

	@Override
	public String getWordOnBank() {
		this.hiddenWord = wb.getWord();
		return this.hiddenWord;
	}
}
