package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *     所有输入均为小写字母。
 *     不考虑答案输出的顺序。
 *
 */

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        // 维护一个map，k = 字符数组排序后的字符串，v = 原字符
        HashMap<String, List<String>> map = new HashMap<>(strs.length);

        for(String s : strs){
            //转为字符数组，再排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        for (String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new LeetCode49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println();
    }
}
