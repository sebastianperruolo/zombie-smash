package com.locket.challenge.game.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.locket.challenge.game.data.ZombieAppearance;

public class TestCasesReader {

	private BufferedReader bufferedReader;

	public TestCasesReader(File file) throws TestCaseFileException {
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			throw new TestCaseFileException(e);
		}
	}

	public int getInt() throws TestCaseFileException {
		try {
			String line = bufferedReader.readLine();
			return Integer.parseInt(line.trim());
		} catch (IOException e) {
			throw new TestCaseFileException(e);
		} catch (NumberFormatException e) {
			throw new TestCaseFileException(e);
		}
	}

	public ZombieAppearance getZombieAppearance() throws TestCaseFileException {
		try {
			String line = bufferedReader.readLine();
			String[] lineArray = line.split(" ");
			int x = Integer.parseInt(lineArray[0]);
			int y = Integer.parseInt(lineArray[1]);
			long time = Long.parseLong(lineArray[2]);
			return new ZombieAppearance(x, y, time);
		} catch (IOException e) {
			throw new TestCaseFileException(e);
		} catch (NumberFormatException e) {
			throw new TestCaseFileException(e);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new TestCaseFileException(e);
		}

	}

}
