package code.code_1_50.code_0049;

import java.util.*;

public class GroupAnagrams {

    /*
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     *
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     *
     * 1 什么是一个group?
     *   每个字符出现的次数相同 的串为一类
     *
     * 2 怎么识别一个group？
     *   将串转为char数组 进行排序后 转为字符串 如果字符串equals 则认为是同一个group
     *
     * 3 怎么将一个 group的 都放在一个list集合中?
     *   使用 String List<String> Map 相同的String 都放在一个list中
     *
     * 4 什么时候将分组加入到结果中？
     *   在处理新的key时，将对应的list引用存储在结果集合里，可减少一次遍历Map的耗时
     *
     * */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> entryMap = new HashMap<>();
        for (String cur : strs) {
            char[] chars = cur.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = entryMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                entryMap.put(key, list);
                // 减少一次遍历Map的耗时
                res.add(list);
            }
            list.add(cur);
        }
        return res;
    }
}
