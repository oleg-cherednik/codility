package cop.codility.maximum_slice;

/**
 * <h1>MaxDoubleSliceSum</h1>
 * <i>Find the maximal sum of any double slice.</i>
 * </p>
 * A non-empty zero-indexed array A consisting of N integers is given.
 * </p>
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a <i>double slice</i>.
 * </p>
 * The <i>sum</i> of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 * </p>
 * For example, array A such that:
 * <pre>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * </pre>
 * contains the following example double slices:
 * <ul>
 * <li>double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,</li>
 * <li>double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,</li>
 * <li>double slice (3, 4, 5), sum is 0.</li>
 * </ul>
 * The goal is to find the maximal sum of any double slice.
 * </p>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the maximal sum of any double slice.
 * </p>
 * For example, given:
 * <pre>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * </pre>
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 * </p>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [3..100,000];</li>
 * <li>each element of array A is an integer within the range [−10,000..10,000].</li>
 * </ul>
 * </p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * </p>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 04.03.2017
 */
public class MaxDoubleSliceSum {
    public static int solution(int[] A) {
        int[][] arr = new int[2][A.length];

        for (int i = 1, j = A.length - 2; i < A.length - 1; i++, j--) {
            arr[0][i] = Math.max(arr[0][i - 1] + A[i], 0);
            arr[1][j] = Math.max(arr[1][j + 1] + A[j], 0);
        }

        int max = 0;

        for (int i = 1; i < A.length - 1; i++)
            max = Math.max(max, arr[0][i - 1] + arr[1][i + 1]);

        return max;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }));
    }
}
