import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * A template collection class which has an array inside it and modifies it
 * dynamically and can be interpreted as a self implementation of the
 * functionality given in the java's own list interface.
 * 
 * @param <T> Template class type, is able to hold any type of class
 */
public class ListImpl<T> {
	private T[] arr;
	private int size;

	public ListImpl() {
		this.size = 0;
		this.arr = null;
	}

	@SuppressWarnings("unchecked")
	public void insert(T elem) {
		if (arr == null) {
			arr = (T[]) Array.newInstance(elem.getClass(), 1);
			arr[0] = elem;
		} else {
			T[] tmp = (T[]) Array.newInstance(elem.getClass(), size + 1);
			for (int i = 0; i < size; i++) {
				tmp[i] = arr[i];
			}
			tmp[size] = elem;
			arr = tmp;
		}
		size++;
	}

	public T get(int index) {
		return arr[index];
	}

	@SuppressWarnings("unchecked")
	public void removeAt(int index) {
		T[] tmp = (T[]) Array.newInstance(arr[0].getClass(), size - 1);
		int skip = 0;
		for (int i = 0; i + skip < size; i++) {
			if (i == index && skip != 1) {
				skip = 1;
				i--;
				continue;
			}
			tmp[i] = arr[i + skip];
		}
		arr = tmp;
		size--;
	}

	public int findIndex(T elem) {
		for (int i = 0; i < size; i++) {
			if (arr[i].equals(elem)) {
				return i;
			}
		}
		return -1;
	}

	public void changeAt(T elem, int index) {
		arr[index] = elem;
	}

	/**
	 * Returns the maximum value of the list by comparing them with a ruleset given in a comparator.
	 * @param comparator the comparison rules
	 * @return maximum element
	 */
	public T getMax(Comparator<T> comparator) {
		int maxIndex = 0;
		for (int i = 0; i < size; i++) {
			if (comparator.compare(arr[i], arr[maxIndex]) > 0) {
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}


	/**
	 * Returns the minimum value of the list by comparing them with a ruleset given in a comparator.
	 * @param comparator the comparison rules
	 * @return minimum element
	 */
	public T getMin(Comparator<T> comparator) {
		int minIndex = 0;
		for (int i = 0; i < size; i++) {
			if (comparator.compare(arr[i], arr[minIndex]) < 0) {
				minIndex = i;
			}
		}
		return arr[minIndex];
	}

	public int size() {
		return size;
	}

}
