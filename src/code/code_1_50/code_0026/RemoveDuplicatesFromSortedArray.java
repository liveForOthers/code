package code.code_1_50.code_0026;

public class RemoveDuplicatesFromSortedArray {
    /*
    * 要细心，定义的指针变量要确保 每次迭代正确变化
    * */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        int prev = nums[0];
        for(int i = 1;i<nums.length;i++){
            if (nums[i]==prev){
                continue;
            }
            prev = nums[i];
            nums[index++] = nums[i];
        }
        return index;
    }
}
