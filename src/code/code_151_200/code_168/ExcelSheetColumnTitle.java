package code.code_151_200.code_168;

public class ExcelSheetColumnTitle {
    /*
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     *
     * For example:
     *
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     * ...
     *
     * Example 1:
     * Input: 1
     * Output: "A"
     *
     * Example 2:
     * Input: 28
     * Output: "AB"
     *
     * Example 3:
     * Input: 701
     * Output: "ZY"
     *
     * 目标： 将数字转为英文字符
     * todo 学习：https://leetcode.wang/leetcode-168-Excel-Sheet-Column-Title.html
     *
     * 算法  本质是将10 进制数转为26进制数
     *
     * 此外，我们每次除以 26 是为了把最低位去掉，回忆下之前的等式
     * ...x4 *26^3 +x3* 26^2+x2*26^1 + x1* 26^0 = 1591
     * 求解x1：
     * 两边同时对26取模
     * x1 = 1591%26  (因为x1需要满足 在0到25之间)
     *
     * 本题中的x1范围为1-26
     * 如单字符'Z' 26* 26^0 =26
     * 此时 两遍取余  左边会多一个1 导致数据错误
     * 需要对xI = 26的
     *
     * */
    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            int count = n % 26;
            if (count == 0) {
                res.append('Z');
                n--;
                n = n / 26;
                continue;
            }
            res.append((char) ('A' + count - 1));
            n = n / 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = convertToTitle(701);
        System.out.println(s);
    }
}
