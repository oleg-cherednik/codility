package cop.codility.prefix_sums;

import java.util.Arrays;

/**
 * <h1>GenomicRangeQuery</h1>
 * <i>Find the minimal nucleotide from a range of sequence DNA.</i>
 * <p/>
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in
 * the sequence. Each nucleotide has an <i>impact factor</i>, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3
 * and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a
 * particular part of the given DNA sequence?<br>
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in
 * non-empty arrays P and Q, each consisting of M integers. The K-th query (0 <= K < M) requires you to find the minimal impact factor of nucleotides
 * contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 * <p/>
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * <pre>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * </pre>
 * The answers to these M = 3 queries are as follows:
 * <ul>
 * <li>The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the
 * answer is 2.</li>
 * <li>The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.</li>
 * <li>The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the
 * answer is 1.</li>
 * </ul>
 * Write a function:
 * <pre>
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * </pre>
 * that, given a non-empty zero-indexed string S consisting of N characters and two non-empty zero-indexed arrays P and Q consisting of M integers,
 * returns an array consisting of M integers specifying the consecutive answers to all queries.<br>
 * The sequence should be returned as an array of integers.
 * <p/>
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 * <pre>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * </pre>
 * the function should return the values [2, 4, 1], as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..100,000];</li>
 * <li>M is an integer within the range [1..50,000];</li>
 * <li>each element of arrays P, Q is an integer within the range [0..N ? 1];</li>
 * <li>P[K] <= Q[K], where 0 <= K < M;</li>
 * <li>string S consists only of upper-case English letters A, C, G, T.</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N+M);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 19.10.2015
 */
public class GenomicRangeQuery {
    public static int[] solution(String S, int[] P, int[] Q) {
        char[] arr = S.toCharArray();
        int[] res = new int[P.length];
        int[][] pos = new int[3][arr.length];
        int A = -1;
        int C = -1;
        int G = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'A')
                A = i;
            else if (arr[i] == 'C')
                C = i;
            else if (arr[i] == 'G')
                G = i;

            pos[0][i] = A;
            pos[1][i] = C;
            pos[2][i] = G;
        }

        for (int i = 0; i < P.length; i++) {
            if (pos[0][P[i]] == P[i] || pos[0][P[i]] < pos[0][Q[i]])
                res[i] = 1;
            else if (pos[1][P[i]] == P[i] || pos[1][P[i]] < pos[1][Q[i]])
                res[i] = 2;
            else if (pos[2][P[i]] == P[i] || pos[2][P[i]] < pos[2][Q[i]])
                res[i] = 3;
            else
                res[i] = 4;
        }

        return res;
    }

    public static void main(String... args) {
        System.out.println(Arrays.toString(solution("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 })));
        System.out.println(Arrays.toString(solution("G", new int[] { 0 }, new int[] { 0 })));
        System.out.println(Arrays.toString(solution("GT", new int[] { 0, 0, 1 }, new int[] { 0, 1, 1 })));
    }
}

