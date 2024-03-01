package com.practice.questions;

public class SingleCycleCheck {

	public static void main(String[] args) {
		hasSingleCycle(new int[] {0, 1, 1, 1, 1});
	}  

	public static boolean hasSingleCycle(int[] array) {
		int size = array.length;
		boolean [] visited = new boolean[size];
		int index = 0;
		for(int i = 0 ; i< array.length; i++) {
			if(visited[index] == false) {
				visited[index] = true;
				index = getIndex(index, size, array[index]);
			}
			else{
				return false;
			}
		}

		for(Boolean b : visited) {
			if(!b) {
				return false;
			}
		}
		return true && index%size ==0;
	}

	private static int getIndex(int current, int size, int jump) {
		if(current + jump > 0 &&  current + jump < size) {
			return current+jump;
		}
		if(current+jump < 0) {
			return size  + (current+(jump%size));
		}
		if(current+jump > size-1) {
			return ((current+jump) % (size));
		}
		return 0;
	}
}
