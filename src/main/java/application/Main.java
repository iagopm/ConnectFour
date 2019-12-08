package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    BaseApplication baseApplication = new BaseApplication(this);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        baseApplication.getGameApplication().setStage(primaryStage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("gameLayout.fxml"));
        fxmlLoader.setController(baseApplication.getGameApplication().getController());

        Parent root = fxmlLoader.load();
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }

}
