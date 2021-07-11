/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class toDoListControllerTest {
    @Test
    void listMeetsMinimumCapacity()
    {
        // initialize test directory
        String testDir = "src/test/java/ucf/assignments/test_files/capacityTest1.json";
        // create multiple tasks
        int expected = 100;
        // save file to test directory
        // check that number of items in saved JSON == tasks added
        File testFile = new File(testDir);
        Object obj = new Object();
        // try parsing json file
        try {
            obj = new JSONParser().parse(new FileReader(testFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // collect array of items from JSON object
        JSONObject currentObject = (JSONObject)obj;
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        // assert that list size is equal to expected minimum capacity
        int actual = itemsList.size();
        assertEquals(expected,actual);
    }

    @Test
    void addTaskWorks() {
        // initialize test directory
        String testDir = "src/test/java/ucf/assignments/test_files/addtasktest1.json";
        // create multiple tasks (in GUI)
        int expected = 5;
        // save file to test directory
        // check that number of items in saved JSON == tasks added
        File testFile = new File(testDir);
        Object obj = new Object();
        try {
             obj = new JSONParser().parse(new FileReader(testFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // pull array from JSON object
        JSONObject currentObject = (JSONObject)obj;
        JSONArray itemsList = (JSONArray)currentObject.get("items");

        // assert that number of items in json list are equal to expected
        int actual = itemsList.size();
        assertEquals(expected,actual);

    }

    @Test
    void descriptionMeetsCapacity()
    {
        // in gui, add a task with a description field of 256
        // test string:
        //9ctZXIQDTDFIgkywaFmIDbQ0HsWlAi9SGlWmycBbTqCFlTarVSIHKqMzZ8AXXUEq2FasddspDrTZR00VU9mu3vVAQThcyPyDiXIPEIqn8rOH6fH84IWyngJlXjknKvmGUVy8sGQgtBQxKXMgGo6gJEUbiMrwTvxQCPWlMT7adD2PiElcAjt6m1Nnk9j7rZYehwi87W2g5M0rSyp551QPZEuy9782DwxftDZZlV2PcUgaARA6tk9OWK1tWqsw5qpK

        // initialize test directory
        String testDir = "src/test/java/ucf/assignments/test_files/descriptionTest1.json";

        // retrieve file with description test obejct
        File testFile = new File(testDir);
        Object obj = new Object();
        try {
            obj = new JSONParser().parse(new FileReader(testFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // pull string from JSON object
        JSONObject currentObject = (JSONObject)obj;
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        JSONObject itemObj = (JSONObject)itemsList.get(0);
        String descriptionString = (String)itemObj.get("description");

        // asserts that description string meets minimum capacity
        int expected = 256;
        int actual = descriptionString.length();

        assertEquals(expected, actual);
    }

    @Test
    void validDueDate()
    {

    }

    @Test
    void removesItem()
    {
        // in gui, populate to-do list with one item.
        // remove the item using right-click context menu

        // retrieve file from test_files directory
        // initialize test directory
        String testDir = "src/test/java/ucf/assignments/test_files/removeItemTest1.json";

        // retrieve file with description test obejct
        File testFile = new File(testDir);
        Object obj = new Object();
        try {
            obj = new JSONParser().parse(new FileReader(testFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // collect array of items from test file
        JSONObject currentObject = (JSONObject)obj;
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        // assert that list was empty after removing single item
        int expected = 0;
        int actual = itemsList.size();

        assertEquals(expected,actual);
    }

    @Test
    void clearsList()
    {
        // in gui, populate to-do list with multiple items.
        // clear the list via menubar

        // retrieve file from test_files directory
        // initialize test directory
        String testDir = "src/test/java/ucf/assignments/test_files/clearListTest1.json";

        // retrieve file with description test obejct
        File testFile = new File(testDir);
        Object obj = new Object();
        try {
            obj = new JSONParser().parse(new FileReader(testFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // collect array of items from test file
        JSONObject currentObject = (JSONObject)obj;
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        // assert that list was empty after removing single item
        int expected = 0;
        int actual = itemsList.size();

        assertEquals(expected,actual);

    }

    @Test
    void editsDescription()
    {
        // retrieve file from test_files directory
        // initialize test directory
        String testDir = "src/test/java/ucf/assignments/test_files/editsDescriptionTest1.json";

        // retrieve file with description test obejct
        File testFile = new File(testDir);
        Object obj = new Object();
        try {
            obj = new JSONParser().parse(new FileReader(testFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // pull string from JSON object
        JSONObject currentObject = (JSONObject)obj;
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        JSONObject itemObj = (JSONObject)itemsList.get(0);

        // this is the string before editing the object
        String originalDescription = "test1";


        // In gui, load list & edit the description of the pre-existing item.
        String newDescription = (String)itemObj.get("description");
        boolean expected = true;
        boolean actual = !originalDescription.equals(newDescription);
        // if the old description is not equal to new, edit worked
        assertEquals(expected,actual);
    }

    @Test
    void editsDueDate()
    {

    }

    @Test
    void marksComplete()
    {

    }

    @Test
    void marksIncomplete()
    {

    }

    @Test
    void filtersComplete()
    {

    }

    @Test
    void filtersIncomplete()
    {

    }

    @Test
    void savesList()
    {

    }

    @Test
    void loadsList()
    {

    }




}