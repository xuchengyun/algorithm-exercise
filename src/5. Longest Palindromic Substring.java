// time complexity(O^2)

class Solution {
    int maxLen, start;
    public String longestPalindrome(String s) {
        maxLen = Integer.MIN_VALUE;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // should distinguish odd length and even length
            searchPalindrome(s, i, i); 
            searchPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }
    
    private void searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left -1) {
            maxLen = right - left - 1;
            start = left + 1;
        }
    }
}