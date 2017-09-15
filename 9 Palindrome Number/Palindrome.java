class Palindrome {
	public static void main (String ... args) {
		int n = -121;
		System.out.println("isPalindromeC(" + n + ")" + isPalindrome(n));
	}	
	public static boolean isPalindrome(int x) {
		if (x < 0) return false;
		
		int newX = x;
		int newY = 0;
		while(newX != 0) {
			newY = newY*10 + newX%10;
            newX = newX/10;
			
		}
		return newY == x;
    }
}