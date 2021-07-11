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
import java.time.LocalDate;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class toDoListControllerTest {

    public JSONObject parseJSONFile(String dir)
    {   // instantiate file directory and object
        File testFile = new File(dir);
        Object obj = new Object();
        // try parsing json file
        try {
            obj = new JSONParser().parse(new FileReader(testFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // return JSON Object
        JSONObject object = (JSONObject)obj;
        return object;
    }

    @Test
    void listMeetsMinimumCapacity()
    {
        // initialize test directory
        String testDir = "src/test/java/ucf/assignments/test_files/capacityTest1.json";
        // create multiple tasks
        int expected = 100;
        // save file to test directory
        // check that number of items in saved JSON number of items added: 100
        JSONObject currentObject = parseJSONFile(testDir);
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

        // pull array from JSON object
        JSONObject currentObject = parseJSONFile(testDir);
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

        JSONObject currentObject = parseJSONFile(testDir);
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        // pull string from JSON object
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
        String testDir = "src/test/java/ucf/assignments/test_files/validDueDate1.json";

        // retrieve file with dueDate test object

        JSONObject currentObject = parseJSONFile(testDir);
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        JSONObject itemObj = (JSONObject)itemsList.get(0);
        boolean expected = true;
        boolean actual = false;
        try
        {
            // if local date can parse, format is valid
            LocalDate curDueDate = (LocalDate) LocalDate.parse((String)currentObject.get("dueDate"));
            actual = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        // assert that due date is valid
        assertEquals(expected,actual);
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
        JSONObject currentObject = parseJSONFile(testDir);

        // collect array of items from test file
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
        JSONObject currentObject = parseJSONFile(testDir);

        // collect array of items from test file
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

        // retrieve file with description test object
        // pull string from JSON object
        JSONObject currentObject = parseJSONFile(testDir);
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
        // In gui, load list (editsDueDate1.json) & edit the description of the pre-existing item.
        // retrieve file from test_files directory
        // initialize test directory
        String testDir = "src/test/java/ucf/assignments/test_files/editsDueDate1.json";

        // retrieve file with dueDate test object

        JSONObject currentObject = parseJSONFile(testDir);
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        JSONObject itemObj = (JSONObject)itemsList.get(0);

        // this is the string before editing the object
        String originalDueDate = "2021-07-11";

        // pull string from JSON object
        String newDueDate = (String)itemObj.get("dueDate");
        boolean expected = true;
        boolean actual = !newDueDate.equals(originalDueDate);
        // if the old dueDate is not equal to new, edit worked
        assertEquals(expected,actual);
    }

    @Test
    void marksComplete()
    {
        // populate a list with an incomplete item
        // set it to complete via context menu in GUI
        // initilaize directory of corresponding list file
        String testDir = "src/test/java/ucf/assignments/test_files/marksCompleteTest1.json";

        // retrieve file with list item
        // retrieve item JSON object
        JSONObject currentObject = parseJSONFile(testDir);
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        JSONObject itemObj = (JSONObject)itemsList.get(0);
        // assert that isComplete status of item is true after mark
        boolean expected = true;
        boolean actual = (boolean)itemObj.get("isComplete");
        assertEquals(expected,actual);
    }

    @Test
    void marksIncomplete()
    {
        // populate a list with an incomplete item
        // set it to complete via context menu in GUI

        // initilaize directory of corresponding list file
        String testDir = "src/test/java/ucf/assignments/test_files/marksIncompleteTest1.json";

        // retrieve item JSON object
        JSONObject currentObject = parseJSONFile(testDir);
        JSONArray itemsList = (JSONArray)currentObject.get("items");
        JSONObject itemObj = (JSONObject)itemsList.get(0);

        // assert that isComplete status of item is false after marking incomplete
        boolean expected = false;
        boolean actual = (boolean)itemObj.get("isComplete");
        assertEquals(expected,actual);
    }

    @Test
    void sortsByDueDate()
    {
        // populate a new list with dates in random/descending order
        // open and parse corresponding file
        String testDir = "src/test/java/ucf/assignments/test_files/sortsByDueDate1.json";
        JSONObject object = parseJSONFile(testDir);

        // retrieve items list
        JSONArray itemsList = (JSONArray)object.get("items");

        Iterator i  = itemsList.iterator();
        boolean expected = true;
        boolean actual = true;
        String prevDate = "0";
        while(i.hasNext())
        {

            JSONObject curObject = (JSONObject) i.next();
            // get due date of current item
            String curDate = (String)curObject.get("dueDate");
            // compare it to previous item
            if(curDate.compareTo(prevDate) < 0)
            {
                // if the current date is less than the previous date, test failed
                actual = false;
            }
        }

        assertEquals(expected,actual);
    }




}