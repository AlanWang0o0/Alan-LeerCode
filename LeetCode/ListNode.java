package LeetCode;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x){
        this.val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
