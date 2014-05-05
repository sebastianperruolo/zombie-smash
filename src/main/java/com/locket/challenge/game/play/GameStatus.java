package com.locket.challenge.game.play;

import java.util.ArrayList;
import java.util.List;

import com.locket.challenge.game.data.Coordinate;
import com.locket.challenge.game.data.ZombieAppearance;

/**
 * 
 * @author sperruolo
 */
public class GameStatus {
	private long zombieSmasherTime;
	private Coordinate location;
	private long time = 0;
	private List<ZombieAppearance> zombiesSmashed;
	
	private GameStatus(final long zombieSmasherTime, final Coordinate location, final long time, List<ZombieAppearance> zombiesSmashed) {
		this.zombieSmasherTime = zombieSmasherTime;
		this.location = location;
		this.time = time;
		this.zombiesSmashed = zombiesSmashed;
	}
	
	/**
	 * Create an instance of a clean game status:
	 * <ul>
	 *  <li>{@link #zombieSmasherTime} 0ms time to charge the zombie smasher.</li>
	 *  <li>{@link #location} location is 0,0</li>
	 *  <li>{@time} time starts at 0ms</li>
	 *  <li>{@zombiesSmashed} list empty</li>
	 * </ul>
	 */
	public GameStatus() {
		this(0, new Coordinate(0, 0), 0, new ArrayList<ZombieAppearance>());
	}
	
	public GameResult getGameResult() {
		return new GameResult(this.zombiesSmashed);
	}

	/**
	 * This method returns a new game status given a game status and a zombie 
	 * appearence. It evaluates if is possible to smash the given zombie.
	 * 
	 * @param gameStatus new game status (null if given zombie can't be smashed).
	 * @param zombie zombie to be smash.
	 * 
	 * @return new game status
	 */
	public static GameStatus smashZombie(final GameStatus gameStatus, final ZombieAppearance zombie) {
		//time interval to be on target
		long walkTime = gameStatus.location.stepsTo(zombie.getLocation()) * 100;
		//time interval to be ready on target
		long readyTime = Math.max(walkTime, gameStatus.zombieSmasherTime);
		//total time to be ready on target
		long time = gameStatus.time + readyTime;
		if (time < zombie.getTime()) {
			//if I am ready too early, I'll wait
			time = zombie.getTime();
		}
		
		if (time > (zombie.getTime() + 1000)) {
			//if I am ready too late, I lost
			return null;
		}
		//add this zombie appearance to the zombies smashed list
		List<ZombieAppearance> newZombiesSmashed = new ArrayList<ZombieAppearance>();
		newZombiesSmashed.addAll(gameStatus.zombiesSmashed);
		newZombiesSmashed.add(zombie);
		//new game status need (1) to wait to reload gun, (2) is in the new location, 
		//(3) took the time to kill the current zombie which now is in the (3) zombie 
		//smashed list.
		return new GameStatus(750l, zombie.getLocation(), time, newZombiesSmashed);
	}

	@Override
	public String toString() {
		return "GameStatus [zombieAppearances=" + zombiesSmashed.size() + "]";
	}
	
	
}
