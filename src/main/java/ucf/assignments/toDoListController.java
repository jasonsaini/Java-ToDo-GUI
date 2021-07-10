/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Saini
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.security.auth.callback.Callback;
import java.io.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class toDoListController {
    @FXML
    TextField descriptionField;
    @FXML
    DatePicker datePicker;
    @FXML
    ObservableList<listItem> list = FXCollections.observableArrayList();
    @FXML
    ListView<listItem> itemList;

    @FXML
    TextField listTitleField;

    public void addTaskButtonClicked(ActionEvent actionEvent) {
        addTask();
    }

    public void descriptionInputChanged(Event event) {
        openNewDescriptionDialog();
    }

    public void dueDateInputChanged(Event event) {
        editDueDate();
    }

    public void newListButtonClicked(ActionEvent actionEvent) {
        createNewList();
    }

    public void deleteListButtonCLicked(ActionEvent actionEvent) {
        deleteList();
    }

    public void clearListButtonClicked(ActionEvent actionEvent) {
        clearList();
    }

    public void saveListButtonClicked(ActionEvent actionEvent) {
        saveList();
    }

    public void loadListButtonClicked(ActionEvent actionEvent) {
        loadList();
    }

    public void incompleteItemsFilterButtonClicked(ActionEvent actionEvent) {
        filterIncomplete();
    }

    public void completeItemsFilterButtonClicked(ActionEvent actionEvent) {
        filterComplete();
    }

    public void showAllButtonClicked(ActionEvent actionEvent) { showAllItems();}

    public void sortButtonClicked(ActionEvent actionEvent) {
        sortByDueDate(list);
    }

    public void aboutButtonClicked(ActionEvent actionEvent) {
        displayTutorial();
    }

    public void removeItemButtonClicked(ActionEvent actionEvent) {
        removeItem();
    }

    public void markItemButtonClicked(ActionEvent actionEvent) {
        markItem();
    }

    private void addTask() {
        try {
            // Get date string from datePicker
            LocalDate curDate = datePicker.getValue();
            // get description string from text field
            String curDescription = descriptionField.getText();
            // create a ListItem
            listItem toAdd = new listItem(curDescription, curDate);
            // add listItem to listView in GUI
            list.add(toAdd);
            itemList.setItems(list);
            descriptionField.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clearList()
    {
        // clear observable list
        list.clear();
        // match listview to list of items
        itemList.setItems(list);
    }

    @FXML
    private void openNewDescriptionDialog() {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("editDescriptionPopup.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // get index of selected item in list view
        int selectedIndex = itemList.getSelectionModel().getSelectedIndex();
        // temp variable for list item object
        listItem toSend = list.get(selectedIndex);
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setUserData(toSend);

        stage.setScene(scene);
        stage.setTitle("Edit Description");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        itemList.getSelectionModel().clearSelection();


    }


    private void editDueDate() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("editDueDatePopup.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // get index of selected item in list view
        int selectedIndex = itemList.getSelectionModel().getSelectedIndex();
        // temp variable for list item object
        listItem toSend = list.get(selectedIndex);
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setUserData(toSend);

        stage.setScene(scene);
        stage.setTitle("Edit Due Date");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        itemList.getSelectionModel().clearSelection();

    }

    private void createNewList() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ToDoList.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Jason's To-do List");
            stage.setResizable(false);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteList() {
        // prompt "are you sure" dialog

        // if yes
        // clear list view
        // clear title text field
        // close window without saving to file
        // if no
        // pass, do nothing
    }

    private void saveList() {
        //  retrieve list title from title text field
        String saveTitle = listTitleField.getText();
        //  store items from list in JSON Array
        JSONObject dataObject = new JSONObject();
        dataObject.put("list-title", saveTitle);

        //  create a filename from title by replacing spaces with underscores
        String filename = saveTitle.replaceAll(" ", "_").toLowerCase(Locale.ROOT) + ".json";
        //  create a JSON file with list title and JSON array
        JSONArray itemArray = new JSONArray();
        for(int i = 0; i < list.size(); i++)
        {
            JSONObject temp = new JSONObject();
            temp.put("description", list.get(i).getDescription());
            temp.put("dueDate", list.get(i).getDueDate().toString());
            temp.put("isComplete", list.get(i).isComplete);
            itemArray.add(temp);
        }
        dataObject.put("items",itemArray);
        //  push file to predetermined local directory
        FileChooser listSaver = new FileChooser();
        listSaver.setInitialFileName(filename);
        File dest  = listSaver.showSaveDialog(new Stage());
        System.out.println(dest.toString());
        try {
            FileWriter writer = new FileWriter(dest);
            writer.write(dataObject.toJSONString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadList() {
        // open file dialog to default local directory
        FileChooser listLoader = new FileChooser();

        // Set extension filter for JSON files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        listLoader.getExtensionFilters().add(extFilter);
        File toLoad = listLoader.showOpenDialog(new Stage());

        try
        {
            Object obj = new JSONParser().parse(new FileReader(toLoad));
            JSONObject object = (JSONObject)obj;
            String loadTitle = (String)object.get("list-title");
            System.out.print(loadTitle);
            JSONArray itemArray = (JSONArray)object.get("items");
            list.clear();
            Iterator i = itemArray.iterator();
            while(i.hasNext())
            {
                JSONObject curObject = (JSONObject) i.next();
                String curDescription = (String)curObject.get("description");
                LocalDate curDueDate = (LocalDate) LocalDate.parse((String)curObject.get("dueDate"));
                boolean curIsComplete = (boolean) curObject.get("isComplete");
                listItem toAdd = new listItem(curDescription,curDueDate,curIsComplete);
                list.add(toAdd);
            }
            listTitleField.setText(loadTitle);
            itemList.setItems(list);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void filterIncomplete() {

        // create observable list for incomplete items
        ObservableList<listItem> incompleteList = FXCollections.observableArrayList();
        // iterate through list
        for(int i = 0; i < list.size(); i++)
        {
            // if an item is incomplete
            if(!list.get(i).isComplete)
            {
                // add it to the incomplete list
                incompleteList.add(list.get(i));
            }
        }
        // sort remaining items by due date (soonest first)
        sortByDueDate(incompleteList);
        // set list view to filtered list
        itemList.setItems(incompleteList);

    }

    private void filterComplete() {
        // create observable list for complete items
        ObservableList<listItem> completeList = FXCollections.observableArrayList();
        // iterate through list
        for(int i = 0; i < list.size(); i++)
        {
            // if an item is incomplete
            if(list.get(i).isComplete)
            {
                // add it to the incomplete list
                completeList.add(list.get(i));
            }
        }
        // sort remaining items by due date (soonest first)
        sortByDueDate(completeList);
        // set list view to filtered list
        itemList.setItems(completeList);
    }

    private void showAllItems()
    {
        itemList.setItems(list);
    }
    private void displayTutorial() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("aboutPopup.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Help");
        stage.setResizable(false);
        stage.show();

    }

    private void markItem() {
        // get index of selected item in list view
        int selectedIndex = itemList.getSelectionModel().getSelectedIndex();
        // temp variable for list item object
        listItem current = list.get(selectedIndex);
        list.remove(selectedIndex);
        // invert the completion status of temp item
        current.isComplete = !current.isComplete;
        // display completion status on listview Item
        list.add(current);
        itemList.setItems(list);
        sortByDueDate(list);
    }

    private void removeItem()
    {
        // get index of selected item in list view
        int selectedIndex = itemList.getSelectionModel().getSelectedIndex();
        // temp variable for list item object
        listItem toRemove = list.get(selectedIndex);
        // add listItem to listView in GUI
        list.remove(toRemove);
        itemList.setItems(list);


    }

    private void sortByDueDate(ObservableList<listItem> list)
    {

        list.sort((p1,p2) -> p1.dueDate.toString().compareTo(p2.dueDate.toString()));
    }





}
