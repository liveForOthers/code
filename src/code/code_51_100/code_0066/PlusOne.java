package code.code_51_100.code_0066;

public class PlusOne {
    /*
     * 给定数组：从低位到高位 表示 数的高位到低位
     * 目标： 数的低位加1 返回新数组
     *
     * 考虑数溢出问题 溢出时 返回length+1位数组
     * 否则返回 计算后的数组
     *
     *
     * */
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int[] res;
        if (overflow(digits)) {
            res = new int[digits.length + 1];
        } else {
            res = new int[digits.length];
        }
        int val = digits[digits.length - 1] + 1;
        int carryValue = val / 10;
        int index = res.length - 1;
        res[index--] = val % 10;
        int i = digits.length - 2;
        for (; i >= 0; i--) {
            if (carryValue == 0) {
                break;
            }
            val = digits[i] + carryValue;
            carryValue = val / 10;
            res[index--] = val % 10;
        }
        if (carryValue != 0) {
            res[index] = carryValue;
            return res;
        }
        for (; i >= 0; i--) {
            res[index--] = digits[i];
        }
        return res;
    }

    private static boolean overflow(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{9, 9, 9});
        System.out.println(ints);
    }
}
