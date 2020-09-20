import java.util.List;

public class SimpleArrayList {

	private String[] arr;
	public static int size;
	public static final int cap = 10;
	
	public SimpleArrayList() {
		arr = new String[cap];
		size = 0;
	}
	public SimpleArrayList(int initialCapacity) {
		if (initialCapacity == -1) throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		arr = new String[initialCapacity];
		size = 0;
	}
	public SimpleArrayList (List<String> list) {
		if (list == null) throw new NullPointerException();
		arr = new String[list.size()]; 
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		size = arr.length;
	}
	public void add(int idx, String s) {
		openIndex();
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Index: " + idx + ", " + "Size: " + size);
		}
		
		for(int i = arr.length-2; i > idx-1; i--) {
			arr[i+1] = arr[i];
		}
		arr[idx] = s;
		size ++;
	}
	
	public boolean add(String s) {
		openIndex();
		arr[size] = s;
		size ++;
		return true; 
	}	
	
	public void clear() {
		size = 0;
		arr = new String[cap];
		arr[0] = "";
	}
	
	public boolean contains(String s) {
		for (int i = 0; i < size; i++) {
			if(arr[i] == s) {
				return true;
			}
		}
		return false;
	}
	public String get(int idx) {
		checkIndexBounds(idx, size);
		return arr[idx];
	}
	public int indexOf(String s) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == s) {
				return i;
			}
		}
	return -1;
	}
	public boolean isEmpty() {
		return (size == 0);
	}
	public String remove (int idx) {
		checkIndexBounds(idx, size);
		String removed = arr[idx];
		for (int i = idx; i < size-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[size -1] = null;
		size --;
		return removed;
	}
	public boolean remove(String s) {
		int idx = indexOf(s);
		if(idx != -1) {
			remove(idx);
			return true;
		}
		return false;
	}
	public String set(int idx, String s) {
		checkIndexBounds(idx, size);
		String replaced = arr[idx];
		arr[idx] = s;
		return replaced;
	}
	public int size() {
		return size;
	}
	public void trimToSize() {
		String[] temp = new String[size];
		for (int i = 0; i < size; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}
	public String toString() {
		String values = "" ;
		for (int i = 0; i < size -1; i++) {
			values += arr[i];
			values += ", ";
		}
		if (size != 0) {
			values += arr[size -1];
		}
		String finalString = "[" + values + "]";
		return finalString;
	}
	private void checkIndexBounds(int idx, int size) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Index " + idx + " out of bounds for length " + size);
		}
	}
	private void openIndex() {
		if(size+1 > arr.length) {
			String[] temp = new String[arr.length+cap];
			for(int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
	}
}
	