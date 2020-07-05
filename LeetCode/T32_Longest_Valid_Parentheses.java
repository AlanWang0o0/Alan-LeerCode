package LeetCode;

import java.util.Stack;

public class T32_Longest_Valid_Parentheses {
    public static void main(String[] args){
        System.out.println(longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(()"));

    }
    // 动态规划
//    public static int longestValidParentheses(String s) {
//        int maxans = 0;
//        int[] dp = new int[s.length()];
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i - 1) == '(') {
//                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//                }
//                maxans = Math.max(maxans, dp[i]);
//            }
//        }
//        return maxans;
//    }
    // 栈
    public static int longestValidParentheses(String s) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){   // 左括号
                stack.push(i);
            }
            else {       // 右括号
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);  // 弹栈后为空，则将当前下表入栈
                } else {
                    max = Math.max(max, i - stack.peek()); // 弹栈后不为空，更新值
                }
            }
        }
        return max;
    }
}
