package com.github.w_kamil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main project class. Main class generates point of sale components.
 *
 */

public class Main {

	private static PointOfSale pointOfSale = new PointOfSale();
	private static BarcodeScanner barcodeScanner = new BarcodeScanner();
	private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	private static BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	private static final String QUIT_PROGRAM_KEY = "QUIT";
	static {
		barcodeScanner.setOnProductScanListener(pointOfSale);
	}

	public static void main(String[] args) {

		System.out.println("To exit program type: " + QUIT_PROGRAM_KEY + " and press Enter");
		System.out.println("Please input product barcode: ");
		while (true) {

			try {
				String codeTextToScan = bufferedReader.readLine();
				if (codeTextToScan.equals(QUIT_PROGRAM_KEY)) {
					break;
				}
				barcodeScanner.scan(codeTextToScan);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
