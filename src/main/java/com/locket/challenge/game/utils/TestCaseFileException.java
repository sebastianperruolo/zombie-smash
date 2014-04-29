package com.locket.challenge.game.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class represents all errors that might be found while reading
 * a game test case file.
 * 
 * @author sperruolo
 */
public class TestCaseFileException extends Exception {

	private static final long serialVersionUID = 1854831208753632372L;

	public TestCaseFileException(FileNotFoundException e) {
		super(e.getMessage());
	}

	public TestCaseFileException(IOException e) {
		super(e.getMessage());
	}

	public TestCaseFileException(NumberFormatException e) {
		super("Check file format");
	}

	public TestCaseFileException(ArrayIndexOutOfBoundsException e) {
		super("Check file format");
	}

}
