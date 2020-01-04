package code.code_51_100.code_0093;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    /*
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     *
     * Example:
     *
     * Input: "25525511135"
     *
     * Output: ["255.255.11.135", "255.255.111.35"]
     *
     * 目标：将给定仅包含数字的字符串  转为可行的ip地址列表
     *
     * 算法：
     * dfs+回溯法+剪枝
     *
     * 剪枝规则：
     * 1 每一段数字位数 大于0且小于4
     * 2 每一段值 大于0 且小于等于 255
     * */
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        int[] segmentEndIndex = new int[3];
        dfs(res, segmentEndIndex, s, 0, 0);
        return res;
    }

    private static void dfs(List<String> res, int[] segmentEndIndex, String s, int index, int segment) {
        if (segment == 3) {
            if (validateSegment(s, index, s.length())) {
                res.add(buildPath(s, segmentEndIndex));
            }
            return;
        }
        // 剪枝
        int leftBit = s.length() - index;
        int leftSegment = 4 - segment;
        if (leftBit > 3 * leftSegment || leftBit < leftSegment) {
            return;
        }
        for (int i = index + 1; i <= index + 3 && i < s.length(); i++) {
            // 剪枝
            if (!validateSegment(s, index, i)) {
                return;
            }
            segmentEndIndex[segment] = i;
            dfs(res, segmentEndIndex, s, i, segment + 1);
            segmentEndIndex[segment] = 0;
        }
    }

    private static boolean validateSegment(String s, int begin, int end) {
        if (begin >= end || end - begin > 3) {
            return false;
        }
        // 不允许两位数及以上且以'0'开头
        if (s.charAt(begin) == '0' && end - begin > 1) {
            return false;
        }
        int i = Integer.parseInt(s.substring(begin, end));
        return i <= 255;
    }


    private static String buildPath(String s, int[] segmentEndIndex) {
        StringBuilder res = new StringBuilder();
        int prev = 0;
        for (int cur : segmentEndIndex) {
            res.append(s.substring(prev, cur));
            res.append(".");
            prev = cur;
        }
        res.append(s.substring(prev, s.length()));
        return res.toString();
    }

    public static void main(String[] args) {
        restoreIpAddresses("0000");
    }

}
