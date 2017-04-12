package com.github.w_kamil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO simulates handling queries to Database and providing data for Point of Sale
 *
 */

public class DataAccessObject {

	private static String inputFIle = "./src/main/resources/products.csv";
	private static List<Product> productsList = new ArrayList<Product>();
	static {
		BufferedReader bufferedReader = null;
		String splitter = ",";
		try {
			bufferedReader = new BufferedReader(new FileReader(inputFIle));
			String singleLine = "";
			while ((singleLine = bufferedReader.readLine()) != null) {
				String[] productString = singleLine.split(splitter);
				productsList.add(new Product(productString[0].substring(1, productString[0].length() - 1),
						productString[1].substring(1, productString[1].length() - 1),
						new BigDecimal(productString[2].substring(1, productString[2].length() - 1))));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Product searchProduct(String barcodeToSearch) {
		for (Product product : productsList) {
			if (product.getBarcode().equals(barcodeToSearch))
				return product;
		}
		return null;

	}

}
