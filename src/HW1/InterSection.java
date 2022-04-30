package HW1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterSection {
    public static void main(String[] args) {
//        int[] nums1 = {4, 9, 5};
//        int[] nums2 = {9, 4, 9, 8, 4};

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2,2};
        int[] res = intersect(nums1, nums2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Long> countNum1 = Arrays.stream(nums1).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> countNum2 = Arrays.stream(nums2).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        countNum1.forEach((k, v) -> System.out.println(k + " - " + v));
        countNum2.forEach((k, v) -> System.out.println(k + " - " + v));
//        int[] res = new int[countNum1.size() <= countNum2.size() ? countNum1.size() : countNum2.size()];

//        for (int i = 0; i < res.length; i++){
//            if (countNum1.size() <= countNum2.size()) {
//                countNum1.forEach((k, v) -> {
//                    Long r = v <= countNum2.get(k) ? v : countNum2.get(k);
//                    for (int j = 0; j < r; j++) {
//                        res[i] = k;
//                    }
//                });
//            }
//        }
        List<Integer> resList = new ArrayList<>();
        countNum1.forEach((k, v) -> {
            if (countNum2.containsKey(k)) {
                Long r = v <= countNum2.get(k) ? v : countNum2.get(k);
                for (int i = 0; i < r; i++) {
                    resList.add(k);

                }
            }
        });
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++){
            res[i] = Integer.parseInt(resList.get(i).toString());
        }
        return res;
    }
}
