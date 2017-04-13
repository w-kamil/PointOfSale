package com.github.w_kamil;

/**
 * 
 * Abstraction of Data Access object returning product data.
 * 
 */

public interface IDataAccessObject {

	public Product searchProduct(String barcodeToSearch);
}
