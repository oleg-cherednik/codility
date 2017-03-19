package cop.codility.prime_numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>Peaks</h1>
 * <i>Divide an array into the maximum number of same-sized blocks, each of which should contain an index P such that A[P - 1] < A[P] > A[P + 1].</i>
 * </p>
 * A non-empty zero-indexed array A consisting of N integers is given.
 * </p>
 * A <i>peak</i> is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P]
 * and A[P] > A[P + 1].
 * </p>
 * For example, the following array A:
 * <pre>
 * A[0] = 1
 * A[1] = 2
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2
 * </pre>
 * has exactly three peaks: 3, 5, 10.
 * </p>
 * We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the
 * following blocks:
 * <ul>
 * <li>A[0], A[1], ..., A[K − 1],</li>
 * <li>A[K], A[K + 1], ..., A[2K − 1],</li>
 * ...
 * <li>A[N − K], A[N − K + 1], ..., A[N − 1].</li>
 * </ul>
 * </p>
 * What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be
 * peaks, but only if they have both neighbors (including one in an adjacent blocks).
 * </p>
 * The goal is to find the maximum number of blocks into which the array A can be divided.
 * </p>
 * Array A can be divided into blocks as follows:
 * <ul>
 * <li>one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.</li>
 * <li>two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.</li>
 * <li>three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. Notice in particular that the first block (1, 2, 3, 4) has a
 * peak
 * at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.</li>
 * </ul>
 * </p>
 * However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a
 * peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].
 * </p>
 * The maximum number of blocks that array A can be divided into is three.
 * </p>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the maximum number of blocks into which A can be divided.
 * </p>
 * If A cannot be divided into some number of blocks, the function should return 0.
 * </p>
 * For example, given:
 * <pre>
 * A[0] = 1
 * A[1] = 2
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2
 * </pre>
 * the function should return 3, as explained above.
 * </p>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..100,000];</li>
 * <li>each element of array A is an integer within the range [0..1,000,000,000].</li>
 * </ul>
 * </p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N*log(log(N)));</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * </p>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 19.03.2017
 */
public class Peaks {
    public static int solution(int[] A) {
        Set<Integer> peaks = new HashSet<>();

        for (int i = 1; i < A.length - 1; i++)
            if (A[i - 1] < A[i] && A[i] > A[i + 1])
                peaks.add(i);

        if (peaks.isEmpty())
            return 0;

        int res = 0;
        Set<Integer> tmp = new HashSet<>();

        for (int i = 1, max = A.length / 2; i <= max; i++) {
            if (A.length % i != 0)
                continue;

            tmp.clear();

            int len = A.length / i;

            for (int j : peaks)
                tmp.add(j / len);

            if (tmp.size() == i)
                res = i;
        }

        return res;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 1, 3, 2 }));
        System.out.println(solution(new int[] { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
    }
}
