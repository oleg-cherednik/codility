package cop.codility.maximum_slice;

/**
 * <h1>MaxProfit</h1>
 * <i>Given a log of stock prices compute the maximum possible earning.</i>
 * </p>
 * A zero-indexed array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a
 * single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the <i>profit</i> of such transaction is equal to A[Q] − A[P],
 * provided that A[Q] ≥ A[P]. Otherwise, the transaction brings <i>loss</i> of A[P] − A[Q].
 * </p>
 * For example, consider the following array A consisting of six elements such that:
 * <pre>
 * A[0] = 23171
 * A[1] = 21011
 * A[2] = 21123
 * A[3] = 21366
 * A[4] = 21013
 * A[5] = 21367
 * </pre>
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on
 * day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if
 * a share was bought on day 1 and sold on day 5.
 * </p>
 * Write a function,
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a zero-indexed array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns
 * the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.
 * </p>
 * For example, given array A consisting of six elements such that:
 * <pre>
 * A[0] = 23171
 * A[1] = 21011
 * A[2] = 21123
 * A[3] = 21366
 * A[4] = 21013
 * A[5] = 21367
 * </pre>
 * the function should return 356, as explained above.
 * </p>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [0..400,000];</li>
 * <li></li>each element of array A is an integer within the range [0..200,000].</li>
 * </ul>
 * </p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * </p>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 18.03.2017
 */
public class MaxProfit {
    public static int solution(int[] A) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int a : A) {
            max = Math.max(max, a);
            res = Math.max(res, a - min);
            min = Math.min(min, a);
        }

        return res;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 23171, 21011, 21123, 21366, 21013, 21367 }));
    }
}
