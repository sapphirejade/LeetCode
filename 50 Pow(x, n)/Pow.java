class Pow {
    public static void main (String[] str) {
        //System.out.println(myPow(2.0, -2147483648));
		System.out.println(Math.sqrt(-2147483648));
    }
    public static double myPow(double x, int n) {
        if (x == 1.0) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        if (n == 1) {
            return x;
        }
        
        int greatDivider = findGreatDivider(n);
        if (greatDivider == 1) {
            return x * myPow(x, n-1);
        } else {
            return myPow(myPow(x, greatDivider), n / greatDivider);
        }
    }
    
    private static int findGreatDivider(int n) {
        System.out.println(n);
        int candidate  = (int) Math.sqrt(n);
        while (true) {
            if (n % candidate == 0) {
                return candidate;
            }
            candidate--;
        }
    }
}