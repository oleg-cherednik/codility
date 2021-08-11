package cop.codility.leader;

/**
 * <h1>EquiLeader</h1>
 * <i>Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.</i>
 * <p/>
 * A non-empty zero-indexed array A consisting of N integers is given.
 * <p/>
 * The <i>leader</i> of this array is the value that occurs in more than half of the elements of A.
 * <p/>
 * An <i>equi leader</i> is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have
 * leaders of
 * the same value.
 * <p/>
 * For example, given array A such that:
 * <pre>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * </pre>
 * we can find two equi leaders:
 * <ul>
 * <li>0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.</li>
 * <li>2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.</li>
 * </ul>
 * The goal is to count the number of equi leaders.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the number of equi leaders.
 * <p/>
 * For example, given:
 * <pre>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * </pre>
 * the function should return 2, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..100,000];</li>
 * <li>each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].</li>
 * </ul>
 * <p/>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * <p/>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 03.03.2017
 */
public class EquiLeader {
    public static int solution(int[] A) {
        int candidate = 0;
        int total = 0;

        for (int i = 0; i < A.length; i++) {
            if (total == 0) {
                candidate = A[i];
                total++;
            } else if (candidate == A[i])
                total++;
            else
                total--;
        }

        if (total == 0)
            return 0;

        int[][] arr = new int[2][A.length];

        for (int i = 0, j = A.length - 1; i < A.length; i++, j--) {
            if (A[i] == candidate)
                arr[0][i] = 1 + (i == 0 ? 0 : Math.abs(arr[0][i - 1]));
            else
                arr[0][i] = i == 0 ? 0 : Math.abs(arr[0][i - 1]);

            if (arr[0][i] * 2 <= i + 1)
                arr[0][i] = -arr[0][i];

            if (A[j] == candidate)
                arr[1][j] = 1 + (i == 0 ? 0 : Math.abs(arr[1][j + 1]));
            else
                arr[1][j] = i == 0 ? 0 : Math.abs(arr[1][j + 1]);

            if (arr[1][j] * 2 <= i + 1)
                arr[1][j] = -arr[1][j];
        }

        int res = 0;

        for (int i = 0; i < A.length - 1; i++)
            if (arr[0][i] > 0 && arr[1][i + 1] > 0)
                res++;

        return res;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 4, 3, 4, 4, 4, 2 }));   // 2
    }
}
