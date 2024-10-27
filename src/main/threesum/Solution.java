package main.threesum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                findTheThirdElement(nums, j, i, result);
            }
        }
        return result;
    }

    private static void findTheThirdElement(int[] nums, int j, int i, List<List<Integer>> result) {
        int lastEl = -nums[i] - nums[j];

        for (int k = j + 1; k < nums.length; k++) {

            if (nums[k] == lastEl) {
                List<Integer> currentResult = createSubResult(nums, j, i, k);
                if (!isDuplicate(result, currentResult)) result.add(currentResult);
            }
        }
    }

    private static List<Integer> createSubResult(int[] nums, int j, int i, int k) {
        List<Integer> currentResult = new ArrayList<>();
        currentResult.add(nums[i]);
        currentResult.add(nums[j]);
        currentResult.add(nums[k]);
        return currentResult;
    }

    private static boolean isDuplicate(List<List<Integer>> lists, List<Integer> list) {
        List<Integer> sortedList = list.stream().sorted().toList();

        for (List<Integer> currentList : lists) {
            List<Integer> currentSortedList = currentList.stream().sorted().toList();
            if (currentSortedList.equals(sortedList)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums1));

        int[] nums2 = {0,1,1};
        System.out.println(solution.threeSum(nums2));

        int[] nums3 = {0,0,0};
        System.out.println(solution.threeSum(nums3));

        int[] nums4 = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(solution.threeSum(nums4));

        int[] nums5 = {0,0,0,0};
        System.out.println(solution.threeSum(nums5));
    }
}