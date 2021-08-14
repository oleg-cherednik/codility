import java.util.Arrays;

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
 * @since 13.08.2021
 */
public class CountNonDivisible {

    public static int[] solution(int[] A) {
        int[] count = new int[A.length * 2 + 1];
        int[] sum = new int[A.length * 2 + 1];

        for (int a : A) {
            count[a]++;
            sum[a] = -1;
        }

        for (int a : A) {
            if (sum[a] != -1)
                continue;

            sum[a] = 0;

            for (int i = 1, sqrt = (int)Math.sqrt(a); i <= sqrt; i++)
                if (a % i == 0)
                    sum[a] += count[i] + (a / i != i ? count[a / i] : 0);
        }

        for (int i = 0; i < A.length; i++)
            A[i] = A.length - sum[A[i]];

        return A;
    }

    public static void main(String... args) {
        System.out.println(Arrays.toString(solution(new int[] { 3, 1, 2, 3, 6 }))); // [2, 4, 3, 2, 0]
        System.out.println(Arrays.toString(solution(new int[] { 1, 1 }))); // [0, 0]
        System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 4, 5, 6 }))); // [5, 4, 4, 3, 4, 2]
    }

}
