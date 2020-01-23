package code.code_151_200.code_171;

public class ExcelSheetColumnNumber {
    /*
     * 给字母串  转为对应数字
     * */
    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        titleToNumber("ZY");
    }
}
