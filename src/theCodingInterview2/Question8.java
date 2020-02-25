package theCodingInterview2;

public class Question8 {
	public static LinkedListNode FindBeginning(LinkedListNode node) {
		LinkedListNode faster = node;
		LinkedListNode slower = node;
		
		while(faster != null) {
			slower = slower.next;
			faster = faster.next.next;
			
			if(slower == faster)
				break;
		}
		
		if(faster == null) {
			return null;
		}
		
		slower = node;
		
		while(faster != slower) {
			faster = faster.next;
			slower = slower.next;
		}
		
		return faster;
	}
	
	public static void main(String[] args) {
		int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = FindBeginning(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
	}
}
