package com.locket.challenge.game;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.locket.challenge.game.data.TestCase;
import com.locket.challenge.game.data.ZombieAppearance;
import com.locket.challenge.game.play.GamePlay;
import com.locket.challenge.game.play.GameResult;
import com.locket.challenge.game.utils.FileTestCasesReader;
import com.locket.challenge.game.utils.TestCaseFileException;
import com.locket.challenge.game.utils.TestCasesReader;

/**
 * 
 * @author sperruolo
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length != 1) {
			printUsage();
			return;
		}
		
		/*
		 * Loading test cases from input file
		 */
		List<TestCase> testCases = null;
		try {
			FileTestCasesReader reader = new FileTestCasesReader(new File(args[0]));
		
			testCases = load(reader);
		} catch (TestCaseFileException e) {
			System.err.println("Please check input file: " + e.getMessage());
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		/*
		 * Running every test case
		 */
		for (TestCase testCase : testCases) {
			GameResult gameResult = GamePlay.play(testCase);
			System.out.println(String.format("Case #%d: %d", testCase.getId(), gameResult.getSmashedZombies()));
		}
	}

	private static void printUsage() {
		System.out.println("Missing input file!");
	}

	private static List<TestCase> load(TestCasesReader reader) throws TestCaseFileException {
		List<TestCase> result = new ArrayList<TestCase>();

		int testCaseCount = reader.getInt();

		for (int testCaseIndex = 1; testCaseIndex <= testCaseCount; testCaseIndex++) {
			int zombieAppearanceCount = reader.getInt();
			TestCase testCase = new TestCase(testCaseIndex);
			for (int zombieAppearanceIndex = 1; zombieAppearanceIndex <= zombieAppearanceCount; zombieAppearanceIndex++) {
				ZombieAppearance zombieAppearance = reader.getZombieAppearance();
				testCase.add(zombieAppearance);
			}
			result.add(testCase);
		}

		return result;
	}
}
