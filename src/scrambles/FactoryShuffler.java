package scrambles;

import constants.NumericalConstants;
import java.util.Random;

public class FactoryShuffler {

  private static final int shuffles = NumericalConstants.SHUFFLERS_NUMBER;

  private int randomShuffles() {
    Random rand = new Random();
    return rand.nextInt(shuffles);
  }

  public Shuffler chooseShuffler() {
    int shuffleNumber = randomShuffles();
    switch (shuffleNumber) {
      case 1:
        return new ReverseShuffler();
      case 2:
        return new AleatoryShuffler();
      default:
        return new ReverseShuffler();
    }
  }
}
