package singly_linkelist;

public class SinglyLinkedlist {
	
	Node head;
	
	public class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// add first
	public void addFirst(int data) {
		Node newNode = new Node (data);
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	// add last
	public void addLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		Node currNode = head;
		
		while(currNode.next != null) {
			currNode = currNode.next;
		}
		currNode.next = newNode;
	}
	
	// add insert between
	public void addAtPosition(int position, int data) {
        Node temp = head;
        int cnt = 1;

        while (cnt < position - 1) {
            temp = temp.next;
            cnt++;
        }

        // creating a node for data
        Node nodeToInsert = new Node(data);
        nodeToInsert.next = temp.next;
        temp.next = nodeToInsert;
    }
	
	// deletion First
    public void deleteFirst() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }

        head = head.next;
    }

    // deletion Last Node
    public void deleteLast() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        if(head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;

        while(lastNode.next != null) {
            secondLast = secondLast.next;
            lastNode = lastNode.next;
        }
        secondLast.next = null;
    }

    // deletion at any position
    public void deleteAtPosition(int pos) {
        Node temp = head;
        int count = 1; 

        while(count < pos - 1) {
            temp = temp.next;
            count++;
        }
        Node currNode = temp.next;
        temp.next = currNode.next;
    }
	
	// print
	public void printList() {
		Node currNode = head;
		
		while(currNode != null) {
			System.out.print(currNode.data + "-> ");
			currNode = currNode.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		
		SinglyLinkedlist list = new SinglyLinkedlist();
		
		System.out.println("Insertion Singly Linked list");
		list.addFirst(10);
		list.addFirst(55);
		list.printList();
		
		list.addFirst(5);
		list.printList();
		
		list.addLast(15);
		list.addLast(35);
		list.printList();
		
		list.addAtPosition(3, 2);
		list.printList();
		
		System.out.println("Deletion Singly linked list");

		list.deleteAtPosition(4);
        list.printList();
        
        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();
	}
}
