/**
 * <h1>MaxProductOfThree</h1>
 * <i>Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).</i>
 * <p/>
 * A non-empty zero-indexed array A consisting of N integers is given. The <i>product</i> of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 <= P
 * < Q < R < N).
 * <p/>
 * For example, array A such that:
 * <pre>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * </pre>
 * contains the following example triplets:
 * <ul>
 * <li>(0, 1, 2), product is -3 * 1 * 2 = -6</li>
 * <li>(1, 2, 4), product is 1 * 2 * 5 = 10</li>
 * <li>(2, 4, 5), product is 2 * 5 * 6 = 60</li>
 * </ul>
 * Your goal is to find the maximal product of any triplet.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A, returns the value of the maximal product of any triplet.
 * <p/>
 * For example, given array A such that:
 * <pre>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * </pre>
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [3..100,000];</li>
 * <li>each element of array A is an integer within the range [-1,000..1,000].</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N*log(N));</li>
 * <li>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 24.10.2015
 */
public class MaxProductOfThree {

    public static int solution(int[] A) {
        int[] arrMaxPos = { -2000, -2000, -2000 };
        int[] arrMinNeg = { 2000, 2000 };
        int[] arrMaxNeg = { -2000, -2000, -2000 };

        for (int val : A) {
            if (val >= 0) {
                if (val >= arrMaxPos[0]) {
                    arrMaxPos[2] = arrMaxPos[1];
                    arrMaxPos[1] = arrMaxPos[0];
                    arrMaxPos[0] = val;
                } else if (val >= arrMaxPos[1]) {
                    arrMaxPos[2] = arrMaxPos[1];
                    arrMaxPos[1] = val;
                } else if (val >= arrMaxPos[2])
                    arrMaxPos[2] = val;
            } else {
                if (val <= arrMinNeg[0]) {
                    arrMinNeg[1] = arrMinNeg[0];
                    arrMinNeg[0] = val;
                } else if (val <= arrMinNeg[1])
                    arrMinNeg[1] = val;

                if (val >= arrMaxNeg[0]) {
                    arrMaxNeg[2] = arrMaxNeg[1];
                    arrMaxNeg[1] = arrMaxNeg[0];
                    arrMaxNeg[0] = val;
                } else if (val >= arrMaxNeg[1]) {
                    arrMaxNeg[2] = arrMaxNeg[1];
                    arrMaxNeg[1] = val;
                } else if (val >= arrMaxNeg[2])
                    arrMaxNeg[2] = val;
            }
        }

        int res1 = arrMaxPos[0] * arrMaxPos[1] * arrMaxPos[2];  // 3 max positive
        int res2 = arrMinNeg[0] * arrMinNeg[1] * arrMaxPos[0];  // 2 min negative, 1 max positive
        int res3 = arrMaxNeg[0] * arrMaxNeg[1] * arrMaxNeg[2];  // 3 max negative

        if (arrMaxPos[0] == -2000 || arrMaxPos[1] == -2000 || arrMaxPos[2] == -2000)
            res1 = Integer.MIN_VALUE;
        if (arrMinNeg[0] == 2000 || arrMinNeg[1] == 2000 || arrMaxPos[0] == -2000)
            res2 = Integer.MIN_VALUE;
        if (arrMaxNeg[0] == -2000 || arrMaxNeg[1] == -2000 || arrMaxNeg[2] == -2000)
            res3 = Integer.MIN_VALUE;

        return Math.max(res1, Math.max(res2, res3));
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { -3, 1, 2, -2, 5, 6 }));
        System.out.println(solution(new int[] { -5, 5, -5, 4 }));
        System.out.println(solution(new int[] { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5 }));
        System.out.println(solution(new int[] { -5, -4, -3, -2, -1 }));
        System.out.println(solution(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(solution(new int[] { -5, -4, -2, -1, 0 }));
        System.out.println(solution(new int[] { 0, 1, 2, 3, 4, 5 }));
        System.out.println(solution(new int[] { -5, -4, 0, 0, 0 }));
    }

}

