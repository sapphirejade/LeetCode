public class Solution {
    private HashSet<Integer> uglys = new HashSet<>();
    private void initUglys(int[] primes) {
		uglys.clear();
		uglys.add(1);
		for (int prime: primes) {
			uglys.add(prime);
		}
	}
    public int nthSuperUglyNumber(int n, int[] primes) {
        initUglys(primes);
        int currentUgly = 1, ith = 1;
        while (ith < n) {
            currentUgly = findNextUglyNumber(currentUgly, primes);
            ith++;
        }
        return currentUgly;
    }
    private int findNextUglyNumber(int currentUgly, int[] primes) {
        int candidate = currentUgly;
        while(true) {
            if (primes[0] == 2) {
                candidate++;
            } else {
                candidate+=2;
            }
            if (isUglyNumber(candidate, primes)) return candidate;
        }
    }
    private boolean isUglyNumber(int number, int[] primes) {
        if (number == 1) return true;
        for (int prime : primes) {
            if ((number % prime == 0) && uglys.contains(number/prime)) {
                uglys.add(number);
                return true;
            }
        }
        return false;
    }
}