package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class EmployeeController {
    //public GridPane grid;
    public Label postalCodeLabel;
    public TextField postalCodeText;
    public TextField firstNameText;
    public TextArea employeeListTextArea;
    public TextField lastNameText;
    public Button buttonSearch;
    public Button buttonClearAll;

    @FXML
    private GridPane grid;

    private void clearTextFields(GridPane grid) {
        // Simple method to clear the text fields in a grid
        for (Node node : grid.getChildren()) {
            if (node instanceof TextField ) {
                // clear
                ((TextField)node).setText("");
                node.setStyle(null);
            } else if (node instanceof TextArea) {
                ((TextArea) node).setText("");
                node.setStyle(null);
            }
        }
    }

    private void resetTextFields(GridPane grid) {
        // Simple method to reset the style on text fields in a grid which have a style set
        // and don't touch the other fields
        // We use it to clear the fields we turned yellow
        for (Node node : grid.getChildren()) {
            if (node instanceof TextField) {
                System.out.println(node.getStyle());
                // clear
                if (node.getStyle() != null && !node.getStyle().equals("")) {
                    ((TextField) node).setText("");
                    node.setStyle(null);
                }
            }
        }
    }
    public static String capitalize(String str) {
        // Method to make names appear with capital first letter
        // also turn uppercase letters not in first position into lowercase
        // sorry McDonald!
        if(str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }


    public void onAddEmployee(ActionEvent actionEvent) {

        String firstNameInput= capitalize(firstNameText.getText());
        String lastNameInput= capitalize(lastNameText.getText());
        String empNumberInput = capitalize(postalCodeLabel.getText());
        boolean validInput= true;

        // validate the user input


        if (firstNameInput.isEmpty() || ! DataValidator.isValidName(firstNameInput)){
            // We need a valid first name
            firstNameText.setStyle("-fx-background-color: yellow");
            validInput = false;
        }

        if (lastNameInput.isEmpty() || ! DataValidator.isValidName(lastNameInput)){
            // We need a valid last name
            lastNameText.setStyle("-fx-background-color: yellow");
            validInput = false;
        }

        if (empNumberInput.isEmpty()){
            // We need a valid last employee number
            postalCodeText.setStyle("-fx-background-color: yellow");
            validInput = false;
        }

        // Now register the employee
        // not finished!

        if (validInput) {
            Employee e = new Employee(firstNameInput,lastNameInput,empNumberInput);
            employeeListTextArea.setText(e.getFirstName()+" "+e.getLastName()+" "+e.getEmployeeId());
        } else {
            // Something is wrong in one or more input fields
            // Tell the user to correct input

            Alert alert = new Alert(Alert.AlertType.ERROR);
            //alert.setTitle("Error Dialog");
            alert.setHeaderText("Registration problem");
            alert.setContentText("Correct highlighted fields");

            alert.showAndWait();
            resetTextFields(grid);
        }



    }

    public void onClearAll(ActionEvent actionEvent) {
        clearTextFields(grid);
    }

}
