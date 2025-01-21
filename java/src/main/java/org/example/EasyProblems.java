package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EasyProblems {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> newMap = new HashMap<>();

        for (int index=0; index < nums.length; index++) {
            int diff = target - nums[index];
            if (newMap.containsKey(diff)) {
                return new int[] {newMap.get(diff), index};
            }

            newMap.put(nums[index], index);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static int bestTimeToBuy(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }

            right++;
        }
        return maxProfit;
    }

    public static boolean isPalindrome(String word) {
        String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedWord.length() - 1;

        while (left<right) {
            if (cleanedWord.charAt(left) != cleanedWord.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static String reverseString(String word) {
        String reversedWord = new StringBuilder(word).reverse().toString();
        return reversedWord;
    }

    public static String reverseString2(String word) {
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        return reversedWord;
    }

    public static boolean containDuplicates(int[] nums) {
        Set<Integer> newSet = new HashSet<Integer>();
        for (int num : nums) {
            if (newSet.contains(num)) {
                return true;
            }
            newSet.add(num);
        }
        return false;
    }

    public static int containMostWater(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int water = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(water, maxWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

}
