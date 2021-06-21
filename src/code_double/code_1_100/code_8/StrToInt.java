package code_double.code_1_100.code_8;

public class StrToInt {
    public int myAtoi(String str) {
        if(str==null || str.length()==0){
            return 0;
        }
        int index = 0;
        while(index<str.length() && str.charAt(index)==' '){
            index++;
        }
        if(index>=str.length()){
            return 0;
        }
        boolean isPositive = true;
        if(str.charAt(index)=='-'){
            isPositive = false;
            index++;
        }else if(str.charAt(index)=='+'){
            index++;
        }
        long num = 0;
        while(index<str.length()){
            if(str.charAt(index)>'9' || str.charAt(index)<'0'){
                break;
            }
            int cur = str.charAt(index++)-'0';
            num = num*10+cur;
        }
        if(!isPositive){
            num = num*(-1);
            return num<Integer.MIN_VALUE?Integer.MIN_VALUE:(int)num;
        }
        return num>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)num;
    }

    public int myAtoi2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        //todo 字符串取字符越界判断勿忘 index < s.length()
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        //todo inactive 场景处理 写代码时要注意多想非正常期望业务场景
        if(index >= s.length()){
            return 0;
        }

        int sign = s.charAt(index) == '-' ? -1 : 1;
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            index++;
        }

        long value = 0;
        while (index < s.length()) {
            if (s.charAt(index) > '9' || s.charAt(index) < '0') {
                break;
            }

            int cur = s.charAt(index) - '0';
            value = 10 * value + cur;
            //todo 越界判断需要包含最后一个value值，所以计算value在越界校验之前
            if (sign == 1 && value > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && (-1) * value < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        return (int)value * sign;
    }

    public static void main(String[] args) {
        int i = new StrToInt().myAtoi("9223372036854775808");
        System.out.println(i);
    }
}
