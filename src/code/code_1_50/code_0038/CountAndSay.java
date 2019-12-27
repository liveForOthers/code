package code.code_1_50.code_0038;

public class CountAndSay {
    public static void main(String[] args) {
        String s = countAndSay(3);
        System.out.println(s);
    }

    //1.     1
    //2.     11
    //3.     21
    //4.     1211
    //5.     111221
    /*
     * 初始时 没理解题意
     * 每一次 对上一次的结果进行报数  所以传入n的say结果依赖于 n-1 的结果
     * */
    public static String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        String prev = "1";
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            int count = 1;
            int index = 1;
            char cur = prev.charAt(0);
            while (index < prev.length()) {
                if (cur == prev.charAt(index)) {
                    count++;
                } else {
                    sb.append(count).append(cur);
                    cur = prev.charAt(index);
                    count = 1;
                }
                index++;
            }
            sb.append(count).append(cur);
            prev = sb.toString();
            sb.delete(0, sb.length());
        }
        return prev;
    }
}
