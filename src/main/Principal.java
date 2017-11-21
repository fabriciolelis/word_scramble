package main;

import java.util.Scanner;

public class Principal {
	
	private static Scanner in = new Scanner(System.in);
	
	private static String getDigitedWords() {
		System.out.println("Digite a palavra:");
		String input = in.nextLine();
		return input;
		
	}
	
	public static void main(String[] args) {
		System.out.println("A palavra  digitada: " + getDigitedWords());
		in.close();
	}
}
