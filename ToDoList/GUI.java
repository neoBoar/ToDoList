import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Main class to excecute the abstract methods from the ToDo class which implements the List interface.
 */
public class GUI extends ToDo
{
    public static void main() throws FileNotFoundException
    {
        GUI gui;
        gui = new GUI();
        gui.readItemData("tasks.txt");
    }
    /**
     * Constructor for the GUI.
     * Note: GUI is named as the class where changes can be made to the data.
     * Constructor creates the Array with a specified initial capacity.
     */
    public GUI(int initialCapacity)
    {
        if (initialCapacity < 1)
            throw new IllegalArgumentException
            ("capacity must be >= 1");
        elementArray = new Object [initialCapacity];
        size = initialCapacity;
    }

    /**
     * simple constructer specifying the capcity as 10.
     */
    public GUI()
    {
        this(10);
    }

    /**
     * Checks the index input to make sure the array holds an index of that number.
     */
    public void checkIndex (int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
            ("index = " + index + " size = " + size);
    }

    /**
     * uses checkIndex() method.
     * returns the index input.
     */
    public Object get(int index)
    {
        checkIndex(index);
        return elementArray[index];
    }

    /**
     * Returns the index of the object input.
     */
    public int indexOf(Object theElement)
    {
        for (int i = 0; i < size; i++)
            if (elementArray[i].equals(theElement))
            // equals() method for content comparison
                return i;
        return -1;
    }

    /**
     * uses checkIndex() method.
     * Adds a new object to the array with a list position in the form of an index number.
     * the size of the list is then increased by 1.
     */
    public void add(int index, Object theElement)
    {
        checkIndex(index);
        if (size == elementArray.length)
        {
            Object[] newArray =
                new Object[elementArray.length*2];
            System.arraycopy(elementArray,0,newArray,
                0,elementArray.length);
            elementArray = newArray;
        }
        for (int i = size - 1; i >= index; i--)
            elementArray[i + 1] = elementArray[i];
        elementArray[index] = theElement;
        size++;
    }

    /**
     * Read method that scans a file to fill the Array with some tasks for the ToDoList
     * Converts the data provided into task names and Due Dates that will populate the Array
     */
    public void readItemData(String filePath) throws FileNotFoundException
    {
        ListItem listItem = new ListItem();
        File fileName = new File(filePath);
        Scanner scanner = new Scanner(fileName);
        while(scanner.hasNextLine())
        {
            String name = scanner.next();
            String dueDate = scanner.next();
            add(0, listItem = new ListItem(name, dueDate));
        }
        scanner.close();
    }

    /**
     * Checks the index input is correct
     * creates a StringBuffer and fills with objects in the array in the form of strings
     * if and objects index matches the paremeter of the method, the stringbuffer will change the complete value to "true" and print out the line
     * if the objects index does not match the paremeter of the method, the stringbuffer will print out the line without changing any values
     * the object that has match the method parameter and has had a value changed will then be removed from the array as the task has been comepleted
     * the rest of the objects in the array will remain as they are yet to be marked as completed
     */
    public void completeTask(int index)
    {
        checkIndex(index);
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < size; i++)
        {
            if (elementArray[i] == null)
            {
                s.append("null, ");
            }
            else if(i == index)
            {
                s.delete(0,s.length());
                s.append(elementArray[i]);
                s.replace(s.indexOf("false"),s.length(),"true");               
                System.out.println(s);
            }
            else
            {
                s.delete(0,s.length());
                s.append(elementArray[i]);
                System.out.println(s);
            }           
        }
        remove(index); // removed after the list of complete and non
    }

    /**
     * Method used to create a string buffer with all of the objects from the array.
     * the string buffer is returned and also printed out
     */
    public String outputList()
    {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < size; i++)
            if (elementArray[i] == null)
                s.append("null, ");
            else
                s.append(elementArray[i].toString() + ", ");
        if (size > 0)
            s.delete(s.length() - 2, s.length());
        System.out.println(s);
        return new String(s);
    }

    /**
     * This method prints out all of the tasks that are in the array.
     * The tasks are printed in a easy to read format line by line.
     */
    public void printTasks()
    {
        for (int i = 0; i < size; i++)
        // put elements into the buffer
            if (elementArray[i] == null)
                System.out.println("null, ");
            else
                System.out.println(elementArray[i].toString() + ", ");
    }

    /**
     * checks index method.
     * This method removes an object that has the same index as the parameter of the method.
     * The size of the list is then reduced by 1.
     */
    public Object remove(int index)
    {
        checkIndex(index);
        Object removedElement = elementArray[index];
        for (int i = index + 1; i < size; i++)
            elementArray[i-1] = elementArray[i];
        elementArray[--size] = null;
        return removedElement;
    }
}
