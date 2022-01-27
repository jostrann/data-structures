
public class LinkedQueue {
	private Node head = null;
	private Node tail = null;
	private int count;
	
	public boolean add(String data) {
		Node nn = new Node();
		nn.setData(data);
		
		// If the queue was empty it now contains 1 element, both head and tail should
		// refer to it.
		if (count == 0) {
			head = tail = nn;
			count = 1;
			return true;
		}
		
		tail.setNext(nn);
		tail = nn;
		count++;
		
		return true;
	}

	public String remove() {
		if (isEmpty()) {
			return null;
		}
		
		String rtn = head.getData();
		head = head.getNext();
		count--;
		
		// If we removed the last thing in the queue
		if (count == 0) {
			tail = null;
		}
		
		return rtn;
	}

	public int size() {
		return count;
	}

	public String peek() {
		if (isEmpty()) {
			return null;
		}
		
		// TODO Auto-generated method stub
		return head.getData();
	}

	public void clear() {
		head = tail = null;
		count = 0;
		
	}

	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return (count == 0);
	}

}
