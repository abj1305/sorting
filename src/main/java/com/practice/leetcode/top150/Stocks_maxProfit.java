package com.practice.leetcode.top150;

public class Stocks_maxProfit {

	public static void main(String args []) {
		Stocks_maxProfit s = new Stocks_maxProfit();
		int profit = s.maxProfit(new int [] {7,1,5,3,6,4});
		System.out.println(profit);
	}
	
	public int maxProfit(int[] prices) {
		int least = Integer.MAX_VALUE;
		int ans = 0;
		int presentProfit = 0;
		for(int i = 0; i < prices.length ; i++) {
			if(prices[i] < least) {
				least = prices[i];
			}
			presentProfit = prices[i] - least;
			if(presentProfit > ans) {
				ans = presentProfit;
			}
		}
		return ans;
	}
	
    public int maxProfit2(int[] prices) {
        int profit = 0;
        
        for(int buy = 0 ; buy < prices.length-1;buy++) {
        	for(int sell = buy + 1; sell < prices.length ; sell ++) {
        		if(prices[sell] - prices[buy] > profit) {
        			profit = prices[sell] - prices[buy];
        		}
        	}
        }
        return profit;
    }
	
}
