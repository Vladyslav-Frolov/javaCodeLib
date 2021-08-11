package info.vladyslav.javabasics.x_leetcode;

import java.util.Arrays;

public class Task1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = j;
                    result[1] = i;
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();

        System.out.println(Arrays.toString(task1.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
