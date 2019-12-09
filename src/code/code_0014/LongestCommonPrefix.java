package code.code_0014;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"dog", "racecar", "car"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    /*
     * 两次for循环 下表含义不要搞乱
     * 本code
     * 外层下标i 的含义是 字符在串中的位置
     * 内层下标j 的含义是 字符串在字符串数组中的位置
     * */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return res.toString();
                }
                if (cur != strs[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(cur);
        }
        return res.toString();
    }
}
