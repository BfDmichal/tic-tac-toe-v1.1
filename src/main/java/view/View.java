package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import controller.Controller;
import logic.Player;
import logic.Point;

public class View extends Application {
    private Image oPage = new Image("O.png");
    private Image xPage = new Image("X.png");
    ImagePattern imageX = new ImagePattern(xPage);
    ImagePattern imageO = new ImagePattern(oPage);
    AnchorPane panel;
    Controller controller;
    private int centerOfRectangle = 50;
    private final int constant = 7;
    Rectangle[][] squares = new Rectangle[3][3];
    private boolean changePlayer = true;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);


    public static void main(String[] args) {
        launch(args);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller(this);
        panel = new AnchorPane();
        panel.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(panel);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        tableView();
        controller.start();
        primaryStage.show();
        alert.setTitle("Winner");

    }

    private void tableView() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Rectangle rectangle = new Rectangle(x * 100 + constant * x, y * 100 + constant * y, 100, 100);
                rectangle.setFill(Color.WHITE);
                rectangle.setOnMouseClicked(this::mouseClick);
                panel.getChildren().add(rectangle);
                squares[x][y] = rectangle;
            }
        }
    }

    private void mouseClick(MouseEvent mouseEvent) {
        Rectangle gameRectangle = (Rectangle) mouseEvent.getSource();
        Point point = new Point((int) gameRectangle.getX() / 100, (int) gameRectangle.getY() / 100);
        move(point);
    }

    private void move(Point point) {
        fieldMapToRectangle(controller.click(point));
    }

    private void fieldMapToRectangle(Player[][] board) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[x][y].equals(Player.x)) {
                    squares[x][y].setFill(imageX);
                    squares[x][y].setDisable(true);
                } else if (board[x][y].equals(Player.o)) {
                    squares[x][y].setFill(imageO);
                    squares[x][y].setDisable(true);
                }
            }
        }
    }

    public void stopTable() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                squares[x][y].setFill(Color.WHITE);
                squares[x][y].setDisable(false);
            }
        }
    }
    public void message(String winner,String whoStart){
        alert.setHeaderText(winner);
        alert.setContentText(whoStart);
        alert.showAndWait();
    }
}
