/**
 * <h1>Dominator</h1>
 * <i>Find an index of an array such that its value occurs at more than half of indices in the array.</i>
 * <p/>
 * A zero-indexed array A consisting of N integers is given. The <i>dominator</i> of array A is the value that occurs in more than half of the
 * elements of A.
 * <p/>
 * For example, consider array A such that
 * <pre>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * </pre>
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of
 * 8.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a zero-indexed array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The
 * function should return -1 if array A does not have a dominator.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [0..100,000];</li>
 * <li>each element of array A is an integer within the range [?2,147,483,648..2,147,483,647].</li>
 * </ul>
 * <p/>
 * For example, given array A such that
 * <pre>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * </pre>
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p/>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 07.11.2015
 */
public class Dominator {
    public static int solution(int[] A) {
        int candidate = 0;
        int total = 0;
        int j = 0;

        for (int i = 0; i < A.length; i++) {
            if (total == 0) {
                j = i;
                candidate = A[i];
                total++;
            } else if (candidate == A[i])
                total++;
            else
                total--;
        }

        if (total == 0)
            return -1;

        total = 0;

        for (int val : A)
            if (val == candidate)
                total++;

        return total > A.length / 2 ? j : -1;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[0]));
        System.out.println(solution(new int[] { 3 }));
        System.out.println(solution(new int[] { 3, 4 }));
        System.out.println(solution(new int[] { 2, 3, 4, 3, 2, 3, -1, 3, 3 }));
        System.out.println(solution(new int[] { 3, 4, 3, 2, 3, -1, 3, 5 }));
        System.out.println(solution(new int[] { 2, 1, 1, 3, 4 }));
    }
}

