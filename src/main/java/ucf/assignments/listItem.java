/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Saini
 */

package ucf.assignments;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class listItem {
    String description;
    LocalDate dueDate;
    boolean isComplete;

    public listItem(String Description, LocalDate DueDate)
    {
        this.description = Description;
        this.dueDate = DueDate;
        this.isComplete = false;
    }

    public listItem(String description, LocalDate dueDate, boolean isComplete)
    {
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = isComplete;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public void setDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    @Override
    public String toString()
    {
        String monthString;
        if (getDueDate().getMonthValue() < 10)
        {
                monthString = "0" + getDueDate().getMonthValue();
        }
        else
        {
            monthString = String.valueOf(getDueDate().getMonthValue());
        }

        String dayString;
        if(getDueDate().getDayOfMonth() < 10)
        {
            dayString = "0" + getDueDate().getDayOfMonth();
        }
        else
        {
           dayString = String.valueOf(getDueDate().getDayOfMonth());
        }
        String dateString = dueDate.getYear() + "-" + monthString + "-" + dayString;

        String status = "";
        if(isComplete)
        {
            status = "COMPLETED!!!!! :D     ";
        }
        return status + description + " by " + dateString;
    }





}
