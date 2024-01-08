package com.practice.leetcode;

public class RangeSumBST2 {

	public static void main(String [] args) {
		
	}
	
    public int rangeSumBST(TreeNode root, int low, int high) {
    	if(root == null) return 0;
    	int sum = 0;
    	if(root.val >= low && root.val <= high)
    		sum = root.val;
    	if(root.val > low)
    		sum = sum + rangeSumBST(root.left, low, high);
    	if(root.val < high)
    		sum = sum + rangeSumBST(root.right, low, high);
    	return sum;
    }
    
}
