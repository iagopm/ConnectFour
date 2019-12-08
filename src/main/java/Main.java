import application.BaseApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    BaseApplication baseApplication = new BaseApplication();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller(baseApplication.getGameApplication());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameLayout.fxml"));
        fxmlLoader.setController(controller);

        Parent root = fxmlLoader.load();
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }
}
