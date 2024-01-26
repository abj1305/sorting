package com.practice.leetcode;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		int i = l.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy");
		//int i = l.longestCommonSubsequence("ace", "abcde");
		System.out.println(i);

	}    
	
	public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
      
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
	}
}
