public class Solution {
	public static void main (String ... args) {
				System.out.println(isSelfCrossing(new int[]{2,1,1,2}));
	}
    public static boolean isSelfCrossing(int[] x) {
        if (x != null & x.length <= 3) {
            return false;
        }
		System.out.println("isSelfCrossing");
        int hpp = 0, wpp = 0, hp = x[0], wp = x[1];
        boolean shrink = false;
        boolean hshrink = false, wshrink = false;
        for (int i = 2; i < x.length; i++) {
            if ( i % 2 == 0) {
                int h = x[i];
                if (h > hp) {
                    if (wshrink) {
						System.out.println("i = " + i);
						System.out.println("x[i] = " + x[i]);
						System.out.println("h = " + h);
						System.out.println("hp = " + hp);
							
						return true;
					}
                    hpp = hp;
                    hp = h;
                } else {
                    hshrink = true;
                    if (wshrink) {
                        if (h >= hp) {
							System.out.println("i = " + i);
							System.out.println("x[i] = " + x[i]);
							System.out.println("h = " + h);
							System.out.println("hp = " + hp);
							
							return true;
						}
                    }
                    if (h + hpp >= hp) {
						if (wp >= wpp) {
							wp = wp-wpp;
						} else {
							wp = wpp;
						}

                        wpp = 0;
                        //wshrink = false;
                    }
                    hpp = hp;
                    hp = h;
                }
            } else {
                int w = x[i];
                if (w > wp) {
					if (hshrink) {						
						System.out.println("i = " + i);
						System.out.println("x[i] = " + x[i]);
						System.out.println("w = " + w);
						System.out.println("wp = " + wp);
						return true;
					}
                    wpp = wp;
                    wp = w;
                } else {
                    wshrink = true;
                    if (hshrink) {
                        if (w >= wp) {
							System.out.println("i = " + i);
							System.out.println("x[i] = " + x[i]);
							System.out.println("w = " + w);
							System.out.println("wp = " + wp);
							
							return true;
						}
                    }
                    if (w + wpp >= wp) {
						if (hp >= hpp) {
							hp = hp-hpp;
						} else {
							hp = hpp;
						}

                        hpp = 0;
                        //hshrink = false;
                    }
                    wpp = wp;
                    wp = w;
                }            
            }
        }
        return false;       
    }
}