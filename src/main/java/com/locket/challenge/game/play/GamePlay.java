package com.locket.challenge.game.play;

import java.util.ArrayList;
import java.util.List;

import com.locket.challenge.game.data.TestCase;
import com.locket.challenge.game.data.ZombieAppearance;

public class GamePlay {
	public static GameResult play(TestCase testCase) {
		return play(testCase.getZombieAppearances());
	}
	
	public static GameResult play(List<ZombieAppearance> zombieAppearances) {
		return play(new GameStatus(), zombieAppearances);
	}
	
	private static GameResult play(GameStatus gameStatus,
			List<ZombieAppearance> zombieAppearances) {
		if (gameStatus == null) {
			return null;
		}
		if (zombieAppearances.size() == 0) {
			return gameStatus.getGameResult();
		}
		GameResult bestGameResult = null;
		// for every zombie appearance in the list...
		for (ZombieAppearance zombieAppearance : zombieAppearances) {
			// create a new list without this zombie appearance
			List<ZombieAppearance> zombieAppearancesRest = cloneAndRemove(
					zombieAppearances, zombieAppearance);
			//get new game status after smashing this zombie.
			GameStatus newGameStatus = GameStatus.smashZombie(gameStatus,
					zombieAppearance);
			
			//get game result for both scenarios:
			//	1- smashing this zombie
			GameResult resultNoSmashing = play(gameStatus, zombieAppearancesRest);
			//	2- Ignoring this zombie
			GameResult resultSmashing = play(newGameStatus,
					zombieAppearancesRest);

			//keep the best game result
			bestGameResult = GameResult.best(bestGameResult,
					GameResult.best(resultNoSmashing, resultSmashing));
		}
		return bestGameResult;
	}

	private static List<ZombieAppearance> cloneAndRemove(
			List<ZombieAppearance> zombieAppearances,
			ZombieAppearance zombieAppearance) {
		List<ZombieAppearance> result = new ArrayList<ZombieAppearance>(zombieAppearances);
		result.remove(zombieAppearance);
		return result;
	}
}
