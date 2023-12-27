package com.practice.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.algoexpert.io/questions/river-sizes
public class RiverSizes {

	public static void main(String[] args) {
		int [][] matrix = {
				{1,0,0,1,0},
				{1,0,1,0,0},
				{0,0,1,0,1},
				{1,0,1,0,1},
				{1,0,1,1,0}
		};
		
		List<Integer> list = riverSizes(matrix);
		System.out.println(list);
		
	}

	public static List<Integer> riverSizes(int[][] matrix) {
		List<Integer> sizes = new ArrayList<Integer>();
		boolean [][] visited = new boolean[matrix.length][matrix[0].length];
		for(int i = 0 ;i < matrix.length ; i++) {
			for(int j = 0 ; j< matrix[0].length; j++) {
				if(! visited[i][j]) {
					traverseNode(i, j, matrix, visited, sizes);
				}
			}
		}
		return sizes;
	}

	private static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
		int currentRiverSize = 0;
		Stack<Integer[]> nodesToExplore = new Stack<Integer[]>();
		nodesToExplore.add(new Integer [] {i, j});
		while(! nodesToExplore.isEmpty()) {
			Integer [] cur = nodesToExplore.pop();
			int x = cur[0];
			int y = cur[1];
			if(visited[x][y]) continue;
			visited[x][y] = true;
			if(matrix[x][y] == 0) continue;
			currentRiverSize +=1;
			List<Integer []> unvisitedNeighborNodes = getUnvisitedNeighbors(x, y, matrix, visited);
			for(Integer [] node : unvisitedNeighborNodes) {
				nodesToExplore.add(node);
			}
		}
		if(currentRiverSize > 0) {
			sizes.add(currentRiverSize);
		}
	}


	private static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
		List<Integer []> unvisitedNeighborNodes = new ArrayList<Integer[]>();
		if(i > 0 && ! visited[i-1][j])
			unvisitedNeighborNodes.add(new Integer[] {i-1, j});
		if(i<matrix.length-1 && ! visited[i+1][j])
			unvisitedNeighborNodes.add(new Integer[] {i+1, j});
		if(j > 0 && ! visited[i][j-1])
			unvisitedNeighborNodes.add(new Integer[] {i, j-1});
		if(j < matrix[0].length-1 && ! visited[i][j+1])
			unvisitedNeighborNodes.add(new Integer[] {i, j+1});
		return unvisitedNeighborNodes;
	}
}
