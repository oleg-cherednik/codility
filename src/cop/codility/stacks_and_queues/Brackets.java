package cop.codility.stacks_and_queues;

import java.util.Stack;

/**
 * <h1>Brackets</h1>
 * <i>Determine whether a given string of parentheses is properly nested.</i><br>
 * <br>
 * A string S consisting of N characters is considered to be <i>properly nested</i> if any of the following conditions is true:
 * <ul>
 * <li>S is empty;</li>
 * <li>S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;</li>
 * <li>S has the form "VW" where V and W are properly nested strings.</li>
 * </ul>
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(String S); }
 * </pre>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p/>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [0..200,000];</li>
 * <li>string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).</li>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 05.11.2015
 */
public class Brackets {
    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char ch : S.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                char prv = stack.isEmpty() ? '\0' : stack.pop();

                if (ch == ')' && prv != '(' || ch == '}' && prv != '{' || ch == ']' && prv != '[')
                    return 0;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String... args) {
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("([)()]"));
        System.out.println(solution(")("));
    }
}
