/**
 * importing packages individually.
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * ToDo abstract class holding abstract methods to be excecuted by the Main(GUI) class.
 */
public abstract class ToDo implements IFace { 
    protected Object[] elementArray;
    protected int size;
    public void checkIndex (int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
            ("index = " + index + " size = " + size);
    }

    public Object get(int index)
    {
        checkIndex(index);
        return elementArray[index];
    }

    public int indexOf(Object theElement)
    {
        for (int i = 0; i < size; i++)
            if (elementArray[i].equals(theElement))
                return i;
        return -1;
    }

    public Object remove(int index)
    {
        checkIndex(index);
        Object removedElement = elementArray[index];
        for (int i = index + 1; i < size; i++)
            elementArray[i-1] = elementArray[i];
        elementArray[--size] = null;
        return removedElement;
    }

    public String outputList()
    {
        StringBuffer s = new StringBuffer("[");
        for (int i = 0; i < size; i++)
            if (elementArray[i] == null)
                s.append("null, ");
            else
                s.append(elementArray[i].toString() + ", ");
        if (size > 0)
            s.delete(s.length() - 2, s.length());
        s.append("]");
        System.out.println(s);
        return new String(s);
    }

    public void printTasks()
    {
        String s = new String();
        for (int i = 0; i < size; i++)
            s = elementArray[i].toString();
        System.out.println(s);
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

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
}