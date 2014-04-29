package com.locket.challenge.game.play;

import java.util.List;

import com.locket.challenge.game.data.ZombieAppearance;

public class GameResult {
	private List<ZombieAppearance> zombieAppearances;
	
	protected GameResult(List<ZombieAppearance> zombieAppearances) {
		this.zombieAppearances = zombieAppearances;
	}
	
	public int getSmashedZombies() {
		return this.zombieAppearances.size();
	}

	public static GameResult best(GameResult gr0,
			GameResult gr1) {
		if (gr0 == null) {
			return gr1;
		}
		if (gr1 == null) {
			return gr0;
		}
		if (gr1.zombieAppearances.size() > gr0.zombieAppearances.size()) {
			return gr1;
		}
		return gr0;
	}
}
