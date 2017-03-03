package cop.codility.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>NumberOfDiscIntersections</h1>
 * <i>Compute the number of intersections in a sequence of discs.</i><br>
 * <br>
 * We draw N discs on a plane. The discs are numbered from 0 to N ? 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of
 * the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * <br>
 * We say that the J-th disc and K-th disc intersect if J != K and the J-th and K-th discs have at least one common point (assuming that the discs
 * contain their borders).
 * <br>
 * The figure below shows discs drawn for N = 6 and A as follows:
 * <pre>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 2
 * A[3] = 1
 * A[4] = 4
 * A[5] = 0
 * </pre>
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * <ul>
 * <li>discs 1 and 4 intersect, and both intersect with all the other discs;</li>
 * <li>disc 2 also intersects with discs 0 and 3.</li>
 * </ul>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should
 * return -1 if the number of intersecting pairs exceeds 10,000,000.
 * <p/>
 * Given array A shown above, the function should return 11, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [0..100,000];</li>
 * <li>each element of array A is an integer within the range [0..2,147,483,647].</li>
 * </ul>
 * <ul>
 * Complexity:
 * <li>expected worst-case time complexity is O(N*log(N));</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 04.11.2015
 */
public class NumberOfDiscIntersections {
    public static int solution(int[] A) {
        int l = A.length;

        long[] A1 = new long[l];
        long[] A2 = new long[l];

        for (int i = 0; i < l; i++) {
            A1[i] = (long)A[i] + i;
            A2[i] = -((long)A[i] - i);
        }

        Arrays.sort(A1);
        Arrays.sort(A2);

        long cnt = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            int pos = Arrays.binarySearch(A2, A1[i]);
            if (pos >= 0) {
                while (pos < A.length && A2[pos] == A1[i]) {
                    pos++;
                }
                cnt += pos;
            } else { // element not there
                int insertionPoint = -(pos + 1);
                cnt += insertionPoint;
            }

        }

        long sub = (long)l * ((long)l + 1) / 2;
        cnt -= sub;

        if (cnt > 1e7)
            return -1;

        return (int)cnt;
    }

    private static final Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();

    private static int combination(int n, int k) {
        if (n < k)
            return 0;
        if (n == k)
            return 1;
        if (k == 1)
            return n;

        if (!cache.containsKey(n))
            cache.put(n, new HashMap<>());

        Map<Integer, Integer> map = cache.get(n);

        if (!map.containsKey(k))
            map.put(k, combination(n - 1, k - 1) + combination(n - 1, k));

        return map.get(k);
    }

    private static final class Point {
        final int pos;
        int open;
        int close;

        Point(int pos) {
            this.pos = pos;
        }
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 1, 5, 2, 1, 4, 0 }));   // 11
    }
}

