package code.code_0028;

public class ImplementStrStr {

    public static void main(String[] args) {
        int i = strStr("ABABABABC", "ABABC");
        System.out.println(i);
    }

    /*
     *  String indexOf 为啥使用暴力破解 而不是时间复杂度更优的KMP
     *  是出于在实际工程使用中 KMP 并不能带来效率的提升  力扣 测试用例确实如此
     *
     *  以理解动态规划原理 为原则  谈一下我对KMP的理解
     *
     *  1 KMP 与 暴力破解的不同：
     *    暴力破解在匹配失败时 需要每次都回退原串已经遍历过的指针 导致重复遍历
     *    KMP 在匹配失败时  原串指针无需回退 只需要 回退目标串的 状态指针即可
     *
     *    问题：如何回退目标串的 状态指针？
     *
     *  2 要确定 如何回退 状态指针  需要构建 动态规划 数据
     *    dp[j][c] = next
     *    [A]: j 表示 当前状态值 目标串的 每个字符左侧代表一个状态
     *        如"ABC" 状态： 0->1->2->3 其中 状态前进 的条件是 字符达成匹配
     *    [B]: c 表示 当前原串中字符
     *    [C]: next 表示下一个流转的状态值
     *
     *    举个栗子：当前状态为j，原串字符为'A' 则下一次流转状态为 j=dp[j]['A'] 也就实现了回退目标串的 状态指针
     *    问题：如何通过 目标串构建 动态规划 数组？
     *
     *  3
     *    dp[j][c] = next 如何根据 历史计算数据 以及 j,c,目标串 来计算next?
     *
     *    在字符串 匹配中 由两种情况 a 当前字符匹配 b 当前字符不匹配
     *    对于情况a next 直接指向下一个状态即可  也就是 dp[j][c] = j+1;
     *    对于情况b next 需要状态回退 或不动
     *    问题： 对于情况b  如何确定回退到哪种状态？
     *
     *  4 解决  确定回退到哪种状态的问题 首先定义出下面名字
     *    影子状态： 状态z 与状态j 有相同前缀
     *    如  A  B  A  B  C
     *      0->1->2->3->4->5  状态4 与状态2 有相同的前缀 则 状态2 是状态4 的影子状态
     *    在状态4 时发生 状态回退 则 通过影子状态 的状态转移矩阵 获得 最近回退的状态值
     *    如 shadowIndex = 2, j=4, c='A'  dp[4]['A'] = dp[shadowIndex]['A'] = 3
     *
     *    问题： 影子状态z 如何得到？
     *
     *  5 初始状态 shadowIndex = 0 因为 距离1状态最近的状态就是0 默认初始态 是所有状态的影子状态
     *    到达状态2 时  shadowIndex 需要进行更新 shadowIndex = dp[shadowIndex][c]
     *    解释5点第二行：比较状态2 与状态1 的前缀是否相同 则由状态0的对当前字符的状态转移结果是否为1 即可确定
     *    如  A  B  A  B  C
     *      0->1->2->3->4->5
     *      状态2 时的 shadowIndex 仍旧为0
     *
     *    到达状态3 时 dp[0]['A'] = 1  此时shadowIndex 更新为1
     *    到达状态4 时 dp[1]['B'] = 2  此时 shadowIndex 更新为2  以此类推
     *
     *  6 通过 3、4、5 即可 构建出 目标串的 动态规划数组
     *    在遍历原串时 根据原串字符 以及 动态规划数组 即可求出下一次的 状态值
     *    状态到达最后一个状态 即可判定 contains
     *
     * */
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }

    static class KMP {
        private String pattern;
        private int[][] dp;

        public KMP(String pattern) {
            this.pattern = pattern;
            dp = new int[pattern.length()][256];
            calculate(dp, pattern);
        }

        private void calculate(int[][] dp, String pattern) {
            if (pattern == null || pattern.length() == 0) {
                return;
            }
            int shadowIndex = 0;
            dp[shadowIndex][pattern.charAt(0)] = 1;
            for (int i = 1; i < pattern.length(); i++) {
                for (int j = 0; j < 256; j++) {
                    if (pattern.charAt(i) == j) {
                        // 流转到下一个状态
                        dp[i][j] = i + 1;
                        // 状态回溯
                    } else {
                        dp[i][j] = dp[shadowIndex][j];
                    }
                }
                // 更新下一个字符的 影子状态索引
                shadowIndex = dp[shadowIndex][pattern.charAt(i)];
            }
        }

        private int search(String text) {
            if (text == null || text.length() == 0) {
                return 0;
            }
            int j = 0;
            for (int i = 0; i < text.length(); i++) {
                j = dp[j][text.charAt(i)];
                if (j != dp.length) {
                    continue;
                }
                // 已找到完全匹配位置 计算头索引
                return i - dp.length + 1;
            }
            return -1;
        }
    }
}
