package cop.codility.binary_search_algorithm;

/**
 * <h1>MinMaxDivision</h1>
 * <i>Divide array A into K blocks and minimize the largest sum of any block.</i>
 * <p/>
 * You are given integers K, M and a non-empty zero-indexed array A consisting of N integers. Every element of the array is not greater than M.
 * <p/>
 * You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the
 * array should belong to some block.
 * <p/>
 * The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.
 * <p/>
 * The <i>large sum</i> is the maximal sum of any block.
 * <p/>
 * For example, you are given integers K = 3, M = 5 and array A such that:
 * <pre>
 * A[0] = 2
 * A[1] = 1
 * A[2] = 5
 * A[3] = 1
 * A[4] = 2
 * A[5] = 2
 * A[6] = 2
 * </pre>
 * The array can be divided, for example, into the following blocks:
 * <pre>
 * [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
 * [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
 * [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
 * [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
 * </pre>
 * The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int K, int M, int[] A); }
 * </pre>
 * that, given integers K, M and a non-empty zero-indexed array A consisting of N integers, returns the minimal large sum.
 * <p/>
 * For example, given K = 3, M = 5 and array A such that:
 * <pre>
 * A[0] = 2
 * A[1] = 1
 * A[2] = 5
 * A[3] = 1
 * A[4] = 2
 * A[5] = 2
 * A[6] = 2
 * </pre>
 * the function should return 6, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N and K are integers within the range [1..100,000];</li>
 * <li>M is an integer within the range [0..10,000];</li>
 * </ul>
 * each element of array A is an integer within the range [0..M].
 * </p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N*log(N+M));</li>
 * <li>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 17.03.2017
 */
public class MinMaxDivision {
    public static int solution(int K, int M, int[] A) {
        int max = 0;
        int sum = 0;

        for (int a : A) {
            max = Math.max(max, a);
            sum += a;
        }

        int res = sum;
        int beg = max;
        int end = sum;

        while (beg <= end) {
            int mid = (beg + end) / 2;

            if (check(mid, K, A)) {
                res = mid;
                end = mid - 1;
            } else
                beg = mid + 1;
        }

        return res;
    }

    private static boolean check(int num, int K, int[] A) {
        int sum = 0;

        for (int a : A) {
            if (a > num)
                return false;

            sum += a;

            if (sum > num) {
                sum = a;

                if (--K == 0)
                    return false;
            }
        }

        return true;
    }

    public static void main(String... args) {
        System.out.println(solution(3, 5, new int[] { 2, 1, 5, 1, 2, 2, 2 }));
    }
}
