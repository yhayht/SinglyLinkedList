package singlyLinkedList;

/**
 * Name: Yhayh Thabet 
 * COSC 311 FA19 
 * hw0912 
 * URL: https://github.com/yhayht/SinglyLinkedList.git
 */

public class SinglyLinkedList {

	public class Node {
		int data;
		Node next;

		public Node() {
			this(0, null);
		}

		public Node(int data) {
			this(data, null);
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node n) {
			next = n;
		}
	}

	Node head, tail;

	public SinglyLinkedList() {
		head = tail = null;
	}

	public void insert(int data) {
		Node current = head, previous = head, temp;
		int position = 0;

		while (current != null && current.data < data) {
			previous = current;
			current = current.getNext();
			position++;
		}

		if (position == 0)
			head = new Node(data, head);
		if (tail == null)
			tail = head;
		else if (position > 0) {
			if (head == current) {
				head = current.getNext();
			} else if (current == null) {
				tail.next = new Node(data);
				tail = tail.next;
			} else {
				temp = new Node(data);
				temp.next = previous.next;
				previous.setNext(temp);
			}
		}
	}

	public void delete(int el) {
		if (!isEmpty())
			if (head == tail && el == head.data)
				head = tail = null;
			else if (el == head.data)
				head = head.next;
			else {
				Node p, q;
				for (p = head, q = head.next; q != null && !(q.data == el); p = p.next, q = q.next)
					;
				if (q != null) {
					p.next = q.next;
					if (q == tail)
						tail = p;
				}
			}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public String toString() {
		String s = "";
		if (head == null) {
			return "Empty String";
		}
		for (Node p = head; p != null; p = p.next)
			s += p.data + " ";
		return s;
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		// testing
		list.insert(3);
		list.insert(5);
		System.out.println(list);

		list.insert(2);
		list.insert(2);
		list.insert(2);
		list.insert(7);
		list.insert(6);
		System.out.println("list after inserts: " + list);

		list.delete(2);
		list.delete(5);
		list.delete(7);
		System.out.println("list after deletes: " + list);

		System.out.println("Execution terminated");
	}
}
