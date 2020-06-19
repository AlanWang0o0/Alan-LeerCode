package LeetCode;

public class T125 {
    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }


    // 双指针
//    public static boolean isPalindrome(String s) {
//        if (s == null || s.length() == 0)
//            return true;
//        s = s.toLowerCase();   // 全部转换为小写
//        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))    // 只考虑字母或数字
//                i++;
//            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
//                j--;
//            if (s.charAt(i) != s.charAt(j))
//                return false;
//        }
//        return true;
//    }
    // 正则 + reverse
    public static boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

}
