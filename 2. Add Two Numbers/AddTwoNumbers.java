/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
	public static void main (String[] str) {
		
	}
	
	class Version1 {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (null == l1) {
				return normalize(l2);
			}
			if (null == l2) {
				return normalize(l1);
			}
			
			int sum = l1.val + l2.val;
			ListNode listNode = new ListNode(sum % 10);
			if (sum >= 10) {
				if (l1.next == null) {
					l1.next = new ListNode(0);
				}
				l1.next.val++;   
			}
			listNode.next = addTwoNumbers(l1.next, l2.next);
			return listNode;
		}
		
		private ListNode normalize (ListNode listNode) {
			if (listNode != null && listNode.val >= 10) {
				listNode.val = listNode.val % 10;
				if (listNode.next == null) {
					listNode.next = new ListNode(0);
				}
				listNode.next.val++;   
				normalize(listNode.next);
			}
			return listNode;
		}
	}
	
	class Version2 {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null) {
				return l2;
			}
			if (l2 == null) {
				return l1;
			}
			ListNode listNode1 = l1;
			ListNode listNode2 = l2;
			boolean flag = false;
		   
			while(true) {
				if (flag) {
					l1.val++;
				}
				l1.val += l2.val;
				flag = l1.val >= 10;
				l1.val = l1.val % 10;
			   
				if (l1.next != null && l2.next != null) {
					l1 = l1.next;
					l2 = l2.next;   
				} else {
					if (l1.next == null) {
						if (l2.next != null) {
							l1.next = l2.next;   
						} else if (flag) {
							l1.next = new ListNode(0);
						}
					}
					l1 = l1.next;
					break;
				}
			}
		   
			while (l1 != null) {
				if (flag) {
					l1.val++;
				}
				flag = l1.val >= 10;
				l1.val = l1.val % 10;
				if (l1.next == null) {
					if (flag) {
						l1.next = new ListNode(0);
					}
				}
				l1 = l1.next;
			}

			return listNode1;
		}
	}

	
}