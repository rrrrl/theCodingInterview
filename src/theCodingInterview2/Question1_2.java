package theCodingInterview2;

import theCodingInterview2.LinkedListNode;

public class Question1_2 {
	public static void deleteDups(LinkedListNode head) {
		LinkedListNode curr = head;
		while(curr != null) {
			LinkedListNode runner = curr;
			while(runner.next != null) {
				if(runner.next.data == curr.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
	}	
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 3, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
	}
}
