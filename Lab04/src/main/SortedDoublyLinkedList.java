package main;

public class SortedDoublyLinkedList implements LinkedList{
	class Node{
		Warrior warrior;
		Node prev;
		Node next;
		
		public Node (Warrior warrior) {
			this.warrior=warrior;
		}
	}
	public void sort() {
		Node current = head, index = null;
		Warrior temp;
		if (head == null) {
			return;
		}
		else {
			while (current != null) {
				index = current.next;
				while (index != null) {
					if (current.warrior.getSpeed()<index.warrior.getSpeed()) {
						temp = current.warrior;
						current.warrior=index.warrior;
						index.warrior=temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}
	public Node head=null, tail=null;//init
	public void insert(Warrior warrior) {
		Node newnode = new Node(warrior);
		
		if (head==null) {
			head = tail = newnode;
			//both next and prev are null
			head.prev=null;
			head.next=null;
		}
		else {
			tail.next=newnode;//to set newnode to end of the list turn tail into newnode
			newnode.prev=tail;
			tail=newnode;//newnode becomes tail
			tail.next=null;//next is null
		}
		sort();
	}
	
	public String toString() {
		Node current = head;
		if (head == null) {
			System.out.print("Empty and also your mother");
			return "";
		}
		System.out.print("[ ");
		while (current != null) {
			System.out.print(current.warrior+" ");
			current = current.next;
		}
		return "]";
	}

}

/*
 
*/