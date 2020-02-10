package code.code_201_250.code_223;

public class RectangleArea {

    /*
     * Find the total area covered by two rectilinear rectangles in a 2D plane.
     * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
     * 找出被两个矩形复盖的全部区域的面积
     *
     * Example:
     * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
     * Output: 45
     *
     * Note:
     * Assume that the total area is never beyond the maximum possible value of int.
     *
     * 假定全部区域不会超出整形最大值
     *
     * 算法：
     * 两矩形的位置分类：
     * 1 不相交  分别计算面积求和
     * 2 相交不包含  计算面积求和减去公共面积
     * 3 包含  计算出大矩形的面积
     *
     * A -x轴
     * B -y轴
     * C +x轴
     * D +y轴
     * 1 求面积  (D-B)*(C-A)
     * 2 求两矩形相交面积
     * (min(C)-max(A))*(min(D)-max(B))
     * */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s1 = getArea(A, B, C, D);
        int s2 = getArea(E, F, G, H);
        int res = s1 + s2;
        ;
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int low = Math.max(B, F);
        int high = Math.min(D, H);
        if (left >= right || low >= high) {
            return res;
        }
        int s3 = getArea(left, low, right, high);
        return res - s3;
    }

    private int getArea(int A, int B, int C, int D) {
        return (D - B) * (C - A);
    }

    public static void main(String[] args) {
        int i = new RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println(i);
    }
}
