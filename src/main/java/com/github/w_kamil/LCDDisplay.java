package com.github.w_kamil;

/**
 * Class simulates display output
 * 
 */

public class LCDDisplay implements ILCDDisplay {

	public void display(String lineToDisplay) {
		System.out.println(lineToDisplay);
	}
}
