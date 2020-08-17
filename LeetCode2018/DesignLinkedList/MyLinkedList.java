class MyLinkedList {
	Node head;
	Node tail;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = new Node(0);
		tail = new Node(0);
		head.next = tail;
		tail.prev = head;

	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		Node n = getNode(index);
		if (n == null)
			return -1;
		return n.val;
	}

	public Node getNode(int index) {
		int len = length();
		if (index >= len)
			return null;
		Node p = head.next;
		int count = 0;
		while (p != tail && count < index) {
			p = p.next;
			count++;
		}
		return p;
	}

	private int length() {
		Node p = head.next;
		int len = 0;
		while (p != tail) {
			p = p.next;
			len++;
		}
		return len;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node first = head.next;
		Node n = new Node(val);
		head.next = n;
		n.prev = head;
		n.next = first;
		first.prev = n;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		Node prev = tail.prev;
		Node n = new Node(val);
		prev.next = n;
		n.prev = prev;
		n.next = tail;
		tail.prev = n;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		int len = length();
		if (index > len)
			return;
		if(index == len) {
			addAtTail(val);
			return;
		}
		Node n = getNode(index);
		Node nPrev = n.prev;
		Node m = new Node(val);
		nPrev.next = m;
		m.prev = nPrev;
		n.prev = m;
		m.next = n;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		int len = length();
		if (index >= len)
			return;
		Node n = getNode(index);
		Node nPrev = n.prev;
		Node next = n.next;
		next.prev = nPrev;
		nPrev.next = next;

	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addAtHead(7);
		list.addAtHead(2);
		list.addAtHead(1);
		list.addAtIndex(3,  0);
		list.deleteAtIndex(2);
		list.addAtHead(6);
		list.addAtTail(4);
		System.out.println(list.get(4));
		list.addAtHead(4);
		list.addAtIndex(5, 0);
		list.addAtHead(6);
	}

	class Node {
		Node prev;
		Node next;
		int val;

		public Node(int value) {
			this.prev = null;
			this.next = null;
			this.val = value;
		}
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
