package code.code_101_150.code_105;

import code.common.TreeNode;

public class retry {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft == preRight || inLeft == inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int index = findIndex(inorder, inLeft, inRight - 1, rootVal);
        if (index < 0) {
            throw new IllegalArgumentException("params error");
        }
        int leftCount = index - inLeft;
        root.left = buildTree(preorder, preLeft + 1, preLeft + 1 + leftCount, inorder, inLeft, index);
        root.right = buildTree(preorder,preLeft + 1 + leftCount, preRight, inorder, index + 1, inRight);
        return root;
    }

    /*
    * 收获
    * 1 未说是二叉搜索树，所以不可用二分查找中序遍历
    * 2 使用缓存优化查找，查找完再校验是否在给定区间内
    * */
    private int findIndex(int[] array, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        while(left < right) {
            int mid = (left + right) >>> 1;
            if(array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left] == target ? left:-1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new retry().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
