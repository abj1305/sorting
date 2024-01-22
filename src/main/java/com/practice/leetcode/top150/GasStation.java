package com.practice.leetcode.top150;

import java.util.Arrays;

public class GasStation {

	public static void main(String args[]) {
		GasStation g = new GasStation();
		g.canCompleteCircuit(new int [] {1,2,3,4,5}, new int [] {3,4,5,1,2});
	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int gasSum = Arrays.stream(gas).sum();
    	int costSum = Arrays.stream(cost).sum();
    	if(gasSum < costSum) return -1;

    	for(int i = 0; i < gas.length; i++) {
    		if(gas[i] >= cost[i]) {
    			if(check(gas, cost, i) != -1) {
    				return i;
    			}
    		}
    	}
    	return -1;
    }
    
    public int check(int [] gas, int [] cost, int start) {
    	int tank = 0;
    	int iter = 0;
    	while(iter < gas.length) {
    		tank = tank +  gas[(start+iter) % gas.length];
    		if(tank < cost[(start+iter) % gas.length]) {
    			return -1;
    		}
    		tank = tank - cost[(start+iter) % gas.length];
    		iter ++;
    	}
    	return start;
    }
    
    
}
