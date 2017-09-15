public class Solution {
	public static void main (String args[]) {
		System.out.println(reverseBits(2));
	}
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        long sum = 0;
        for (int i = 0; i <= 32; i++) {
			System.out.println(n >>> i);
            sum+= (n>>>i);
        }
        return (int) sum;
    }
}