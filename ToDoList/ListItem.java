/**
 * Class created to hold the information of the object that will be added to the array
 */
public class ListItem
{
    // String for the name of the listItem
    String name;
    // String for the due date of the listItem
    String dueDate;
    // boolean to check if the task has been comepleted
    boolean complete;
    /**
     * Constructor for objects of class ListItem
     */
    public ListItem(String newName, String newDueDate)
    {
        name = newName;
        dueDate = newDueDate;
        complete = false;
    }

    /**
     * Default constructor with set values
     */
    public ListItem()
    {
        name = "Task 1";
        dueDate = "1st December";
        complete = false;
    }

    /**
     * getter method to return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * getter method to return dueDate
     */
    public String getDueDate()
    {
        return dueDate;
    }
    
    /**
     * getter method to return complete
     */
    public boolean getComplete()
    {
        return complete;
    }

    /**
     * method to set complete to true
     */
    public boolean setCompleteTrue()
    {
        complete = true;
        return complete;
    }

    /**
     * toString method to format the object data appropriatly.
     */
    public String toString() {
        return "Task: " + name + ", Due Date: " + dueDate + ", Completed: " + complete; 
    }
}
