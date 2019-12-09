package application;

import animationLogic.AnimationFacade;
import animationLogic.AnimationFacadeImpl;
import boardLogic.BoardFacade;
import boardLogic.BoardFacadeImpl;
import gameController.Controller;
import gameController.ControllerManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import loadGameLogic.LoadGameFacade;
import loadGameLogic.LoadGameFacadeImpl;
import persistenceLogic.PersistenceFacade;
import persistenceLogic.PersistenceFacadeImpl;
import sun.security.util.Resources;

import java.util.ResourceBundle;

public class GameApplication implements Application {
    private static ResourceBundle bundle = Resources.getBundle("game");
    private Stage stage;
    private BoardFacade boardFacade;
    private PersistenceFacade persistenceFacade;
    private LoadGameFacade loadGameFacade;
    private ControllerManager controllerManager;
    private AnimationFacade animationFacade;

    @Override
    public void init() {
        boardFacade = new BoardFacadeImpl(this);
        persistenceFacade = new PersistenceFacadeImpl(this);
        loadGameFacade = new LoadGameFacadeImpl(this);
        controllerManager = new Controller(this);
        animationFacade = new AnimationFacadeImpl(this);
    }


    @Override
    public void restart() throws Exception {
        init();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("gameLayout.fxml"));
        fxmlLoader.setController(controllerManager);

        Parent root = fxmlLoader.load();
        stage.setTitle("");
        stage.setScene(new Scene(
                root,
                Integer.parseInt(bundle.getString("screenWidth")),
                Integer.parseInt(bundle.getString("screenHeight"))));
        stage.show();
    }

    @Override
    public void close() {

    }

    public BoardFacade getBoardFacade() {
        return boardFacade;
    }

    public void setBoardFacade(BoardFacade boardFacade) {
        this.boardFacade = boardFacade;
    }

    public PersistenceFacade getPersistenceFacade() {
        return persistenceFacade;
    }

    public void setPersistenceFacade(PersistenceFacade persistenceFacade) {
        this.persistenceFacade = persistenceFacade;
    }

    public LoadGameFacade getLoadGameFacade() {
        return loadGameFacade;
    }

    public void setLoadGameFacade(LoadGameFacade loadGameFacade) {
        this.loadGameFacade = loadGameFacade;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    public void setControllerManager(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    public AnimationFacade getAnimationFacade() {
        return animationFacade;
    }

    public void setAnimationFacade(AnimationFacade animationFacade) {
        this.animationFacade = animationFacade;
    }

    @Override
    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }
}
