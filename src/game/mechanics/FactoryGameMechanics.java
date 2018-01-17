package game.mechanics;

public class FactoryGameMechanics {

  /**
   * Choose a game mode randomly.
   * @param gameMode game mode number.
   * @return Game Mode
   */
  public GameMechanics fetchGameMode(int gameMode) {
    switch (gameMode) {
      case 1:
        return new GameModeOne();
      case 2:
        return new GameModeTwo();
      default:
        break;
    }
    return null;
  }
}
