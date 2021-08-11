package cop.codility.sorting;

import java.util.Arrays;

/**
 * <h1>Triangle</h1>
 * <i>Determine where a triangle can be built from a given set of edges.</i>
 * <p/>
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is <i>triangular</i> if 0 <= P < Q < R, N and:
 * <ul>
 * <li>A[P] + A[Q] > A[R],</li>
 * <li>A[Q] + A[R] > A[P],</li>
 * <li>A[R] + A[P] > A[Q].</li>
 * </ul>
 * For example, array A such that:
 * <pre>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * </pre>
 * Triplet (0, 2, 4) is triangular.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a zero-indexed array A consisting of N integers, return 1 if there exists a triangular triplet for this array and return 0 otherwise.
 * <p/>
 * For example, given array A such that:
 * <pre>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * </pre>
 * the function should return 1, as explained above. Given array A such that.
 * <pre>
 * A[0] = 10    A[1] = 50   A[2] = 5
 * A[3] = 1
 * </pre>
 * the function should return 0.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [0..100,000];</li>
 * <li>each element of array A is an integer within the range [-2,147,483,648..2,147,483,647].</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N*log(N));</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 04.11.2015
 */
public class Triangle {
    public static int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            if ((long) A[i] + A[i + 1] <= A[i + 2])
                continue;
            if ((long) A[i + 1] + A[i + 2] <= A[i])
                continue;
            if ((long) A[i + 2] + A[i] > A[i + 2])
                return 1;
        }

        return 0;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 5 }));
        System.out.println(solution(new int[] { 10, 50, 5, 1 }));
        System.out.println(solution(new int[] { 5, 3, 3 }));
    }
}

