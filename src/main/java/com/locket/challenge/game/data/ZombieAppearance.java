package com.locket.challenge.game.data;

/**
 * This class represents a zombie appearance.
 * 
 * @author sperruolo
 */
public class ZombieAppearance {
	private Coordinate location;
	private long time;
	
	public ZombieAppearance(int x, int y, long time) {
		this.location = new Coordinate(x, y);
		this.time = time;
	}
	
	public Coordinate getLocation() {
		return location;
	}
	
	public long getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "[location=" + location + ", time=" + time
				+ "]";
	}

}
