package com.github.w_kamil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Barcode scanner class implementation on methos "scan" simulates barcode scan
 * with bufferedreader, calls "onScan" method to its listener
 * 
 */

public class BarcodeScanner {

	private OnProductScanListener onProductScanListener;

	public OnProductScanListener getOnProductScanListener() {
		return onProductScanListener;
	}

	public void setOnProductScanListener(OnProductScanListener onProductScanListener) {
		this.onProductScanListener = onProductScanListener;
	}

	public void scan(String textToScan) {
		if (onProductScanListener != null) {
			StringReader stringReader = new StringReader(textToScan);
			BufferedReader bufferedReader = new BufferedReader(stringReader);
			try {
				bufferedReader.readLine();
				onProductScanListener.onScan(textToScan);
				bufferedReader.close();
				stringReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}