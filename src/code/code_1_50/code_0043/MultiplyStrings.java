package code.code_1_50.code_0043;

public class MultiplyStrings {
    public static void main(String[] args) {
        String multiply = multiply("0", "0");
        System.out.println(multiply);
    }

    /*
     * Input: num1 = "123", num2 = "456" Output: "56088"
     * 实现 大数相乘算法
     * 分为以下五部分
     * 1 字符串 reverse
     * 2 乘积结果一定小于 串1长度 + 串2长度
     * 3 结果第 k 位 由 串1 第i位 串2 第j位 的乘积和 以及 extra 组成 且满足 k =i+j
     * 4 将各位乘积和 以及 求余操作 分开处理
     * 5 结果去掉头部的'0'
     *
     * */
    public static String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }
        int extra = 0;
        String n1 = reverse(num1);
        String n2 = reverse(num2);
        int len = num1.length() + num2.length();
        StringBuilder res = new StringBuilder(len);

        // 分别计算结果的 第k位的值
        // k+1 = i+j
        for (int k = 0; k < len; k++) {
            int sum = 0;
            for (int i = 0; i < n1.length() && i <= k; i++) {
                if (k >= n2.length() + i) {
                    continue;
                }
                int d1 = n1.charAt(i) - '0';
                int d2 = n2.charAt(k - i) - '0';
                sum += d1 * d2;
            }
            sum += extra;
            extra = sum / 10;
            res.append(sum % 10);
        }
        if (extra != 0) {
            res.append(extra);
        }
        while(res.length()>1 && res.charAt(res.length()-1)=='0'){
            res.deleteCharAt(res.length()-1);
        }
        return reverse(res.toString());
    }

    private static String reverse(String cur) {
        if (cur == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        for (int i = cur.length() - 1; i >= 0; i--) {
            res.append(cur.charAt(i));
        }
        return res.toString();
    }
}
