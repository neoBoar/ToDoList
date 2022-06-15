/**
 * Interface created to hold the abstract methods for the ToDoList.
 */
public interface IFace {
		public boolean isEmpty();
		public int size();
		public Object get(int index);
		public int indexOf(Object obj);
		public void add(int index, Object obj);
		public Object remove(int index);
		public String outputList();
}
