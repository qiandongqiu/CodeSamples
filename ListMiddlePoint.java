package test;

//Given a non-empty, singly linked list with head node head, return a middle node of linked list.
//If there are two middle nodes, return the second middle node.
/*
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
*/
public class ListMiddlePoint {
	public static ListNode middleNode(ListNode head) {
		if(head==null) return null;
		
		ListNode faster, slower;
		faster=head;
		slower=head;
		
		while(slower.next!=null && (faster.next!=null && faster.next.next !=null) ) {
			slower=slower.next;
			faster = faster.next.next;
		}
		
		if(faster.next!=null && faster.next.next==null) {
			return slower.next;
		}
		return slower;
	}
	
	static void print(ListNode node) {
		ListNode tmp=node;
		while(tmp!=null) {
			System.out.print(tmp.val+" ");
			tmp=tmp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next  = new ListNode(3);
		head.next.next.next  = new ListNode(4);
		head.next.next.next.next  = new ListNode(5);
		head.next.next.next.next.next  = new ListNode(6);
		
		//System.out.println(middleNode(head));
		ListNode middle = middleNode(head);
		print(middle);
	}

}
