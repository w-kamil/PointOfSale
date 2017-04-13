package com.github.w_kamil;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Barcode scanner test. 
 * Tests scanner listener calls against random input value.
 *
 */

public class BarcodeScannerTest implements OnProductScanListener {

	BarcodeScanner barcodeScanner = new BarcodeScanner();
	Random random = new Random();
	Set<String> expectedResults = new HashSet<String>();
	Set<String> actualResults = new HashSet<String>();
	final String valueToScan = "1234";
	String randomScan;

	@Before
	public void initiateScan() {
		barcodeScanner.setOnProductScanListener(this);
		randomScan = String.valueOf(random.nextInt(2147483647));
		expectedResults.add("1234");
		expectedResults.add(randomScan);
	}

	public void onScan(String scannedBarcode) {
		actualResults.add(scannedBarcode);
	}

	@Test
	public void scanTest() {
		barcodeScanner.scan("1234");
		barcodeScanner.scan(randomScan);
		Assert.assertEquals(expectedResults, actualResults);
	}
}
