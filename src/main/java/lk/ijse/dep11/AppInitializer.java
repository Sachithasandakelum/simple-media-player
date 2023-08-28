package lk.ijse.dep11;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
        Scene mainScene = new Scene(root);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("media player");

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setBackground(Background.EMPTY);
        mainScene.setFill(Color.TRANSPARENT);

        primaryStage.centerOnScreen();
        primaryStage.show();

        Stage mediaPlayerStage = new Stage();

        AnchorPane mediaPlayerRoot = FXMLLoader.load(getClass().getResource("/view/MediaPlayerScene.fxml"));

        Scene mediaPlayerScene = new Scene(mediaPlayerRoot);
        mediaPlayerStage.setScene(mediaPlayerScene);
        mediaPlayerStage.setTitle("Simple Media Player");
        mediaPlayerStage.centerOnScreen();

        PauseTransition pause = new PauseTransition(Duration.millis(2000));
        pause.setOnFinished(e->{
            mediaPlayerStage.show();
            primaryStage.close();
        });

        pause.play();

    }
}
