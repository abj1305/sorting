package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class OutOfBoundryPath {

	public static void main(String[] args) {
		OutOfBoundryPath o = new OutOfBoundryPath();
		o.findPaths(2, 2, 2, 0, 0);

	}

	int M=1000000007;
	static Map<String, Long> map = new HashMap<String, Long>();
	int solve(int n, int m, int maxMove, int startRow, int startColumn){

        if(startColumn<0 || startColumn>=n || startRow<0 || startRow>=m)return 1;

        String key = maxMove+","+ startRow+","+ startColumn;
        
        if(map.containsKey(key)) {
        	return (int) (map.get(key)%M);
        }
        
        long up=0,down=0,left=0,right=0;
        if(maxMove>0)up=solve(n, m, maxMove-1, startRow-1, startColumn);
        if(maxMove>0)down=solve(n, m, maxMove-1, startRow+1, startColumn);
        if(maxMove>0)left=solve(n, m, maxMove-1, startRow, startColumn-1);
        if(maxMove>0)right=solve(n, m, maxMove-1, startRow, startColumn+1);

        map.put(key, (up+down+left+right)%M);
        
        return (int)(map.get(key)%M);
    }
	
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    	map = new HashMap<String, Long>();
        return solve(n, m, maxMove, startRow, startColumn);
    }
	
	
	
//
//	static int ans = 0;
//	static int mod = 1000000009;
//	static Map<Integer[], Integer> map = new HashMap<Integer[], Integer>();
//	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//		ans = 0;
//		helper(m, n, maxMove, startRow, startColumn);
//		return ans;
//	}
//	
//	
//	
//	
//	private void helper(int m, int n, int maxMove, int startRow, int startColumn) {
//		if(maxMove == 0) return;
//		
//		if(startRow == 0) {
//			ans++;
//		}
//		if(startColumn ==0) {
//			ans++;
//		}
//		if(startRow == m-1) {
//			ans++;
//		}
//		if(startColumn == n-1) {
//			ans++;
//		}
//		
//		ans = ans % mod;
//		if(startRow != 0) {
//			helper(m, n, maxMove-1, startRow-1, startColumn);
//		}
//		if(startColumn != 0) {
//			helper(m, n, maxMove-1, startRow, startColumn-1);
//		}
//		if(startRow < m-1) {
//			helper(m, n, maxMove-1, startRow + 1, startColumn);
//		}
//		if(startColumn < n-1) {
//			helper(m, n, maxMove-1, startRow, startColumn+1);
//		}
//		
//	}

}
