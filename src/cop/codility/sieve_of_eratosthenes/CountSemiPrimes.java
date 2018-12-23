package cop.codility.sieve_of_eratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 23.12.2018
 */
public class CountSemiPrimes {

    private static Set<Integer> semiPrimes = getSemiPrimes();

    private static Set<Integer> getSemiPrimes() {
        final int max = 50_000;
        int[] primes = getPrimes(max);
        Set<Integer> semiPrimes = new HashSet<>();

        for (int i = 0; i < primes.length && primes[i] <= max; i++)
            for (int j = 0; j < primes.length && primes[i] * primes[j] <= max; j++)
                semiPrimes.add(primes[i] * primes[j]);

        return semiPrimes;
    }

    private static int[] getPrimes(int max) {
        List<Integer> primes = new ArrayList<>(max / 2);

        for (int i = 0; i < max; i++)
            if (isPrime(i))
                primes.add(i);

        return primes.stream().mapToInt(i -> i).toArray();
    }

    private static boolean isPrime(int val) {
        if (val <= 1)
            return false;
        if (val <= 3)
            return true;

        for (int i = 2, sqrt = (int)Math.sqrt(val); i <= sqrt; i++)
            if (val % i == 0)
                return false;

        return true;
    }

    public static int[] solution(int N, int[] P, int[] Q) {
        int[] res = new int[P.length];

        for (int i = 0; i < res.length; i++) {
            final int j = i;
            res[i] = (int)semiPrimes.stream().filter(semiPrime -> semiPrime >= P[j] && semiPrime <= Q[j]).count();
        }

        return res;
    }


    public static void main(String... args) {
        System.out.println(Arrays.toString(solution(26, new int[] { 1, 4, 16 }, new int[] { 26, 10, 20 }))); // [10, 4, 0]
    }

}
