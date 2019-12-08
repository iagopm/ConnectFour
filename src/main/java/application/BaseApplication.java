package application;

public class BaseApplication {
    private GameApplication gameApplication = new GameApplication();

    public BaseApplication() {
        gameApplication.init();
    }

    public GameApplication getGameApplication() {
        return gameApplication;
    }

    public void setGameApplication(GameApplication gameApplication) {
        this.gameApplication = gameApplication;
    }
}
