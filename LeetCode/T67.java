package LeetCode;

public class T67 {
    public static void main(String[] args){
        System.out.println(addBinary("1010","1011"));
    }

    // 从低位开始加，逢二进一
    public static String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        int len = Math.max(a.length(),b.length());
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int temp=carry;
            if(i<a.length()) temp += (a.charAt(a.length()-1-i)-'0');
            else    temp += 0;
            if(i<b.length()) temp += (b.charAt(b.length()-1-i)-'0');
            else    temp += 0;

            carry = temp>1?1:0;
            res.append(temp%2);
        }
        if(carry==1)    res.append(1);
        return res.reverse().toString();
    }

    //
}
