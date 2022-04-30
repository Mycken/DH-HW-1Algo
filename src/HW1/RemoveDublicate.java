package HW1;

import java.util.Arrays;

public class RemoveDublicate {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int[] expectedNums = {1, 2};
        int k = removeDuplicates(nums);
        System.out.println("_____________________________________");
        assert k == expectedNums.length;
        System.out.println(k);
        System.out.println("_____________________________________");
        Arrays.stream(nums).peek(e -> System.out.print(e)).toArray();
        System.out.println("");
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
            System.out.println(nums[i]);
        }
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int[] removedNums = Arrays.stream(nums)
                .distinct()
                .toArray();
//        for (int i =0; i < nums.length; i++){
//            if (i < removedNums.length){
//                nums[i] = removedNums[i];
//            };
//        }
        System.arraycopy(removedNums, 0, nums, 0, removedNums.length);
        return removedNums.length;
    }
}
