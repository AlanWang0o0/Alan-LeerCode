package LeetCode;

import java.util.Arrays;

public class T0201_Remove_Duplicate_Node_LCCI {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        System.out.println(removeDuplicateNodes(a));
    }

    public static ListNode removeDuplicateNodes(ListNode head){
        if(head == null || head.next==null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        int[] a = new int[20001];
        a[head.val] += 1;
        while(cur != null){
            if(a[cur.val]!=0){
                a[cur.val] += 1;
                pre.next = cur.next;
                cur = pre.next;
            }
            else{
                a[cur.val] += 1;
                pre = cur;
                cur = pre.next;
            }

        }
        return head;
    }
}
