package HW1;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = {2,5,6};
        int n = 3;

        merge(nums1,m,nums2,n);
        Arrays.stream(nums1).peek(x -> System.out.print(x +" ")).toArray();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        int [] numsSort = Arrays.stream(nums1).sorted().toArray();
        System.arraycopy(numsSort,0,nums1,0,n+m);
    }
}
