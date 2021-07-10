/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Saini
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class descriptionPopUpController {

    @FXML
    TextField changeDescriptionTextField;
    @FXML
    Button changeDescriptionButton;
    public void changeDescriptionButtonClicked(ActionEvent actionEvent) {
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        listItem cur = (listItem)stage.getUserData();
        setNewDescription(cur);
        stage.close();
    }

    private void setNewDescription(listItem item)
    {
        String newDescription = changeDescriptionTextField.getText();
        item.description = newDescription;

    }



}
