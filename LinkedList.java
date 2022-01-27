
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
		
		// If Data does not exist, just return
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
				//if cur.getNext is null, the data we wanted to delete after is the last node in the list
				// and there is no data afte, so just return null
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
	
	
	// 
	// Internal Search.  If getCur is true this will return a reference to the Node containing the data.
	// if getCur is false, this will return a reference to the Node previous to the one containing the data.
	//
	// If getCur is true, and the method returns null, the data does not exist.
	// If getCur is false and the data exists the method return the reference to the previous node, unless
	// the data is in the first Node of the list in which case it returns null.
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
	
	public String toString() {
		if (count == 0) {
			return "<Empty>";
		} else {
			Node tmp = head;
			String rtn = "";
			
			while(tmp != null) {
				rtn += "\"" + tmp.getData() + "\" -> "; 
				tmp = tmp.getNext();
			}
			
			rtn += "null";
			return rtn;
		}
	}

}