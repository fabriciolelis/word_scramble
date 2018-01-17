package main;

import constants.StringConstants;
import game.mechanics.FactoryGameMechanics;
import game.mechanics.GameMechanics;
import java.util.Scanner;


public class Principal {

  private static Scanner in = new Scanner(System.in);
  private static GameMechanics gm;

  private static void println(String message) {
    System.out.println(message);
  }

  private static void print(String message) {
    System.out.print(message);
  }

  private static String getTypedWords() {
    println(StringConstants.TYPE_THE_WORD);
    return in.nextLine();
  }

  private static void chooseGameMode() {
    println(StringConstants.GAME_MODE_ONE);
    println(StringConstants.GAME_MODE_TWO);
    print(StringConstants.CHOOSE_GAME_MODE);
    int gameMode = Integer.parseInt(in.nextLine());
    FactoryGameMechanics fgm = new FactoryGameMechanics();
    gm = fgm.fetchGameMode(gameMode);
  }

  public static void main(String[] args) {
    chooseGameMode();
    while (gm.continueGame()) {
      String scrambledWord = gm.getScrambledWord();
      println(scrambledWord);
      String typedWord = getTypedWords();
      boolean areEquals;
      while (!(areEquals = gm.areEquals(typedWord)) & gm.canTryAgain()) {
        println(StringConstants.MISSED_WORD);
        println(scrambledWord);
        typedWord = getTypedWords();
      }
      if (areEquals) {
        println(StringConstants.HIT_WORD);
      } else {
        println(StringConstants.MISSED_WORD);
      }
    }
    println(gm.printScore());
    in.close();
  }
}
