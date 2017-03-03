package cop.codility.stacks_and_queues;

/**
 * <h1>Nesting</h1>
 * <i>Determine whether given string of parentheses is properly nested.</i>
 * <p/>
 * A string S consisting of N characters is called <i>properly nested</i> if:
 * <ul>
 * <li>S is empty;</li>
 * <li>S has the form "(U)" where U is a properly nested string;</li>
 * <li>S has the form "VW" where V and W are properly nested strings.</li>
 * </ul>
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(String S); }
 * </pre>
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * <p/>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [0..100,000,000];</li>
 * <li>string S consists only of the characters "(" and/or ")".</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 05.11.2015
 */
public class StoneWall {
    public static int solution(String S) {
        return 0;
    }

    public static void main(String... args) {
        System.out.println(solution("(()(())())"));
        System.out.println(solution("())"));
    }
}
