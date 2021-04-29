package com.example.demo.model;

public class User implements Comparable<User> {
	
	private int id;
	private int score;
	private String name;
	private int rank;
	
	

	public User() {
		super();
	}
	
	
	public User(int id, int score, String name, int rank) {
		super();
		this.id = id;
		this.score = score;
		this.name = name;
		this.rank = rank;
	}
	
	
	@Override
	public int compareTo(User user) {
		return Integer.compare(this.getScore(), user.getScore());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", score=" + score + ", name=" + name + ", rank=" + rank + "]";
	}



	
	

}
