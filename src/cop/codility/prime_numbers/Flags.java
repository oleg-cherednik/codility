package cop.codility.prime_numbers;

/**
 * <h1>Flags</h1>
 * <i>Find the maximum number of flags that can be set on mountain peaks.</i>
 * </p>
 * A non-empty zero-indexed array A consisting of N integers is given.
 * </p>
 * A <i>peak</i> is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P]
 * > A[P + 1].
 * </p>
 * For example, the following array A:
 * <pre>
 * A[0] = 1
 * A[1] = 5
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
 * has exactly four peaks: elements 1, 3, 5 and 10.
 * </p>
 * You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose
 * how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.
 * <pre>
 * <img src="img.png" alt="Foo">
 * </pre>
 * Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K.
 * The distance between indices P and Q is the absolute value |P − Q|.
 * </p>
 * For example, given the mountain range represented by array A, above, with N = 12, if you take:
 * <ul>
 * <li>two flags, you can set them on peaks 1 and 5;</li>
 * <li>three flags, you can set them on peaks 1, 5 and 10;</li>
 * <li>four flags, you can set only three flags, on peaks 1, 5 and 10.</li>
 * </ul>
 * You can therefore set a maximum of three flags in this case.
 * </p>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.
 * </p>
 * For example, the following array A:
 * <pre>
 * A[0] = 1
 * A[1] = 5
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
 * <li>N is an integer within the range [1..400,000];</li>
 * <li>each element of array A is an integer within the range [0..1,000,000,000].</li>
 * </ul>
 * </p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * </p>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 19.03.2017
 */
public class Flags {
    public static int solution(int[] A) {
        if (A.length <= 2)
            return 0;

        int size = 0;
        int[] peaks = new int[A.length];

        for (int i = 1; i < A.length - 1; ++i)
            if (A[i] > A[i - 1] && A[i] > A[i + 1])
                peaks[size++] = i;

        if (size <= 2)
            return size;

        for (int i = (int)Math.sqrt(peaks[size - 1] - peaks[0]) + 1; i >= 2; --i) {
            int count = 1;
            int cur = peaks[0];

            for (int j = 1; j < size; ++j) {
                if (cur + i <= peaks[j]) {
                    cur = peaks[j];
                    count++;
                }
            }

            if (count >= i)
                return i;
        }

        return 2;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
        System.out.println(solution(new int[] {}));
        System.out.println(solution(new int[] { 1 }));
    }
}
