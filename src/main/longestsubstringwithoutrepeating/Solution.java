package main.longestsubstringwithoutrepeating;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currentLength;

        for (int i = 0; i < s.length(); i++) {
            currentLength = getLength(s, i);

            if (currentLength > maxLength) maxLength = currentLength;
        }
        return maxLength;
    }

    private static int getLength (String string, int position) {
        Set<Character> subStr = new HashSet<>();

        for (int i = position; i < string.length(); i++) {
            if (!subStr.add(string.charAt(i))) break;
        }
        return subStr.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}