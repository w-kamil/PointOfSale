package com.github.w_kamil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;

public class PointOfSaleTest {

	List<String> barcodesList = Arrays.asList(null, "", "1234", "5900512900223", "5900512500010", "5900512980782",
			"exit");
	PointOfSale pointOfSale = new PointOfSale();
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void pointOfSaleNullTest() {
		pointOfSale.onScan(barcodesList.get(0));
		Assert.assertEquals("'Product not found'" + System.getProperty("line.separator"), outContent.toString());
	}

	@Test
	public void pointOfSaleEmptyStringTest() {
		pointOfSale.onScan(barcodesList.get(1));
		Assert.assertEquals("'Invalid bar-code'" + System.getProperty("line.separator"), outContent.toString());
	}

	@Test
	public void pointOfSaleNotFoundTest() {
		pointOfSale.onScan(barcodesList.get(2));
		Assert.assertEquals("'Product not found'" + System.getProperty("line.separator"), outContent.toString());
	}

	@Test
	public void pointOfSaleExitTest() {
		pointOfSale.onScan(barcodesList.get(3));
		pointOfSale.onScan(barcodesList.get(4));
		pointOfSale.onScan(barcodesList.get(5));
		pointOfSale.onScan(barcodesList.get(6));
		Assert.assertTrue((outContent.toString()).contains("25,99"));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);

	}
}
