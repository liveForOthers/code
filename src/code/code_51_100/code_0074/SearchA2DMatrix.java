package code.code_51_100.code_0074;

public class SearchA2DMatrix {

    /*
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:
     *
     * 目标： 实现有效的矩阵搜索算法
     *
     * 矩阵满足以下特征
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     *
     * 从左到右矩阵是有序递增的
     * 从上到下矩阵是有序递增的
     *
     * Example 1:
     * Input:
     * matrix = [[1, 3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]]
     *
     * target = 3
     * Output: true
     *
     * Example 2:
     * Input:
     * matrix = [[1,   3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]]
     *
     * target = 13
     * Output: false
     *
     * 有序+搜索  必然是二分法
     *
     * 行列范围缩小法： 时间复杂度 O（N+M） 空间复杂度 O(1)
     * 矩阵从左到右有序特征 以及 从上到下有序特征 则可推断除
     * 如果从矩阵右上角进行搜索
     *
     * 对于节点 matrix[i][j]
     * 1 如果比target 小    则 i = i+1;
     * 2 如果比target 大    则 j = j-1;
     *
     * 这样一次过滤一行或者一列  提高搜索效率''
     * */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = searchMatrix2(new int[][]{{1, 3}}, 3);
        System.out.println(b);
    }

    /*
     * 矩阵二分法
     * 与传统二分法差别：
     * 下标索引为行、列 两个维度 而经典二分法 是通过一个维度 取中值进行比较的
     *
     * 因此 可以 将行、列两个维度 使用一个维度来表示
     * 行M 列N 的矩阵 共有 M*N个元素
     *
     * 因为行由小到大有序  列由小到大有序
     * 如果mid 比 target小 则 left = mid+1 则left标识的 行列均增加 且大于mid所标识的行列  满足要求
     * 如果mid 比 target大 则 right = mid-1 同left
     *
     * 第k个元素的行列索引计算方法：
     * row = k/列数
     * col = k%列数
     *
     * 时间复杂度 O(log(m*n)) 优于 O(m+n) 空间复杂度 O(1)
     *
     * */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return matrix[left / matrix[0].length][left % matrix[0].length] == target;
    }
}
