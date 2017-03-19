package cop.codility.maximum_slice;

/**
 * <h1>MaxSliceSum</h1>
 * <i>Find a maximum sum of a compact subsequence of array elements.</i>
 * </p>
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array
 * A. The <i>sum</i> of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 * </p>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 * </p>
 * For example, given array A such that:
 * <pre>
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * </pre>
 * the function should return 5 because:
 * <ul>
 * <li>(3, 4) is a slice of A that has sum 4,</li>
 * <li>(2, 2) is a slice of A that has sum −6,</li>
 * <li>(0, 1) is a slice of A that has sum 5,</li>
 * <li>no other slice of A has sum greater than (0, 1).</li>
 * </ul>
 * </p>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..1,000,000];</li>
 * <li>each element of array A is an integer within the range [−1,000,000..1,000,000];</li>
 * <li>the result will be an integer within the range [−2,147,483,648..2,147,483,647].</li>
 * </ul>
 * </p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 18.03.2017
 */
public class MaxSliceSum {
    public static int solution(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int a : A) {
            sum = Math.max(sum + a, a);
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { -10 }));
        System.out.println(solution(new int[] { 3, 2, -6, 4, 5, -20, 8, 4 }));
        System.out.println(solution(new int[] { 3, 2, -6, 4, 0 }));
    }
}
