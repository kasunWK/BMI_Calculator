package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Double.parseDouble;

public class Controller {

    @FXML
    private Label wl;

    @FXML
    private Label hl;

    @FXML
    private Label bl;

    @FXML
    private Label sl;

    @FXML
    private TextField weight;

    @FXML
    private TextField height;

    @FXML
    private TextField bmiValue;

    @FXML
    private TextField state;

    @FXML
    private Label heading;

    @FXML
    private Button calc;

    @FXML
    private Button clear;

    @FXML
    void calculateBMI(ActionEvent event) {
        if (weight.getText().isEmpty() || height.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter both weight and height");
            a.show();
        }
        else{

            double w = parseDouble(weight.getText());
            double h = parseDouble(height.getText());
            double value = w / (h * h);

            bmiValue.setText(String.format("%.3f", value));

            if (value < 18.5) {
                state.setText("You are in underweight range.");
            } else if (value < 25) {
                state.setText("You are in healthy weight range.");
            } else if (value < 30) {
                state.setText("You are in over weight range.");
            } else {
                state.setText("You are in obese range.");
            }

        }
    }

    @FXML
    void clearAll(ActionEvent event) {
        weight.setText("");
        height.setText("");
        bmiValue.setText("");
        state.setText("");
    }


}

