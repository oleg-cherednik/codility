package cop.codility.sieve_of_eratosthenes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1>CountNonDivisible</h1>
 * <i>Calculate the number of elements of an array that are not divisors of each element.</i>
 * <p/>
 * You are given an array A consisting of N integers.
 * <p/>
 * For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these
 * elements are non-divisors.
 * <p/>
 * For example, consider integer N = 5 and array A such that:
 * <pre>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * </pre>
 * For the following elements:
 * <ul>
 * <li>A[0] = 3, the non-divisors are: 2, 6,</li>
 * <li>A[1] = 1, the non-divisors are: 3, 2, 3, 6,</li>
 * <li>A[2] = 2, the non-divisors are: 3, 3, 6,</li>
 * <li>A[3] = 3, the non-divisors are: 2, 6,</li>
 * <li>A[4] = 6, there aren't any non-divisors.</li>
 * </ul>
 * Write a function:
 * <pre>
 * class Solution { public int[] solution(int[] A); }
 * </pre>
 * that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.
 * <p/>
 * Result array should be returned as an array of integers.
 * <p/>
 * For example, given:
 * <pre>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * </pre>
 * the function should return [2, 4, 3, 2, 0], as explained above.
 * <p/>
 * Write an <b>efficient</b> algorithm for the following assumptions:
 * <ul>
 * <li>N is an integer within the range [1..50,000];</li>
 * <li>each element of array A is an integer within the range [1..2 * N].</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 26.12.2018
 */
public class CountNonDivisible {

    public static int[] solution(int[] A) {
        int[][] D = new int[A.length * 2 + 1][2];

        for (int i = 0; i < A.length; i++) {
            D[A[i]][0]++;
            D[A[i]][1] = -1;
        }

        for (int i = 0; i < A.length; i++) {
            if (D[A[i]][1] == -1) {
                D[A[i]][1] = 0;
                for (int j = 1; j <= Math.sqrt(A[i]); j++) {
                    if (A[i] % j == 0 && A[i] / j != j) {
                        D[A[i]][1] += D[j][0];
                        D[A[i]][1] += D[A[i] / j][0];
                    } else if (A[i] % j == 0 && A[i] / j == j) {
                        D[A[i]][1] += D[j][0];
                    }
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A.length - D[A[i]][1];
        }
        return A;
    }

    // --------------
    public static int[] solution1(int[] A) {
        Map<Integer, Integer> histogram = histogram(A);
        Map<Integer, Integer> cache = new HashMap<>();
        int[] res = new int[A.length];

        for (int i = 0; i < A.length; i++)
            res[i] = cache.computeIfAbsent(A[i], a -> {
                int sum = 0;

                for (int div : divisors(a))
                    sum += histogram.get(div);

                return A.length - sum;
            });

        return res;
    }

    private static Map<Integer, Integer> histogram(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A)
            map.put(a, map.getOrDefault(a, 0) + 1);

        return map;
    }

    private static Set<Integer> divisors(int a) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cache = new HashSet<>();

        while (a > 1) {
            for (int i = 2; i <= a; i++) {
                if (a % i != 0)
                    continue;

                cache.clear();
                cache.addAll(res);

                for (int v : cache)
                    res.add(i * v);

                res.add(i);
                a /= i;

                break;
            }
        }

        res.add(1);

        return res;
    }

    public static void main(String... args) {
//        Random random = new Random();
//        int N = 50_000;//random.nextInt(50_000);
//        int[] arr = new int[N];
//
//        for (int i = 0; i < arr.length; i++)
//            arr[i] = random.nextInt(2 * N);
//
//        System.out.println(arr.length);
//        System.out.println(Arrays.toString(arr));


        System.out.println(Arrays.toString(solution(new int[] { 3, 1, 2, 3, 6 }))); // [2, 4, 3, 2, 0]
        System.out.println(Arrays.toString(solution(new int[] { 1, 1 }))); // [0, 0]
        System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 4, 5, 6 }))); // [5, 4, 4, 3, 4, 2]
    }

}
