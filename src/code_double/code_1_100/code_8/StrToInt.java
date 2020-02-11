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

    public static void main(String[] args) {
        int i = new StrToInt().myAtoi("9223372036854775808");
        System.out.println(i);
    }
}
