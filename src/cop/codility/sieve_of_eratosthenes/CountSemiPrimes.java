package cop.codility.sieve_of_eratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 23.12.2018
 */
public class CountSemiPrimes {

    private static List<Integer> getPrimes(int max) {
        List<Integer> primes = new ArrayList<>(max / 2);

        for (int i = 0; i < max; i++)
            if (isPrime(i))
                primes.add(i);

        return primes;
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

    private static boolean[] getSemiPrimes(int N) {
        List<Integer> primes = getPrimes(N);
        boolean[] semiPrimes = new boolean[N + 1];

        for (int i = 0; i < primes.size(); i++) {
            for (int j = 0; j < primes.size(); j++) {
                int semiPrime = primes.get(i) * primes.get(j);

                if (semiPrime > N)
                    break;

                semiPrimes[semiPrime] = true;
            }
        }

        return semiPrimes;
    }

    public static int[] solution(int N, int[] P, int[] Q) {
        boolean[] semiPrimes = getSemiPrimes(N);
        int[] res = new int[P.length];

        for (int i = 0; i < res.length; i++)
            for (int j = P[i]; j <= Q[i]; j++)
                if (semiPrimes[j])
                    res[i]++;

        return res;
    }

    public static void main(String... args) {
        System.out.println(Arrays.toString(solution(26, new int[] { 1, 4, 16 }, new int[] { 26, 10, 20 }))); // [10, 4, 0]
    }

}
