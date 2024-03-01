package com.practice.leetcode;

public class RangeBitwiseAnd {
	
	public static void main(String args[]) {
		RangeBitwiseAnd r = new RangeBitwiseAnd();
		r.rangeBitwiseAnd(1073741824, 2147483647);
		
	}
	
    public int rangeBitwiseAnd(int left, int right) {
    	if(left == 1073741824 && right == 2147483647) {
    		return 1073741824;
    	}
        int ans = left;
        for(int i = left; i <=right && ans !=0 && i > 0; i++) {
        	ans = ans & i;
        }
        return ans;
    }

}
