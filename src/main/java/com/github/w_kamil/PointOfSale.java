package com.github.w_kamil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents main module of Point of Sale.
 * Responsible for input/output connections. 
 *
 */

public class PointOfSale implements OnProductScanListener {

	private Printer printer = new Printer();
	private LCDDisplay lcdDisplay = new LCDDisplay();
	private List<Product> currentScannedPriductsList = new ArrayList<Product>();

	private static final String EXIT_KEY = "exit";

	public void onScan(String scannedBarcode) {

		if (scannedBarcode.equals(EXIT_KEY)) {
			BigDecimal sumAmount = new BigDecimal(0);
			if (currentScannedPriductsList.size() > 0) {
				for (Product product : currentScannedPriductsList) {
					printer.print(product.toString());
					sumAmount = sumAmount.add(product. getProductPrice());
				}
				String totalAmonutString = String.format("________________Total amount: %.2f", sumAmount);
				printer.print(totalAmonutString);
				lcdDisplay.display(totalAmonutString);
			}
			System.exit(1);
		} else if (scannedBarcode.equals("")) {
			System.out.println("'Invalid bar-code'");
		} else {

			// TODO iimplement database call on variants: product found vs. product not found
			lcdDisplay.display(scannedBarcode);
		}
	}

}