
public class DLinkedList {

	private DNode head;
	private DNode tail;
	private int count;
	
	public void addToHead(String data) {
		DNode nn = new DNode();
		nn.setData(data);
		
		nn.setNext(head);
		nn.setPrev(null);
		
		head = nn;
		count++;
		
		if (count == 1) {
			// only item in list
			tail = head;
		} else {
			head.getNext().setPrev(head);
		}
	}
}
