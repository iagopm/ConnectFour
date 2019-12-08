package application;

public class BaseApplication {
    private Main main;
    private GameApplication gameApplication = new GameApplication();

    public BaseApplication(Main main) {
        gameApplication.init();
        this.main = main;
    }

    public GameApplication getGameApplication() {
        return gameApplication;
    }

    public void setGameApplication(GameApplication gameApplication) {
        this.gameApplication = gameApplication;
    }
}
