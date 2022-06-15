import java.io.File;
import java.io.FileNotFoundException;
/**
 * Test Class
 * Creates new Array
 * Reads in "tasks.txt"
 * completes the task with the index of 2
 */
public class Test
{
    GUI gui;
        public static void main() throws FileNotFoundException
    {
        GUI gui;
        gui = new GUI();
        gui.readItemData("tasks.txt");
    }
    public Test() throws FileNotFoundException
    {
        gui = new GUI();
        gui.readItemData("tasks.txt");
        gui.completeTask(2);
        //gui.printTasks();
    }
}
