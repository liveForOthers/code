package code.code_101_150.code_134;

public class GasStation {


    /*
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     *
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
     * from station i to its next station (i+1).
     * You begin the journey with an empty tank at one of the gas stations.
     *
     * Return the starting gas station's index if you can travel around the circuit once
     * in the clockwise direction, otherwise return -1.
     *
     * Note:
     * If there exists a solution, it is guaranteed to be unique.
     * Both input arrays are non-empty and have the same length.
     * Each element in the input arrays is a non-negative integer.
     *
     * 目标：返回开始点，使得汽车能一直环绕运行，如不存在
     *
     * Input:
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     *
     * Output: 3
     *
     * Input:
     * gas  = [2,3,4]
     * cost = [3,4,3]
     *
     * Output: -1
     *
     * 算法：
     * 维护两个变量：
     * 1 当前油正值  持续非负数到结尾即可
     * 2 油总数正值  结尾时保证非负数即可
     *
     * 时间复杂度:O(N) 空间复杂度:O(1)
     * */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        int curGas = 0;
        int sumGas = 0;
        int curBegin = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            sumGas += diff;
            curGas += diff;
            if (curGas < 0) {
                curBegin = i + 1;
                curGas = 0;
            }
        }
        if (curBegin<gas.length && sumGas>=0){
            return curBegin;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3});
        System.out.println(i);
    }
}
