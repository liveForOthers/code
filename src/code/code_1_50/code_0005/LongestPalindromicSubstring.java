package code.code_1_50.code_0005;

public class LongestPalindromicSubstring {
    /*
     *  分为两啪
     *  1 以本字符为中心 向两边扩展
     *  2 以本字符以及相邻字符共同为中心 向两边扩展
     *  3 定义子对象 左右Index bound 并将一些对象通用逻辑 封装在内部类中  减少主代码逻辑复杂性
     * */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        // 左包右包
        int left = 0;
        int right = 0;
        PalindromeStringBound resBound = new PalindromeStringBound(left, right);
        for (int i = 1; i < s.length(); i++) {
            // 以i为中心 向左右两边扩散 查找最大回文长度
            PalindromeStringBound curResBound = getPalindromeStringBound(s, i, i);
            resBound.updateBound(curResBound);
            if (s.charAt(i - 1) != s.charAt(i)) {
                continue;
            }
            // 以i以及i-1为中心 向左右两边扩散 查找最大回文长度
            curResBound = getPalindromeStringBound(s, i - 1, i);
            resBound.updateBound(curResBound);
        }
        return resBound.getPalindromeString(s);
    }

    private PalindromeStringBound getPalindromeStringBound(String s, int leftIndex, int rightIndex) {
        if (s == null || leftIndex < 0 || rightIndex >= s.length()) {
            throw new IllegalArgumentException("参数异常");
        }
        PalindromeStringBound res = new PalindromeStringBound(leftIndex, rightIndex);
        int left = leftIndex - 1;
        int right = rightIndex + 1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            res.setLeftBound(left);
            res.setRightBound(right);
            left--;
            right++;
        }
        return res;
    }

    class PalindromeStringBound {
        private int left;
        private int right;

        PalindromeStringBound(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int getLeftBound() {
            return left;
        }

        int getRightBound() {
            return right;
        }

        void setLeftBound(int left) {
            this.left = left;
        }

        void setRightBound(int right) {
            this.right = right;
        }

        String getPalindromeString(String s) {
            return s.substring(left, right + 1);
        }

        void updateBound(PalindromeStringBound palindromeStringBound) {
            if (palindromeStringBound == null) {
                return;
            }
            if (palindromeStringBound.getRightBound() - palindromeStringBound.getLeftBound()
                    <= getRightBound() - getLeftBound()) {
                return;
            }
            this.left = palindromeStringBound.getLeftBound();
            this.right = palindromeStringBound.getRightBound();
        }

    }
}
