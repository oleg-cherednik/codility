package cop.codility.time_complexity;

/**
 * <h1>TapeEquilibrium</h1>
 * <i>Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.</i><br>
 * <br>
 * A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.<br>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P?1] and A[P], A[P+1], ..., A[N?1].<br>
 * The <i>difference</i> between the two parts is the value of: |(A[0] + A[1] + ... + A[P?1]) ? (A[P] + A[P+1] + ... + A[N?1])|<br>
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * <p/>
 * For example, consider array A such that:
 * <pre>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * </pre>
 * We can split this tape in four places:
 * <ul>
 * <li>P = 1, difference = |3?10| = 7</li>
 * <li>P = 2, difference = |4?9| = 5</li>
 * <li>P = 3, difference = |6?7| = 1</li>
 * <li>P = 4, difference = |10?3| = 7</li>
 * </ul>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.
 * <p/>
 * For example, given:
 * <pre>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * </pre>
 * the function should return 1, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [2..100,000];</li>
 * </li>each element of array A is an integer within the range [?1,000..1,000].</li>
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
public class TapeEquilibrium {
    public static int solution(int[] A) {
        int length = A.length;
        int[][] arr = new int[2][length];

        for (int i = 0, j = A.length - 1; i < length; i++, j--) {
            arr[0][i] = A[i] + (i == 0 ? 0 : arr[0][i - 1]);
            arr[1][j] = A[j] + (j == length - 1 ? 0 : arr[1][j + 1]);
        }

        int diff = Integer.MAX_VALUE;

        for (int i = 1; i < length; i++)
            diff = Math.min(diff, Math.abs(arr[0][i - 1] - arr[1][i]));

        return diff;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 3, 1, 2, 4, 3 }));
    }
}

