/**
 * <h1>CountFactors</h1>
 * <i>Count factors of given number n.</i>
 * </p>
 * An integer N is given, representing the area of some rectangle.
 * </p>
 * The <i>area</i> of a rectangle whose sides are of length A and B is A * B, and the <i>perimeter</i> is 2 * (A + B).
 * </p>
 * The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.
 * </p>
 * For example, given integer N = 30, rectangles of area 30 are:
 * <pre>
 * (1, 30), with a perimeter of 62,
 * (2, 15), with a perimeter of 34,
 * (3, 10), with a perimeter of 26,
 * (5, 6), with a perimeter of 22.
 * </pre>
 * </p>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int N); }
 * </pre>
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
 * </p>
 * For example, given an integer N = 30, the function should return 22, as explained above.
 * </p>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..1,000,000,000].</li>
 * </ul>
 * </p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(sqrt(N));</li>
 * <li>expected worst-case space complexity is O(1).</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 19.03.2017
 */
public class MinPerimeterRectangle {

    public static int solution(int N) {
        int res = Integer.MAX_VALUE;

        for (int i = 1, sqrt = (int)Math.sqrt(N); i <= sqrt; i++)
            if (N % i == 0)
                res = Math.min(res, 2 * (N / i + i));

        return res;
    }

    public static void main(String... args) {
        System.out.println(solution(30));   // 22
    }

}
