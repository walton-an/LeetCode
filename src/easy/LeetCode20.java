package easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.equals("")) return true;
        if (s.length() == 1) return false;

        for (int i = 0; i < s.length(); i++) {
            // 若是开括号，则入栈
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                // 如果是闭括号，但栈顶没元素，说明没有匹配的，直接返回false
                if (stack.isEmpty())
                    return false;
                // 与当前栈顶字符比较。如果一致，则将字符出栈，否则return false
                Character topChar = stack.peek();
                Character curChar = s.charAt(i);
                if (curChar == ')' && topChar == '(') stack.pop();
                else if (curChar == '}' && topChar == '{') stack.pop();
                else if (curChar == ']' && topChar == '[') stack.pop();
                else return false;

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("()[]{}");
        System.out.println(valid);
    }
}
