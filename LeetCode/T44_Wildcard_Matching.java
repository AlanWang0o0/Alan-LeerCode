package LeetCode;

public class T44_Wildcard_Matching {
    public static void main(String[] args){
        System.out.println(isMatch("adceb","*a*b"));
    }
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        int lens = s.length(), lenp = p.length();

        dp[0][0] = true;

        for (int i = 1; i < lenp+1; i++) {  // p中开头的 * 可以匹配空字符串
            if(p.charAt(i-1) == '*')  dp[i][0] = true;
            else break;
        }
        for (int i = 1; i < lenp+1; i++) {
            for (int j = 1; j < lens+1; j++) {
                if(p.charAt(i-1) == '*'){   // p当前为 *
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else if(p.charAt(i-1) == '?'){   // p当前为 ？
                    dp[i][j] = dp[i-1][j-1];
                }
                else{    // p当前为字母
                    if(s.charAt(j-1) == p.charAt(i-1)){     // p的字母和s的字母相同
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[lenp][lens];
    }
}
