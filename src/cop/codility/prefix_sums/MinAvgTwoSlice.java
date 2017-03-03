package cop.codility.prefix_sums;

/**
 * <h1>MinAvgTwoSlice</h1>
 * <i>Find the minimal average of any slice containing at least two elements.</i>
 * <p/>
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 <= P < Q < N, is called a <i>slice</i>
 * of array A (notice that the slice contains at least two elements). The <i>average</i> of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q]
 * divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q ? P + 1).
 * <p/>
 * For example, array A such that:
 * <pre>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * </pre>
 * contains the following example slices:
 * <ul>
 * <li>slice (1, 2), whose average is (2 + 2) / 2 = 2;</li>
 * <li>slice (3, 4), whose average is (5 + 1) / 2 = 3;</li>
 * <li>slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.</li>
 * </ul>
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the starting position of the slice with the minimal average. If
 * there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 * <p/>
 * For example, given array A such that:
 * <pre>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * </pre>
 * the function should return 1, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <i>N is an integer within the range [2..100,000];</i>
 * <i>each element of array A is an integer within the range [?10,000..10,000].</i>
 * </ul>
 * Complexity:
 * <ul>
 * <il>expected worst-case time complexity is O(N);</il>
 * <il>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</il>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 15.10.2015
 */
public class MinAvgTwoSlice {
    public static int solution(int[] A) {
        double avgMin = (A[0] + A[1]) / 2.0;
        double avg;
        int pos = 0;

        for (int i = 0; i < A.length - 2; i++) {
            if (Double.compare(avg = (A[i] + A[i + 1]) / 2.0, avgMin) < 0) {
                avgMin = avg;
                pos = i;
            }

            if (Double.compare(avg = (A[i] + A[i + 1] + A[i + 2]) / 3.0, avgMin) < 0) {
                avgMin = avg;
                pos = i;
            }
        }

        return Double.compare((A[A.length - 2] + A[A.length - 1]) / 2.0, avgMin) < 0 ? A.length - 2 : pos;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 4, 2, 2, 5, 1, 5, 8 }));
        System.out.println(solution(new int[] { 4, 2, 2, 5, -5, 5, 8 }));
        System.out.println(solution(new int[] { -3, -5, -8, -4, -10 }));
    }
}

