class FirstBadVersion {
	public static void main (String ... args) {
		System.out.println(Integer.parseInt("-012"));
		System.out.println(firstBadVersion(3));		
		//firstBadVersion(2126753390);
		
	}
	
	public static int firstBadVersion(int n) {
        long x = 1, y = n;
        while (true) {
            if (x == y) return (int) x;
            if (Math.abs(x-y) == 1) {
                if (isBadVersion((int)x)) return (int) x;
                if (isBadVersion((int)y)) return (int) y;
            }
			System.out.println("x = " + x + ",y = " + y);		
			System.out.println(x/2 + y/2);
            if (isBadVersion((int)(x/2 + y/2))) {
				
                y = (x + y) / 2;
                // if ((x+y) % 2 != 0) {
                //     y++;
                // }
            } else {
                x = (x + y) / 2;
                // if ((x+y) % 2 != 0) {
                //     x++;
                // }
            }
			try{System.in.read();
			}catch(Exception e){}
        }
    }

	public static boolean isBadVersion(int n) {
		return n >= 2;
		//return n >= 11;
	}
}