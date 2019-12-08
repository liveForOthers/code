package code.code_0009;

public class PalindromeNumber {
    /*
    *  1 对于末尾为0，且数不为0 的额外处理 否则影响 后续 reverse/10==x 的判断
    *  如x=10  reverse=1,x=0
    *
    *  2 如何判断 Palindrome 如全部reverse后再判断  a 耗时长  b 超过最大值越界
    *  解决：将原数的一半进行reverse  如何判断一半？ reverse<x 则认定还未到一半
    *  如 1221
    *  x = 12  reverse = 12  此时相等 则认为已到达一半  通过== 判定
    *  如 12321
    *  x = 12 reverse = 123 此时 reverse 较大 人为已到达一半 通过 reverse/10==x 判定
    * */
    public boolean isPalindrome(int x) {
        if(x<0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        if(x==0){
            return true;
        }
        int reverse = 0;
        while(x!=0 && reverse<x){
            int cur = x%10;
            reverse = reverse*10+cur;
            x = x/10;
        }
        return reverse==x || reverse/10==x;
    }
}
