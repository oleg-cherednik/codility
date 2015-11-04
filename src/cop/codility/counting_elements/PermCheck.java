package cop.codility.counting_elements;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>PermCheck</h1>
 * <i>Check whether array A is a permutation.</i><br>
 * <br>
 * A non-empty zero-indexed array A consisting of N integers is given.<br>
 * A <i>permutation</i> is a sequence containing each element from 1 to N once, and only once.
 * <p/>
 * For example, array A such that:
 * <pre>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * </pre>
 * is a permutation, but array A such that:
 * <pre>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * </pre
 * is not a permutation, because value 2 is missing.<br>
 * The goal is to check whether array A is a permutation.
 *
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p/>
 * For example, given array A such that:
 * <pre>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * </pre>
 * the function should return 1.
 * <p/>
 * Given array A such that:
 * <pre>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * </pre>
 * the function should return 0.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..100,000];</li>
 * <li>each element of array A is an integer within the range [1..1,000,000,000].</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 13.10.2015
 */
public class PermCheck {
    public static int solution(int[] A) {
        int N = 0;
        Set<Integer> positions = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            N = Math.max(N, A[i]);

            if (!positions.add(A[i]))
                return 0;
        }

        return positions.size() == N ? 1 : 0;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 4, 1, 3, 2 }));
        System.out.println(solution(new int[] { 4, 1, 3 }));
    }
}

