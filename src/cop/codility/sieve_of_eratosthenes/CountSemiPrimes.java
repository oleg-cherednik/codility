package cop.codility.sieve_of_eratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>CountSemiprimes</h1>
 * <i>Count the semiprime numbers in the given range [a..b]</i>
 * <p/>
 * A <i>prime</i> is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <p/>
 * A <i>semiprime</i> is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14,
 * 15, 21, 22, 25, 26.
 * <p/>
 * You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within
 * specified ranges.
 * <p/>
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 * <p/>
 * For example, consider an integer N = 26 and arrays P, Q such that:
 * <pre>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * </pre>
 * The number of semiprimes within each of these ranges is as follows:
 * <ul>
 * <li>(1, 26) is 10,</li>
 * <li>(4, 10) is 4,</li>
 * <li>(16, 20) is 0.</li>
 * </ul>
 * Write a function:
 * <pre>
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 * </pre>
 * that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the
 * consecutive answers to all the queries.
 * </p>
 * For example, given an integer N = 26 and arrays P, Q such that:
 * <pre>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * </pre>
 * the function should return the values [10, 4, 0], as explained above.
 * </p>
 * Write an efficient algorithm for the following assumptions:
 * <ul>
 * <li>N is an integer within the range [1..50,000];</li>
 * <li>M is an integer within the range [1..30,000];</li>
 * <li>each element of arrays P, Q is an integer within the range [1..N];</li>
 * <li>P[i] ≤ Q[i].</li>
 * </ul>
 *
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
