import java.util.ArrayList;

class Solution {
	public static void main(String ... args) {
		
		for (String s : collectRepeats("aabaacd")) {
			System.out.println(s);
		}
		System.out.println(findLongestRepeats(collectRepeats("aabaacd")));
	}
	
    public String longestPalindrome(String s) {
        return "";
    }
    
    public static ArrayList<String> collectRepeats(String s) {
        ArrayList<String> repeats = new ArrayList();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = i+1;
            while (j < s.length() && c == s.charAt(j)) {
                j++;
            }
            repeats.add(s.substring(i, j));
            i = j-1;
        }
		return repeats;
    }
	
	public static String findLongestRepeats(ArrayList<String> repeats) {
		String maxString = "";
        for(int i = 0; i < repeats.size(); i++) {
			String currentString = repeats.get(i);
			for (int j = 1;; j++) {
				int leftIdx = i-j;
				int	rightIdx = i+j;
				if (leftIdx < 0 || rightIdx >= repeats.size()) break;
				
				String left = repeats.get(leftIdx);
				String right = repeats.get(rightIdx);
				if (!left.equals(right)) {
					if (left.contains(right)) {
						currentString = right + currentString + right;	
					} else if (right.contains(left)) {
						currentString = left + currentString + left;	
					}
					break;
				} else {
					currentString = left + currentString + right;	
				}
			}
			if (currentString.length() > maxString.length()) {
				maxString = currentString;
			}
        }
		return maxString;
    }
}