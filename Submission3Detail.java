public class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String result = "";
        
        // Try all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (isNice(sub) && sub.length() > result.length()) {
                    result = sub;
                }
            }
        }
        
        return result;
    }
    
    private boolean isNice(String s) {
        boolean[] seenLower = new boolean[26];
        boolean[] seenUpper = new boolean[26]; 
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                seenLower[c - 'a'] = true;
            } else {
                seenUpper[c - 'A'] = true;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (seenLower[i] && !seenUpper[i]) {
                return false;
            }
            if (seenUpper[i] && !seenLower[i]) {
                return false;
            }
        }
        
        return true;
    }
}
