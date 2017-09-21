class Solution {    
    public int lengthOfLongestSubstring (String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        for (int window = findWindowSize(s); window > 1; window--) {
            for (int index = 0; index+window <= s.length(); index++) {
                if (!hasDuplicate(s.substring(index, index+window))) {
                    return window;
                }
            }
        }
        return 1;
    }
    private int findWindowSize(String s) {
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            set.add(c);
        }
        return set.size();
    }
    private boolean hasDuplicate (String s) {
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            if (set.contains(c)) {
                return true;
            } else {
                set.add(c);
            }
        }
        return false;
    }
}