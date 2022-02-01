package com.ahmet;

public class Main {
    public static void main(String[] args) {
        int num = trailingZeroes(125);
        System.out.println(num);
    }
//*********RECURSION***************
//    Trailing zeroes in factorial
//For an integer N find the number of trailing zeroes in N!.
//
//    Example 1:
//
//    Input:
//    N = 5
//    Output:
//            1
//    Explanation:
//            5! = 120 so the number of trailing zero is 1.
//    Example 2:
//
//    Input:
//    N = 4
//    Output:
//            0
//    Explanation:
//            4! = 24 so the number of trailing zero is 0.
    static int trailingZeroes(int N){
        if(N==0) return 0;
        return N/5 + trailingZeroes(N/5);
    }

    //*********RECURSION***************


}

//Given two strings s and t, return true if s is a subsequence of t, or false
//otherwise.
//
// A subsequence of a string is a new string that is formed from the original
//string by deleting some (can be none) of the characters without disturbing the
//relative positions of the remaining characters. (i.e., "ace" is a subsequence of
//"abcde" while "aec" is not).
//
//
// Example 1:
// Input: s = "abc", t = "ahbgdc"
//Output: true
// Example 2:
// Input: s = "axc", t = "ahbgdc"
//Output: false
//
//
// Constraints:
//
//
// 0 <= s.length <= 100
// 0 <= t.length <= 10⁴
// s and t consist only of lowercase English letters.
//
//
//
//Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >
//= 10⁹, and you want to check one by one to see if t has its subsequence. In
//this scenario, how would you change your code? Related Topics Two Pointers String
//Dynamic Programming 👍 3609 👎 268


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {

        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
        System.out.println("Hey");
    }
    public static boolean isSubsequence(String s, String t) {
        if(t.length()<s.length()) return false;
        if(s.length() == 0) return true;
        int tIndex = 0;
        int sIndex=0;

        while(tIndex < t.length()){
            if(t.charAt(tIndex) == s.charAt(sIndex)){
                sIndex++;
                if(sIndex == s.length()) return true;
            }
            tIndex++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

