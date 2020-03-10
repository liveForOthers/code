package code.code_151_200.code_200;

public class UnionFindCollection {
    int[] parent; // 存储所有节点的父节点
    int[] rank; // 用秩压缩空间
    int count;

    public UnionFindCollection(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = m * n;
        this.parent = new int[sum];
        this.rank = new int[sum];
        // 数据初始化父节点为自身
        for (int i = 0; i < sum; i++) {
            parent[i] = i;
        }
        // 初始化所有'1'的个数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }
    }

    //查找指定元素的根节点
    public int findRootValue(int index) {
        return index == parent[index] ? index : (parent[index] = findRootValue(parent[index]));
    }

    public void union(int a, int b) {
        int parentA = findRootValue(a);
        int parentB = findRootValue(b);
        if (parentA != parentB) {
            if (rank[parentA] >= rank[parentB]) {
                parent[parentB] = parentA;
            } else {
                parent[parentA] = parentB;
            }
            if (rank[parentA] == rank[parentB]) {
                rank[parentA]++;
            }
            count--;
        }
    }
}
