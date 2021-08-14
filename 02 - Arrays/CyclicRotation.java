import java.util.Arrays;

/**
 * <h1>CyclicRotation</h1>
 * <i>Rotate an array to the right by a given number of steps.</i>
 * <p/>
 * A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last
 * element of the array is also moved to the first place.
 * <p/>
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is, each element of A will
 * be shifted to the right by K indexes.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int[] solution(int[] A, int K); }
 * </pre>
 * that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p/>
 * For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].
 * <p/>
 * Assume that:
 * <ul>
 * <li>N and K are integers within the range [0..100];</li>
 * <li>each element of array A is an integer within the range [−1,000..1,000].</li>
 * </ul>
 * <p/>
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 *
 * @author Oleg Cherednik
 * @since 03.03.2017
 */
public class CyclicRotation {

    public static int[] solution(int[] A, int K) {
        if (A.length == 0)
            return A;

        K %= A.length;

        if (K >= 0) {
            reverse(A, 0, A.length - 1);
            reverse(A, 0, K - 1);
            reverse(A, K, A.length - 1);
        }

        return A;
    }

    private static void reverse(int[] arr, int hi, int lo) {
        for (int i = hi, j = lo; i < j; i++, j--)
            swap(arr, i, j);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String... args) {
        System.out.println(Arrays.toString(solution(new int[0], 10)));    // []
        System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 0)));    // [3, 8, 9, 7, 6]
        System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 1)));    // [6, 3, 8, 9, 7]
        System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 3)));    // [9, 7, 6, 3, 8]
        System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 8)));    // [9, 7, 6, 3, 8]
    }

}
