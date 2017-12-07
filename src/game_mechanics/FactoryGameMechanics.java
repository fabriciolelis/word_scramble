package game_mechanics;

public class FactoryGameMechanics {

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
