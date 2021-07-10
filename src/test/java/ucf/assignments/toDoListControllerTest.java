/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class toDoListControllerTest {

    @Test
    void addTaskButtonClicked() {
        // assert that listView is blank before adding task
        // create a listItem object from textfields (valid and non empty)
        // click add task button
        // assert that listView is non-empty after pushing new task to list view
    }

    @Test
    void descriptionInputChanged() {
        // add a new item to list
        // hold its original description
        // use context menu to select 'edit description'
        // hold new description
        // assert that the original and new description are not equal
    }

    @Test
    void dueDate_is_valid() {
        // retrieve current date
        // get current due date from selected item
        // assert current due date is >= current date
    }


    @Test
    void newListButton() {
        // track current number of lists
        // click new list button
        // track new number of lists
        // assert that new number of lists is equal to current number + 1
    }

    @Test
    void deleteListButtonCLicked() {
        // track current number of lists
        // click delete list button
        // track new number of lists
    }

    @Test
    void fileLoads() {
        // stringify file
        // load same file into application
        // stringify list view
        // assert that the file string equals list view string
    }

    @Test
    void saveCreateFileWithValidName() {
        // store status of directory before click (preferably empty)
        // store the potential name of the file from the title text field
        // click save this list button
        // check directory for matching file name
    }


    @Test
    void savesAllLists() {
        // save number of open lists (or hardcode expected number of saved lists)
        // check that directory is empty before save
            // click save all lists button
        // count number of files in directory
        // assert that that expected number matches number of files in directory
    }

    @Test
    void loadsMultipleLists() {
        // populate list directory with multiple lists
        // get number of list files in directory
        // get number of lists in directory, or hardcode expected number
        // use the loadMultipleLists function to load entire directory
        // get number of open windows
        // assert that number of windows is equal to number of files in directory
    }

    @Test
    void checkCompletedItemsFilter() {
        // populate an app list view with items
        // mark some as complete
        // click filter complete button
        // iterate through new listview to see if all items are completed
        // assert that all the items are marked completed after filtration
    }

    @Test
    void checkIncompleteItemsFilter() {
        // populate an app list view with items
        // mark some as complete/incomplete
        // click filter incomplete button
        // iterate through new listview to see if all items are not completed
        // assert that all the items are marked completed after filtration
    }

}