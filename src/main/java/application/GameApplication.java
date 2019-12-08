package application;

import boardLogic.BoardFacade;
import boardLogic.BoardFacadeImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import loadGameLogic.LoadGameFacade;
import loadGameLogic.LoadGameFacadeImpl;
import persistenceLogic.PersistenceFacade;
import persistenceLogic.PersistenceFacadeImpl;

public class GameApplication implements Application {
    private Stage stage;
    private BoardFacade boardFacade;
    private PersistenceFacade persistenceFacade;
    private LoadGameFacade loadGameFacade;
    private Controller controller;

    @Override
    public void init() {
        boardFacade = new BoardFacadeImpl(this);
        persistenceFacade = new PersistenceFacadeImpl(this);
        loadGameFacade = new LoadGameFacadeImpl(this);
        controller = new Controller(this);
    }


    @Override
    public void restart() throws Exception {
        init();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("gameLayout.fxml"));
        fxmlLoader.setController(controller);

        Parent root = fxmlLoader.load();
        stage.setTitle("");
        stage.setScene(new Scene(root, 800, 600));
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

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }
}
