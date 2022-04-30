package HW1;

import java.util.*;

public class MergedList {
    public static void main(String[] args) {

//        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode list2 = new ListNode(1,new ListNode(3, new ListNode(5)));

        ListNode list1 = new ListNode(0, new ListNode(1, new ListNode(4, new ListNode(-2))));
        ListNode list2 = new ListNode(5);

//        System.out.println(new Solution().mergeTwoLists(list1,list2).toString());
        System.out.println(new MergedList().reverseList(list1).toString());
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;

        if(list1 == null) return list2;

        if(list2 == null) return list1;

        ListNode temp = null;

        PriorityQueue <Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        while (list1 != null) {
            queue.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            queue.add(list2.val);
            list2 = list2.next;
        }

        while (!queue.isEmpty()){
            temp = new ListNode(queue.poll(),temp);
        }
        return temp;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode headRev = null;

        Deque <Integer> stack = new ArrayDeque<>();

        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            headRev = new ListNode(stack.pop(), headRev);
        }
        return headRev;
    }

}









