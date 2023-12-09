package com.practice.corejava;

import java.util.ArrayList;
import java.util.List;

class Immutable {
	private int id;
	private String name;
	private ArrayList<Integer> friendIds;
	
	public Immutable(int id, String name, ArrayList<Integer> friendIds) {
		this.id = id;
		this.name = name;
		this.friendIds = friendIds;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Integer> getFriendIds() {
		return (ArrayList<Integer>) friendIds.clone();
	}
	
}

public class ImmutableClass {

		public static void main(String args []) {
			ArrayList<Integer> friends = new ArrayList<Integer>();
			friends.add(2);
			friends.add(3);
			friends.add(4);
			friends.add(5);
			
			Immutable obj = new Immutable(1, "Abhijeet", friends);
			ArrayList<Integer> clonedFriends = obj.getFriendIds();
			clonedFriends.add(6);
			System.out.println(obj.getFriendIds());
			
		}
	
		
	
}
