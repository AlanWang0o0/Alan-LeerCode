package LeetCode;

import java.util.Stack;

public class T8 {
    public static void main(String[] args) {
        System.out.println(myAtoi(""));
    }
    public static int myAtoi(String str) {
        str = str.trim();
        int ans = 0;
        int flag = 1;
        int start=0;
        if(str.length()==0){
            return 0;
        }
        if(str.charAt(0) == '-'){   // 符号
            flag = -1;
            start++;
        }
        else if(str.charAt(0) == '+'){    // 正好,不做任何操作
            start++;
        }
        else if(!Character.isDigit(str.charAt(0))){   // 为其他字符,直接跳过
            return 0;
        }
        for (int i = start; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if(Character.isDigit(str.charAt(i))){
                if (ans > (Integer.MAX_VALUE - num) / 10) {
                    // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                    // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                    return flag==-1? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans*10 + num;
            }
            else{
                break;
            }
        }
        return ans*flag;
    }
}
