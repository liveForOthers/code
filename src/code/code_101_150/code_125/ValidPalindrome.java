package code.code_101_150.code_125;

public class ValidPalindrome {

    /*
     *
     * Given a string, determine if it is a palindrome,
     * considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     *
     * Example 1:
     * Input: "A man, a plan, a canal: Panama"
     *
     * Output: true
     *
     * Example 2:
     * Input: "race a car"
     * Output: false
     *
     * 目标: 给定一个字符串 确定该串是否为回文串，其中 大小写忽略、非英文以及数字字符忽略
     *
     * 算法：
     * 左右两遍遍历即可  边遍历边把字符转为小写进行比较
     *
     * 时间复杂度 O(N)  空间复杂度 O(1)
     * */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = -1;
        int right = s.length();
        int diff = 'a' - 'A';
        while (left++ < right--) {
            while (left < right && !isLowerAlpha(s.charAt(left)) && !isNumeric(s.charAt(left)) && !isHighAlpha(s.charAt(left))) {
                left++;
            }
            while (right > left && !isLowerAlpha(s.charAt(right)) && !isNumeric(s.charAt(right)) && !isHighAlpha(s.charAt(right))) {
                right--;
            }
            if (isNumeric(s.charAt(left)) || isNumeric(s.charAt(right))) {
                if (s.charAt(left) == s.charAt(right)){
                    continue;
                }
                return false;
            }
            if (s.charAt(left) != s.charAt(right) && Math.abs(s.charAt(left) - s.charAt(right)) != diff) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLowerAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isHighAlpha(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
