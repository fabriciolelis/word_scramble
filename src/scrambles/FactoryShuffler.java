package scrambles;

import constants.NumericalConstants;
import java.util.Random;

public class FactoryShuffler {

  private int randomShuffles() {
    Random rand = new Random();
    return rand.nextInt(NumericalConstants.SHUFFLERS_NUMBER);
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
