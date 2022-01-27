
public class LinkedList {
	private Node head;
	private int count;
	
	public void addToHead(String data) {
		Node nn = new Node();
		nn.setData(data);
		nn.setNext(head);
		head = nn;
		count++;
	}
	
	public String removeFromHead() {
		if (count == 0) {
			return null;
		} else {
			String rtn = head.getData();
			head = head.getNext();
			count--;
			return rtn;
		}
	}
	
	public void addBefore(String addBeforeThis, String addThis) {
		if (!search(addBeforeThis)) {
			return;
		} else {
			Node prev = internalSearch(addBeforeThis, false);
			
			// If prev == null the data is the first element in the list
			// We want to insert before the head of the list!
			if (prev == null) {
				addToHead(addBeforeThis);
				return;
			} else {
				Node nn = new Node();
				nn.setData(addThis);
				nn.setNext(prev.getNext());
				prev.setNext(nn);
				count++;
				return;
			}
		}
	}
	
	public void addAfter(String addAfterThis, String addThis) {
		if (!search(addAfterThis)) {
			return;
		} else {
			Node cur = internalSearch(addAfterThis, true);
			Node nn = new Node();
			nn.setData(addThis);
			nn.setNext(cur.getNext());
			cur.setNext(nn);
			count++;
			return;
		}		
	}
	
	public String removeAfter(String data) {
		if (!search(data)) {
			return null;
		} else {
			// We now know the data exists
			Node cur = internalSearch(data, true);
			if (cur.getNext() == null) {
				return null;
			} else {
				String rtn = cur.getNext().getData();
				cur.setNext(cur.getNext().getNext());
				count--;
				return rtn;
			}
		}
	}
	
	public String remove(String data) {
		if (!search(data)) {
			return null;
		} else {
			// We now know the data exists
			Node prev = internalSearch(data, false);	
			if (prev == null) {
				// Data is the head, can't remove anything before the head
				return removeFromHead();
			} else {
				String rtn = prev.getNext().getData();
				prev.setNext(prev.getNext().getNext());
				count--;
				return rtn;
			}
		}
	}
	
	
	public boolean search(String data) {
		return (internalSearch(data, true) != null);
	}
	
	private Node internalSearch(String data, boolean getCur) {
		if (head == null) {
			return null;
		} else {
			Node prev = null;
			Node cur = head;
			
			while (cur != null) {
				if (cur.getData().equals(data)) {
					if (getCur) {
						return cur;
					} else {
						return prev;
					}
				}
				prev = cur;
				cur = cur.getNext();
			}
		}
		return null;
	}
}
