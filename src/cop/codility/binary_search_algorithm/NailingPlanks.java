package cop.codility.binary_search_algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>NailingPlanks</h1>
 * <i>Count the minimum number of nails that allow a series of planks to be nailed.</i>
 * <p/>
 * You are given two non-empty zero-indexed arrays A and B consisting of N integers. These arrays represent N planks. More precisely, A[K] is the
 * start and B[K] the end of the K−th plank.
 * <p/>
 * Next, you are given a non-empty zero-indexed array C consisting of M integers. This array represents M nails. More precisely, C[I] is the position
 * where you can hammer in the I−th nail.
 * <p/>
 * We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].
 * <p/>
 * The goal is to find the minimum number of nails that must be used until all the planks are nailed. In other words, you should find a value J such
 * that all planks will be nailed after using only the first J nails. More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should
 * exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].
 * <p/>
 * For example, given arrays A, B such that:
 * <pre>
 * A[0] = 1    B[0] = 4
 * A[1] = 4    B[1] = 5
 * A[2] = 5    B[2] = 9
 * A[3] = 8    B[3] = 10
 * </pre>
 * four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].
 * <p/>
 * Given array C such that:
 * <pre>
 * C[0] = 4
 * C[1] = 6
 * C[2] = 7
 * C[3] = 10
 * C[4] = 2
 * </pre>
 * if we use the following nails:
 * <ul>
 * <li>0, then planks [1, 4] and [4, 5] will both be nailed.</li>
 * <li>0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.</li>
 * <li>0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.</li>
 * <li>0, 1, 2, 3, then all the planks will be nailed.</li>
 * </ul>
 * Thus, four is the minimum number of nails that, used sequentially, allow all the planks to be nailed.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A, int[] B, int[] C); }
 * </pre>
 * that, given two non-empty zero-indexed arrays A and B consisting of N integers and a non-empty zero-indexed array C consisting of M integers,
 * returns the minimum number of nails that, used sequentially, allow all the planks to be nailed.
 * <p/>
 * If it is not possible to nail all the planks, the function should return −1.
 * <p/>
 * For example, given arrays A, B, C such that:
 * <pre>
 * A[0] = 1    B[0] = 4
 * A[1] = 4    B[1] = 5
 * A[2] = 5    B[2] = 9
 * A[3] = 8    B[3] = 10
 *
 * C[0] = 4
 * C[1] = 6
 * C[2] = 7
 * C[3] = 10
 * C[4] = 2
 * </pre>
 * the function should return 4, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N and M are integers within the range [1..30,000];</li>
 * <li>each element of arrays A, B, C is an integer within the range [1..2*M];</li>
 * <li>A[K] ≤ B[K].</li>
 * </ul>
 * <p/>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O((N+M)*log(M));</li>
 * <li>expected worst-case space complexity is O(M), beyond input storage (not counting the storage required for input arguments).</li>
 * <li>Elements of input arrays can be modified.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.03.2017
 */
public class NailingPlanks {
    public static int solution(int[] A, int[] B, int[] C) {
        Arrays.sort(C);
        Set<Integer> res = new HashSet<>();

        for (int i = 0, total = A.length; i < total; i++) {
            int a = getGreaterOrEqual(C, A[i]);

            int b = 0;
            b++;

        }

        return -1;
    }

    private static int getGreaterOrEqual(int[] C, int pos) {
        int prv;
        int i = C.length / 2;

        do {
            if (C[i] == pos)
                return pos;

            prv = i;

            if (C[i] > pos)
                i /= 2;
            else
                i = (i + C.length) / 2;
        } while (Math.abs(prv - i) <= 1);

        int a = 0;
        a++;

        return 1;
    }

    public static void main(String... args) {
        System.out.println(getGreaterOrEqual(new int[] { 1, 4, 7, 10, 13, 16, 19 }, 2));
//        System.out.println(solution(new int[] { 1, 4, 5, 8 }, new int[] { 4, 5, 9, 10 }, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
//        new int[] { 4, 6, 7, 10, 2 }
    }
}
