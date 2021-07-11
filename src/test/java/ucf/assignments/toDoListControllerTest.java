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
        // assert that number of items in json list are equal to
        int actual = itemsList.size();
        assertEquals(expected,actual);

    }

}