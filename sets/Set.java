import java.util.ArrayList;

public abstract class Set<T> {
	ArrayList<T> elements;
	
	public Set() {
		elements = new ArrayList<T>();
	}

	/**
	 * Containment function. Returns true if element is in this set.
	 * For infinite sets, this function is not as easy as checking if
	 * the element is in an array.
	 */
	public abstract boolean contains(T element);

	
	public void addElement(T element) {
		elements.add(element);
	}
}
