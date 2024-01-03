package com.practice.leetcode;

public class NoOfBeams {

	public static void main(String[] args) {
		NoOfBeams n = new NoOfBeams();
		int ans = n.numberOfBeams(new String[] {"011001","000000","010100","001000"});
		System.out.println(ans);
	}
	
    public int numberOfBeams(String[] bank) {
    	int src = 0;
    	int dest = 0;
    	int count = 0;
    	int beams = 0;
    	for(int i = 0; i< bank.length; i++) {
    		count = 0;
    		if(dest !=0 ) {
    			src = dest;
    		}
    		for(char c : bank[i].toCharArray()) {
    			if(c == '1') {
    				count++;
    			}
    		}
    		if(src == 0) {
    			src = count;
    		}
    		else {
    			dest = count;
    		}
    		if(src != 0  && dest !=0) {
    			beams = beams + (src*dest);
    		}
    	}
    	return beams;
    }

}
