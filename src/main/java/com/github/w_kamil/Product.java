package com.github.w_kamil;

import java.math.BigDecimal;

/** 
 * Single product model.
 * Stores information about single product.
 * Barcode value is final for each product. 
 */

public class Product {

	private final String barcode;
	private String productName;
	private BigDecimal productPrice;

	public Product(String barcode, String productName, BigDecimal productPrice) {
		this.barcode = barcode;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getBarcode() {
		return barcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if (productName.length() <= 25) {
			stringBuilder.append(String.format("%-25s - %.2f", productName, productPrice));
		} else {
			stringBuilder.append(String.format("%-25s - %.2f", productName.substring(0, 25), productPrice));
		}
		return stringBuilder.toString();
	}
}
