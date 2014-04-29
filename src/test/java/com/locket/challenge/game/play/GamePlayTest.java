package com.locket.challenge.game.play;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.locket.challenge.game.data.ZombieAppearance;
import com.locket.challenge.game.play.GamePlay;
import com.locket.challenge.game.play.GameResult;

/**
 * 
 * @author sperruolo
 */
public class GamePlayTest {
	
	@Test
	public void testExample1() {
		List<ZombieAppearance> zombieAppearances = new ArrayList<ZombieAppearance>();
		
		zombieAppearances.add(new ZombieAppearance(1,0,0));
		zombieAppearances.add(new ZombieAppearance(-1,0,0));
		zombieAppearances.add(new ZombieAppearance(10,10,1000));
		zombieAppearances.add(new ZombieAppearance(10,-10,1000));
		
		GameResult gameResult = GamePlay.play(zombieAppearances);
		
		org.junit.Assert.assertEquals(3, gameResult.getSmashedZombies());
	}

	
	@Test
	public void testExample2() {
		List<ZombieAppearance> zombieAppearances = new ArrayList<ZombieAppearance>();
		
		zombieAppearances.add(new ZombieAppearance(1,1,0));
		zombieAppearances.add(new ZombieAppearance(2,2,0));
		zombieAppearances.add(new ZombieAppearance(3,3,0));

		GameResult gameResult = GamePlay.play(zombieAppearances);
		
		org.junit.Assert.assertEquals(2, gameResult.getSmashedZombies());
	}
	
	@Test
	public void testExample3() {
		List<ZombieAppearance> zombieAppearances = new ArrayList<ZombieAppearance>();
		
		zombieAppearances.add(new ZombieAppearance(10,10,1000));
		zombieAppearances.add(new ZombieAppearance(-10,10,1000));
		zombieAppearances.add(new ZombieAppearance(10,-10,1000));
		zombieAppearances.add(new ZombieAppearance(-10,-10,1000));
		zombieAppearances.add(new ZombieAppearance(20,20,2000));
		
		GameResult gameResult = GamePlay.play(zombieAppearances);
		
		org.junit.Assert.assertEquals(2, gameResult.getSmashedZombies());
	}

	@Test
	public void testExampleCustom1() {
		List<ZombieAppearance> zombieAppearances = new ArrayList<ZombieAppearance>();
		
		GameResult gameResult = GamePlay.play(zombieAppearances);
		
		org.junit.Assert.assertEquals(0, gameResult.getSmashedZombies());
	}
	
	@Test
	public void testExampleCustom2() {
		List<ZombieAppearance> zombieAppearances = new ArrayList<ZombieAppearance>();
		
		zombieAppearances.add(new ZombieAppearance(1,1,1000));
		zombieAppearances.add(new ZombieAppearance(2,2,1000));
		zombieAppearances.add(new ZombieAppearance(3,3,1499));
		
		GameResult gameResult = GamePlay.play(zombieAppearances);
		
		org.junit.Assert.assertEquals(2, gameResult.getSmashedZombies());
	}
}
