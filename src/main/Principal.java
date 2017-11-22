package main;

import java.util.Scanner;

import game_mechanics.FactoryGameMechanics;
import game_mechanics.GameMechanics;

public class Principal {
	private static int gameMode;
	private static Scanner in = new Scanner(System.in);
	private static GameMechanics gm;
	
	
	private static String getDigitedWords() {
		System.out.println("Digite a palavra:");
		String input = in.nextLine();
		return input;
	}
	
	private static void chooseGameMode() {
		System.out.println("Game Mode One - Type 1 ");
		System.out.println("Game Mode Two - Type 2 ");
		System.out.print("Choose the game mode: ");
		gameMode = in.nextInt();
		FactoryGameMechanics fgm = new FactoryGameMechanics();
		gm = fgm.fetchGameMode(gameMode);
	}
	
	public static void main(String[] args) {
		chooseGameMode();
		in.close();
	}
}
