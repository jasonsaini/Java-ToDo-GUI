/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Saini
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.scene.input.InputMethodEvent;

public class toDoListController {

    public void listTitleFieldClicked(ActionEvent actionEvent) {
        editTitleField();
    }

    public void addTaskButtonClicked(ActionEvent actionEvent) {
        addTask();
    }

    public void descriptionInputChanged(InputMethodEvent inputMethodEvent) {
        editDescription();

    }

    public void dueDateInputChanged(InputMethodEvent inputMethodEvent) {
        editDueDate();
    }


    public void newListButtonClicked(ActionEvent actionEvent) {
        createNewList();
    }

    public void deleteListButtonCLicked(ActionEvent actionEvent) {
        deleteList();
    }


    public void saveListButtonClicked(ActionEvent actionEvent) {
        saveList();
    }

    public void loadListButtonClicked(ActionEvent actionEvent) {
        loadList();
    }

    public void saveAllListButtonClicked(ActionEvent actionEvent) {
        saveAllLists();
    }

    public void loadMultipleListsButtonClicked(ActionEvent actionEvent) {
        loadMultipleLists();
    }


    public void incompleteItemsFilterButtonClicked(ActionEvent actionEvent) {
        filterIncomplete();
    }

    public void completeItemsFilterButtonClicked(ActionEvent actionEvent) {
        filterComplete();
    }

    private void editTitleField() {
        // if text field is "emptied" (previous text is removed)
        // keep the previous title
        // if title is replaced, allow change to text field
    }

    private void addTask() {
        // check for duplicate item description or empty fields
        // do nothing if text field is empty or has duplicate content
        // Get date string from datePicker
        // get description string from text field
        // create a ListItem
        // add listItem to listView in GUI
    }

    private void editDescription()
    {
        // if edit description menu is clicked
        // check to make sure item description is not empty
        // if it is , do not allow the change
        // otherwise, replace original description attribute with new string
    }

    private void editDueDate()
    {
        // make sure lowest input is current date
        // reject any input from before the current day
        // set date for addTask button
    }

    private void createNewList()
    {
        // create a duplicate window
        // intiialize it to empty
        // prompt user for title
        // set title from non-empty text field
    }

    private void deleteList()
    {
        // prompt "are you sure" dialog

        // if yes
            // clear list view
            // clear title text field
            // close window without saving to file
        // if no
            // pass, do nothing
    }

    private void saveList()
    {
        //  retrieve list title from title text field
        //  store items from listview in JSON Array
        //  create a filename from title by replacing spaces with underscores
        // catch invalid filename characters
        //  create a JSON file with list title and JSON array
        //  push file to predetermined local directory
    }

    private void loadList()
    {
        // open file dialog to default local directory

        // try to retrieve title attribute from JSON file
        // try to retrieve JSON array from selected JSON File
            // catch invalid file format if present

        // load data from title attribute from file into app text field
        // load data from JSON array into app list view
    }

    private void saveAllLists()
    {
        // iterate through all open windows
            // for each open window, save to a separate file
            // via saveList()
    }

    private void loadMultipleLists()
    {
        // open file dialog
        // allow multiple selections at once
        // perform loadList() on all files
    }

    private void filterIncomplete()
    {
        // iterate through list view
        // for each object
        // hide if status is set to completed
        // retain the data of completed objects
        // sort remaining items by due date (soonest first)
    }

    private void filterComplete()
    {
        // iterate through list view
        // for each object
        // hide if status is set to incomplete
        // retain the data of incompleted objects
        // sort remaining items by due date (most recently completed first)
    }



}
