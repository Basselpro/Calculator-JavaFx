
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {
    public TextField textDisplay;


    private int decimalClick = 0;

    private int resultClick = 0;

    private String generalOperationObject;

    private double firstDouble;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void digitHandler(ActionEvent event){

        if (resultClick ==1){
            textDisplay.clear();
            resultClick = 0;
        }

        String digitObject = ((Button)event.getSource()).getText();
        String oldtext = textDisplay.getText();
        String newText = oldtext + digitObject;
        textDisplay.setText(newText);

  }




    public void dicimalHandler(ActionEvent event) {
        if (decimalClick == 0){
            String decimalobject = ((Button)event.getSource()).getText();
            String oldtext = textDisplay.getText();
            String newText = oldtext + decimalobject;
            textDisplay.setText(newText);
            decimalClick = 1;

        }

    }

    public void generalOperations(ActionEvent event) {
         generalOperationObject = ((Button)event.getSource()).getText();
        switch (generalOperationObject){
            case "AC":
                textDisplay.setText("");
                decimalClick = 0;
                break;

            case "+/-":
                double plusMinus = Double.parseDouble(String.valueOf(textDisplay.getText()));
                plusMinus = plusMinus*(-1);
                textDisplay.setText(String.valueOf(plusMinus));
                break;

            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                String currentText = textDisplay.getText();
                firstDouble = Double.parseDouble(currentText);
                textDisplay.setText("");
                decimalClick = 0;
                break;
            default:



        }
    }

    public void resultHandler(ActionEvent event) {
        double secoundDouble ;
        double result = 0;
        String secoundText = textDisplay.getText();
        secoundDouble = Double.parseDouble(secoundText);

        switch (generalOperationObject){

            case "+":
                result = firstDouble + secoundDouble;
                break;

            case "*":
                result = firstDouble * secoundDouble;
                break;

            case "-":
                result = firstDouble - secoundDouble;
                break;

            case "/":
                result = firstDouble / secoundDouble;
                break;

            case "%":
                result = firstDouble % secoundDouble;
                break;

            default:

        }

        String format = String.format("%.2f",result);

        if(result == (int) result){
            textDisplay.setText(String.valueOf((int) result));
        }
        else {

            textDisplay.setText(format);
        }

        resultClick = 1;





    }
}