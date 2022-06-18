import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

public class q3 extends Application {
    Text text = new Text(50, 50, "CodingKick");

    public void start(Stage p) {
        HBox but = new HBox(20);
        Button bleft = new Button("<=");
        Button bright = new Button("=>");
        but.getChildren().addAll(bleft, bright);
        but.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane();
        pane.setBottom(but);

        HBox rad = new HBox(20);
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");
        rad.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);

        ToggleGroup g = new ToggleGroup();
        rbRed.setToggleGroup(g);
        rbYellow.setToggleGroup(g);
        rbBlack.setToggleGroup(g);
        rbOrange.setToggleGroup(g);
        rbGreen.setToggleGroup(g);

        Pane pt = new Pane();
        pt.setStyle("-fx-border-color: black");
        pt.getChildren().add(text);
        pane.setCenter(pt);
        pane.setTop(rad);

        bleft.setOnAction(e -> text.setX(text.getX() - 10));
        bright.setOnAction(e -> text.setX(text.getX() + 10));

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });

        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                text.setFill(Color.YELLOW);
            }
        });

        rbBlack.setOnAction(e -> {
            if (rbBlack.isSelected()) {
                text.setFill(Color.BLACK);
            }
        });

        rbOrange.setOnAction(e -> {
            if (rbOrange.isSelected()) {
                text.setFill(Color.ORANGE);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });

        Scene scene = new Scene(pane, 450, 150);
        p.setTitle("Java");
        p.setScene(scene);
        p.show();
    }
}
