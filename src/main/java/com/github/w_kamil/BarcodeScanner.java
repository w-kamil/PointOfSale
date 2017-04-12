package com.github.w_kamil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * BarcodeScanner class implementation, on method "scan" simulates barcode scan
 * with Bufferedreader, calls "onScan" method to its listener
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
				String scanResult = bufferedReader.readLine();
				if (scanResult == null)
					scanResult = "";
				onProductScanListener.onScan(scanResult);
				bufferedReader.close();
				stringReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}