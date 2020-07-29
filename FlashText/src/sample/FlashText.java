package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashText extends Application {
    private String text = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override // Redefinise metod start() klase Apllication
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        Label iblText = new Label("Programing is Fun");
        pane.getChildren().add(iblText);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (iblText.getText().trim().length() == 0)
                            text = "Welcome";
                        else
                            text = "";
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                iblText.setText(text);
                            }
                        });
                        Thread.sleep(200);
                    }
                } catch (InterruptedException ex) {

                }
            }
        }).start();

        // Kreiranje scene i njeno postavljanje na binu
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("Flash Text");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
