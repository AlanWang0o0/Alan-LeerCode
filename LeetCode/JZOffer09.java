package LeetCode;

import java.util.LinkedList;

// 用两个栈实现一个队列
public class JZOffer09 {
    public static void main(String[] args){
         CQueue obj = new CQueue();
         obj.appendTail(3);
         System.out.println(obj.deleteHead());
         System.out.println(obj.deleteHead());
    }
}

class CQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }
        else return stack2.pop();
    }
}
