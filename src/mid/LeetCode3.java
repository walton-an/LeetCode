package mid;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        // 滑动窗口，以i为开始位置，依次找出每个位置的最长子串
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            hashMap.put(c,1);
            int j = i + 1;
            while (j < s.length() && !hashMap.containsKey(s.charAt(j))) {
                hashMap.put(s.charAt(j),1);
                j++;
            }
            result = hashMap.size() > result ? hashMap.size(): result;
            hashMap.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbb"));
    }
}
