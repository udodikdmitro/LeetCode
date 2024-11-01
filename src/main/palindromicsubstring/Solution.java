package main.palindromicsubstring;

public class Solution {
    public String longestPalindrome(String s) {
        String result = String.valueOf(s.charAt(0));
        StringBuilder sb = new StringBuilder();
        StringBuilder revSb = new StringBuilder();

        if (s.length() == 1) {return s;}

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            revSb.append(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));
                revSb.append(s.charAt(j));
                revSb.reverse();

                if (sb.compareTo(revSb) == 0 && sb.toString().length() > result.length()) {
                    result = sb.toString();
                }
                revSb.reverse();
            }

            sb.delete(0, sb.length());
            revSb.delete(0, revSb.length());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));

        String s1 = "cbbd";
        System.out.println(solution.longestPalindrome(s1));

        String s2 = "bb";
        System.out.println(solution.longestPalindrome(s2));

        String s3 = "ac";
        System.out.println(solution.longestPalindrome(s3));

        String s4 = "aacabdkacaa";
        System.out.println(solution.longestPalindrome(s4));
    }
}