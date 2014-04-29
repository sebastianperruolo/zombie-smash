package com.locket.challenge.game.data;

public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int stepsTo(Coordinate c) {
		return Math.max(Math.abs(c.x - this.x), Math.abs(c.y - this.y));
	}
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
	
	
}
