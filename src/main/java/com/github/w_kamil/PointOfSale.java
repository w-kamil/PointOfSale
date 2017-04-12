package com.github.w_kamil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents main module of Point of Sale. Responsible for input/output
 * connections.
 *
 */

public class PointOfSale implements OnProductScanListener {

	private Printer printer = new Printer();
	private LCDDisplay lcdDisplay = new LCDDisplay();
	private DataAccessObject dataAccessObject = new DataAccessObject();
	private List<Product> currentScannedProductsList = new ArrayList<Product>();

	private static final String EXIT_KEY = "exit";
	

	public void onScan(String scannedBarcode) {

		if (scannedBarcode != null && scannedBarcode.equals(EXIT_KEY)) {
			BigDecimal sumAmount = new BigDecimal(0);
			if (currentScannedProductsList.size() > 0) {
				for (Product product : currentScannedProductsList) {
					printer.print(product.toString());
					sumAmount = sumAmount.add(product.getProductPrice());
				}
				String totalAmonutString = String.format("________________Total amount: %.2f", sumAmount);
				printer.print(totalAmonutString);
				lcdDisplay.display(totalAmonutString);
			}
			currentScannedProductsList = new ArrayList<Product>();

		} else if (scannedBarcode != null && scannedBarcode.equals("")) {
			System.out.println("'Invalid bar-code'");
		} else {
			Product product = dataAccessObject.searchProduct(scannedBarcode);
			if(product != null){
				currentScannedProductsList.add(product);
				lcdDisplay.display(product.toString());
			} else{
				System.out.println("'Product not found'");
			}
		}
	}
}
