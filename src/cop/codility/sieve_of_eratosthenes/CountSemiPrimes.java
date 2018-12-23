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

    private static int[] getSemiPrimesPrefixSum(int N) {
        List<Integer> primes = getPrimes(N);
        int[] semiPrimes = new int[N + 1];

        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) > N)
                break;

            for (int j = i; j < primes.size(); j++) {
                if (primes.get(j) > N || N / primes.get(i) < primes.get(j))
                    break;

                int semiPrime = primes.get(i) * primes.get(j);

                if (semiPrime <= N)
                    semiPrimes[semiPrime] = 1;
            }
        }

        for (int i = 0, cur = 0; i < semiPrimes.length; i++)
            semiPrimes[i] = cur += semiPrimes[i];

        return semiPrimes;
    }

    public static int[] solution(int N, int[] P, int[] Q) {
        int[] semiPrimes = getSemiPrimesPrefixSum(N);
        int[] res = new int[P.length];

        for (int i = 0; i < res.length; i++)
            res[i] = semiPrimes[Q[i]] - semiPrimes[P[i] - 1];

        return res;
    }

    public static void main(String... args) {
        System.out.println(Arrays.toString(solution(26, new int[] { 1, 4, 16 }, new int[] { 26, 10, 20 }))); // [10, 4, 0]
    }

}
