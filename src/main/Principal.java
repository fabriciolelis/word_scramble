package main;

import constants.StringConstants;
import java.util.Scanner;

import game_mechanics.FactoryGameMechanics;
import game_mechanics.GameMechanics;

public class Principal {
	private static Scanner in = new Scanner(System.in);
	private static GameMechanics gm;

	private static String getTypedWords() {
		System.out.println(StringConstants.TYPE_THE_WORD);
		return in.nextLine();
	}
	
	private static void chooseGameMode() {
		System.out.println(StringConstants.GAME_MODE_ONE);
		System.out.println(StringConstants.GAME_MODE_TWO);
		System.out.print(StringConstants.CHOOSE_GAME_MODE);
		int gameMode = Integer.parseInt(in.nextLine());
		FactoryGameMechanics fgm = new FactoryGameMechanics();
		gm = fgm.fetchGameMode(gameMode);
	}
	
	public static void main(String[] args) {
		chooseGameMode();
		while (gm.continueGame()) {
			String scrambledWord = gm.getScrambledWord();
			System.out.println(scrambledWord);
			String typedWord = getTypedWords();
			while (!gm.areEquals(typedWord) && gm.canTryAgain()){
        System.out.println(StringConstants.MISSED_WORD);
        System.out.println(scrambledWord);
        typedWord = getTypedWords();
      }
      System.out.println(StringConstants.HIT_WORD);
		}
    System.out.println(gm.printScore());
		in.close();
	}
}
