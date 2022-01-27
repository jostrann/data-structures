
public class ArrayStack {
	
	private Integer[] stack;
	private int count;
	private static final int STACK_SIZE = 32;
	
	public ArrayStack() {
		stack = new Integer[STACK_SIZE];
		count = 0;
	}

	public boolean push(Integer data) {
		if (isFull()) {
			// Stack overflow
			return false;
		}
		stack[count++] = data;
		return true;
	}

	public Integer pop() {
		if (isEmpty()) {
			// Stack underflow
			return null;
		}
		Integer rtn = peek();
		count--;
		return rtn;
	}

	public boolean isFull() {
		return (count >= STACK_SIZE);
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public Integer peek() {
		if (isEmpty()) {
			return null;
		}
		return stack[count-1];
	}

	public int maxCapacity() {
		return STACK_SIZE;
	}

	public int size() {
		return count;
	}

	public void clear() {
		count = 0;
	}
}
