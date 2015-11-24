package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import epam.saratov.homeWork.testng.objects.GeometricObjects;
import epam.saratov.homeWork.testng.objects.GeometricObjects.Rectangle;

public class TaskFactory {
	GeometricObjects temp = new GeometricObjects();

	@DataProvider(name = "factoryData")
	public Object[][] factoryData() {
		return new Object[][] { { 2, 2 } };
	}

	@Factory(dataProvider = "factoryData")
	public Object[] rectangleIsQuadFactory(double sideONE, double sideTWO) {
		return new Object[] { new isQuadTests(sideONE, sideTWO) };
	}

	public class isQuadTests {
		Rectangle testRectangle;

		public isQuadTests(double sideONE, double sideTWO) {
			testRectangle= temp.new Rectangle(sideONE, sideTWO);
		}
		@Test
		public void isQuadPositive() {
			Assert.assertTrue(testRectangle.isQuadrate());
		}
	}
}
