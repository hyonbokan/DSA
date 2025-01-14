package org.example;

public class DynamicProblems {

    public static int houseRobber(int[] houses) {
        if (houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];

        int rob1 = 0; // Max money robbed from houses up to two houses ago
        int rob2 = 0; // Max money robbed from houses up to the previous house

        for (int house : houses) {
            int temp = Math.max(house + rob1, rob2); // Max money if robbing or skipping this house
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    public static int missingNumber(int[] nums) {
        int output = nums.length;

        for (int i = 0; i < nums.length; i++) {
            output += (i - nums[i]);
        }

        return output;
    }

}