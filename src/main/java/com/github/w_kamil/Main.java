package com.github.w_kamil;


import java.util.Scanner;

/**
 * Main project class.
 * Main class generates instances and listeners of components.
 *
 */

public class Main {

	private static OnProductScanListener onProductScanListener = new PointOfSale();
	private static BarcodeScanner barcodeScanner = new BarcodeScanner();	
	private static Scanner scanner = new Scanner(System.in);
	
	static {
		barcodeScanner.setOnProductScanListener(onProductScanListener);
	}

	public static void main(String[] args) {
		
		System.out.println("Please input product barcode: ");
		do {
			String codeTextToScan = scanner.nextLine();
			barcodeScanner.scan(codeTextToScan);
		} while (true);
	}
}
