package cop.codility.prefix_sums;

/**
 * <h1>PassingCars</h1>
 * <i>Count the number of passing cars on the road.</i><br>
 * <br>
 * A non-empty zero-indexed array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.<br>
 * Array A contains only 0s and/or 1s:
 * <ul>
 * <li>0 represents a car traveling east,</li>
 * <li>1 represents a car traveling west.</li>
 * </ul>
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 <= P < Q < N, is passing when P is traveling to the east and Q is
 * traveling to the west.
 * <p/>
 * For example, consider array A such that:
 * <pre>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * </pre>
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A of N integers, returns the number of pairs of passing cars.<br>
 * The function should return ?1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p/>
 * For example, given:
 * <pre>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * </pre>
 * the function should return 5, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..100,000];</li>
 * <li>each element of array A is an integer that can have one of the following values: 0, 1.</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 15.10.2015
 */
public class PassingCars {
    public static int solution(int[] A) {
        int count = 0;
        int inc = 0;

        for (int val : A) {
            if (val == 0)
                inc++;
            else {
                if (count + inc > 1000000000)
                    return -1;

                count += inc;
            }
        }

        return count;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 0, 1, 0, 1, 1 }));
    }
}

