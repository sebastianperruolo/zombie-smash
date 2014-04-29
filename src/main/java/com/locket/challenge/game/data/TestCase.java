package com.locket.challenge.game.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sperruolo
 */
public class TestCase {
	private List<ZombieAppearance> zombieAppearances = new ArrayList<ZombieAppearance>();
	private int id;
	
	public TestCase(int id) {
		this.id = id;
	}
	public void add(ZombieAppearance zombieAppearance) {
		this.zombieAppearances.add(zombieAppearance);
	}

	public List<ZombieAppearance> getZombieAppearances() {
		return zombieAppearances;
	}

	public int getId() {
		return this.id;
	}
	
}
