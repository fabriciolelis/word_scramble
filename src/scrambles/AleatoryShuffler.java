package scrambles;

import util.WordsBank;

public class AleatoryShuffler implements Shuffler {
	private WordsBank wb;
	
	public AleatoryShuffler() {
		wb = new WordsBank();
		this.shufflerWord(wb.getWord());
	}

	@Override
	public String shufflerWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

}
