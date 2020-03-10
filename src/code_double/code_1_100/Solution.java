package code_double.code_1_100;

public class Solution {

    public int solution(int N) {
        // write your code in Java SE 8
        double tempNum = (2 * N) + 0.25;
        double curNum = Math.sqrt(tempNum) - 0.5;
        return (int) Math.floor(curNum);
    }

    public static void main(String[] args) {
        int[] ints = new Solution().solution2(6);
        for (int cur:ints){
            System.out.println(cur+", ");
        }
    }

    public int[] solution2(int N) {
        // write your code in Java SE 8
        // 从1 到N 迭代求解
        int[] res = new int[N];
        int curTopIndex = 1;
        boolean usedZero = true;
        int maxValue = 0;
        for (int i = 2; i <= N; i++) {
            if (!usedZero) {
                usedZero = true;
                res[curTopIndex++] = 0;
            } else {
                maxValue++;
                usedZero = false;
                res[curTopIndex - 1] = -maxValue;
                res[curTopIndex++] = maxValue;
            }
        }
        return res;
    }
}
