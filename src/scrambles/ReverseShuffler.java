package scrambles;

import util.WordsBank;

public class ReverseShuffler implements Shuffler {
	private WordsBank wb;
	private String hiddenWord;
	private String reverseWord;
	
	public ReverseShuffler() {
		wb = new WordsBank();
		this.hiddenWord = wb.getWord();
		this.reverseWord =  this.shufflerWord(hiddenWord);
	}

	@Override
	public String shufflerWord(String word) {
		String reverse = "";
		for (int i = word.length()-1; i >=0; i--) {
			reverse += word.substring(i, i+1);
		}
		return reverse;
	}

	@Override
	public String getScrambledWord() {
		return reverseWord;
	}

	@Override
	public String getHiddenWord() {
		return hiddenWord;
	}
	
	

}
