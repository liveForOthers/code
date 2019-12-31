package code.code_51_100.code_0076;

public class MinimumWindowSubstring {
    /*
     *
     * Given a string S and a string T,
     * find the minimum window in S which will contain all the characters in T in complexity O(n).
     *
     * 找到能覆盖T中所有字符的  S 中的窗口子串
     *
     * Example:
     *
     * Input: S = "ADOBECODEBANC", T = "ABC"
     *
     * Output: "BANC"
     *
     * Note:
     * If there is no such window in S that covers all characters in T, return the empty string "".
     *
     * 如果在S中不存在子串 能覆盖T中所有字符 返回空串
     * If there is such window,
     * you are guaranteed that there will always be only one unique minimum window in S.
     * 如果存在，仅有一个答案
     *
     * 学习：
     * 算法：
     *
     * 滑动窗口，左右指针
     * 左右指针均从起点开始，右指针向右滑动 直到窗口内子串能覆盖 所有的 target 串
     * 覆盖后 左指针收缩使满足
     * 1 覆盖target串
     * 2 窗口尽可能小
     *
     * */
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int[] cache = new int[1 << 8];
        int request = 0;
        for (int i = 0; i < t.length(); i++) {
            if (cache[t.charAt(i)] == 0) {
                request++;
            }
            cache[t.charAt(i)]++;
        }
        // 用于缓存当前窗口的 在t中存在的字符的个数
        int[] count = new int[1 << 8];
        // 执行窗口滑动
        int left = 0;
        int right = 0;
        int formed = 0;
        Result result = new Result();
        // 移动右指针，直到符合要求时 进行左边缩小窗口，如果缩小后长度小于当前结果长度，则更新当前结果
        while (right < s.length()) {
            if (cache[s.charAt(right)] == 0) {
                right++;
                continue;
            }
            // 更新当前指针的 count
            count[s.charAt(right)]++;
            if (count[s.charAt(right)] == cache[s.charAt(right)]) {
                formed++;
            }
            while (formed == request && left <= right) {
                // 满足条件更新result
                if (result.getLength() == -1 || right - left + 1 < result.getLength()) {
                    result.setLength(right - left + 1);
                    result.setLeftIndex(left);
                    result.setRightIndex(right);
                }
                // 更新移动后的 formed 以及 count 状态
                if (cache[s.charAt(left)] != 0) {
                    count[s.charAt(left)]--;
                    // 不满足条件了 更新formed 跳出本层循环
                    if (count[s.charAt(left)] < cache[s.charAt(left)]) {
                        formed--;
                    }
                }
                // 更新左指针
                left++;
            }
            right++;
        }

        return result.getLength()==-1?"":s.substring(result.getLeftIndex(),result.getRightIndex()+1);
    }

    static class Result {
        private int length = -1;
        private int leftIndex = -1;
        private int rightIndex = -1;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getLeftIndex() {
            return leftIndex;
        }

        public void setLeftIndex(int leftIndex) {
            this.leftIndex = leftIndex;
        }

        public int getRightIndex() {
            return rightIndex;
        }

        public void setRightIndex(int rightIndex) {
            this.rightIndex = rightIndex;
        }
    }

    public static void main(String[] args) {
        String s = minWindow("a", "a");
        System.out.println(s);
    }
}
