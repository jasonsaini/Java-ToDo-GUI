/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Saini
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.time.LocalDate;

public class editDueDatePopupController {
    @FXML
    DatePicker datePicker;

    public void changeDueDateButtonClicked(ActionEvent actionEvent) {
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        listItem cur = (listItem)stage.getUserData();
        setNewDueDate(cur);
        stage.close();
    }

    private void setNewDueDate(listItem item)
    {
        LocalDate newDate = datePicker.getValue();
        item.dueDate = newDate;
    }

}
