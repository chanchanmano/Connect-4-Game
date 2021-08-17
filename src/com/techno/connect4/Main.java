package com.techno.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader= new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=loader.load();

        controller= loader.getController();
        controller.createPlayground();

        Pane menuPane= (Pane) rootGridPane.getChildren().get(0);

        MenuBar menuBar=createmenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        menuPane.getChildren().add(menuBar);

        Scene scene=new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four-Techno");
        primaryStage.setResizable(true);
        primaryStage.show();


    }
    private MenuBar createmenu(){
        Menu filem=new Menu("File");

        MenuItem newG= new MenuItem("New Game");
        newG.setOnAction(event ->{
            controller.resetGame();
            controller.playeronetextfield.clear();
            controller.playertwotextfield.clear();
            controller.playerNameLabel.setText("Player One's");

        });



        MenuItem resG=new MenuItem("Reset Game");
        resG.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem sepa =new SeparatorMenuItem();
        MenuItem exG=new MenuItem("Exit Game");
        exG.setOnAction(event -> exitgame());

        filem.getItems().addAll(newG,resG,sepa,exG);

        //Help Menu
        Menu helpm=new Menu("Help");
        MenuItem aboutG=new MenuItem("About Connect4");
        aboutG.setOnAction(event -> aboutgame());
        MenuItem aboutM=new MenuItem("About Me");
        aboutM.setOnAction(event -> aboutme());
        SeparatorMenuItem sepami= new SeparatorMenuItem();

        helpm.getItems().addAll(aboutG,sepami,aboutM);

        //adding to menuBar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(filem,helpm);

        return menuBar;




    }

    private void aboutme() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Aryan Hamine");
        alert.setContentText("My motive behind building this "+
                "awesome and simple game, was to exercise my coding skills "+
                "and also look to it that i create something which can be"+
                " enjoyed amongst family and friends alike!");
        alert.show();
    }

    private void aboutgame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitgame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetgame() {

    }


    public static void main(String[] args) {
        launch(args);
    }
}
