
public class Solution {
	public static void main (String ... args) {
		ListNode head=null;
		ListNode tail = new ListNode(8);
		for (int i = 7; i > 0; i--) {
			ListNode node = new ListNode(i);
			node.next = tail;
			tail = node;
			if (i == 1) {
				head = node;
			}
		}
		ListNode s = head;
		while (s != null){
			System.out.println(s.val);
			s = s.next;
		}
		System.out.println();
		oddEvenList(head);
	}
    public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddTail = head;        
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;
        while (evenTail!=null&&evenTail.next!=null) {
            oddTail.next=evenTail.next;
            evenTail.next=oddTail.next.next;
            oddTail = oddTail.next;
            evenTail = evenTail.next;
        }
        oddTail.next = evenHead;
        return head;
    }
	public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}