package code.code_201_250.code_204;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {

    /*
     * Count the number of prime numbers less than a non-negative number, n.
     * 计算小于n的 质数 的数目
     *
     * Example:
     * Input: 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     * 算法：
     * 缓存质数
     * 判断当前是否是质数 通过判断已有质数是否是当前数的因子进行判定
     *
     * 未通过样本:
     * 499979
     * 超时了  可能质数太多  没确定一个数都需要遍历之前的所有质数，效率不佳
     * */
    public int countPrimes(int n) {
        List<Integer> primaryNums = new ArrayList<>(n);
        boolean isPrimaryNum = false;
        for (int i = 2; i < n; i++) {
            isPrimaryNum = true;
            for (Integer cur : primaryNums) {
                if (i % cur == 0) {
                    isPrimaryNum = false;
                    break;
                }
            }
            if (isPrimaryNum) {
                primaryNums.add(i);
            }
        }
        return primaryNums.size();
    }

    public static void main(String[] args) {
        int i = new CountPrimes().countPrimes3(499979);
        System.out.println(i);
    }

    /*超时*/
    public int countPrimes2(int n) {
        if (n < 2) {
            return 0;
        }
        int count = n - 2;
        for (int j = 2; j < n; j++) {
            for (int i = 2; i <= Math.sqrt(j); i++) {
                // 说明不是素数
                if (j % i == 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    /*
     * todo 学习空间换时间 确定一个数不是素数后 将该数的倍数存储标记成非素数
     * 减少素数判定耗时
     * 本实现 虽然 确定了素数后缓存了 以该素数为因子的所有非素数，但是判定素数时依旧是O(N^2)的算法
     * todo 可以一开始认为所有数都是素数，然后确定素数后把 以该素数为因子的非素数找出来。因为非素数必然由素数的倍数组成。就省去了 判定素数时依旧是O(N^2)的算法 这块的时间复杂度  见 countPrimes4
     * */
    public int countPrimes3(int n) {
        boolean[] notPrimayrNum = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimayrNum[i]) {
                continue;
            }
            if (isPrimayrNum(i)) {
                count++;
                for (int j = 2 * i; j < n; j += i) {
                    notPrimayrNum[j] = true;
                }
            }
        }
        return count;
    }

    private boolean isPrimayrNum(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes4(int n) {
        boolean[] notPrimayrNum = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimayrNum[i]) {
                continue;
            }
            count++;
            for (int j = 2 * i; j < n; j += i) {
                notPrimayrNum[j] = true;
            }
        }
        return count;
    }
}
