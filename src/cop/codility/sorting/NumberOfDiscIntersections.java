package cop.codility.sorting;

import java.util.Map;
import java.util.TreeMap;

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
        Map<Integer, Point> points = new TreeMap<>();

        for (int i = 0; i < A.length; i++) {
            int left = i - A[i];
            int right = i + A[i];

            if (!points.containsKey(left))
                points.put(left, new Point(left));
            if (!points.containsKey(right))
                points.put(right, new Point(right));

            points.get(left).open++;
            points.get(right).close++;
        }

        int cur = 0;
        int res = 0;

        for (Point point : points.values()) {
            res += cur * point.open + combination(point.open, 2);
            cur += point.open - point.close;

            if (res > 10000000)
                return -1;
        }

        return res;
    }

    private static int combination(int n, int k) {
        if (n < k)
            return 0;
        if (n == k)
            return 1;
        if (k == 1)
            return n;
        return combination(n - 1, k - 1) + combination(n - 1, k);
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

