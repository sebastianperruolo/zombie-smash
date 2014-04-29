package com.locket.challenge.game.utils;

import com.locket.challenge.game.data.ZombieAppearance;

public interface TestCasesReader {

	int getInt() throws TestCaseFileException;

	ZombieAppearance getZombieAppearance() throws TestCaseFileException;

}
