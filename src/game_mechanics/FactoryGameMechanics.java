package game_mechanics;

public class FactoryGameMechanics {

	public GameMechanics fetchGameMode(int gameMode) {
		switch (gameMode) {
		case 1:
			System.out.println("game mode one");
			return new GameModeOne();
		case 2:
			System.out.println("game mode two");
			return new GameModeTwo();
		default:
			break;
		}
		return null;
	}
}
