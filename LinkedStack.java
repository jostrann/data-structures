
public class LinkedStack {
	
	private Node stack;
	private int count;
	
	public boolean push(String data) {
		Node n = new Node();
		n.setData(data);
		n.setNext(stack);
		stack = n;
		count++;
		return false;
	}

	public String pop() {
		if (isEmpty()) {
			return null;
		}	
		String rtn = peek();	
		stack = stack.getNext();
		count--;
		return rtn;
	}

	public boolean isFull() {
		// Linked Stack is never full
		return false;
	}

	public boolean isEmpty() {
		return (count == 0);
//		return (stack == null);
	}

	public String peek() {
		if (isEmpty()) {
			return null;
		}
		return stack.getData();
	}

	public int maxCapacity() {
		return Integer.MAX_VALUE;
	}

	public void clear() {
		stack = null;
		count = 0;
	}
	
	public String toString() {
		if (isEmpty()) {
			return "<Empty>";
		} else {
			String rtn = "";
			Node n = stack;
			while(n != null) {
				if (n == stack) {
					rtn += "top -> ";
				} else {
					rtn += "       ";
				}
				
				rtn += n.getData() + "\n";
				n = n.getNext();
			}
			return rtn;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
}
