package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sun.security.util.Resources;

import java.util.ResourceBundle;

public class Main extends Application {
    public static final ResourceBundle bundle = Resources.getBundle("game");
    BaseApplication baseApplication = new BaseApplication(this);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        baseApplication.getGameApplication().setStage(primaryStage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("gameLayout.fxml"));
        fxmlLoader.setController(baseApplication.getGameApplication().getControllerManager());

        Parent root = fxmlLoader.load();
        primaryStage.getIcons().add(new Image(bundle.getString("icon")));
        primaryStage.setScene(new Scene(root, Integer.parseInt(bundle.getString("screenWidth")), Integer.parseInt(bundle.getString("screenHeight"))));
        primaryStage.show();
    }

}
