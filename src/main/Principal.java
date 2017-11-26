package main;

import java.util.Scanner;

import game_mechanics.FactoryGameMechanics;
import game_mechanics.GameMechanics;

public class Principal {
	private static Scanner in = new Scanner(System.in);
	private static GameMechanics gm;

	private static String getTypedWords() {
		System.out.println("Type the word:");
		return in.nextLine();
	}
	
	private static String chooseGameMode() {
		System.out.println("Game Mode One - Type 1 ");
		System.out.println("Game Mode Two - Type 2 ");
		System.out.print("Choose the game mode: ");
		int gameMode = Integer.parseInt(in.nextLine());
		FactoryGameMechanics fgm = new FactoryGameMechanics();
		gm = fgm.fetchGameMode(gameMode);
        return gm.getScrambledWord();
	}
	
	public static void main(String[] args) {
		String scrambledWord = chooseGameMode();
		while (gm.continueGame()) {
			System.out.println(scrambledWord);
			String typedWord = getTypedWords();
			System.out.println(gm.compareWords(typedWord));
		}
		in.close();
	}
}
