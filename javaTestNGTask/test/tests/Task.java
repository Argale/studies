package tests;

import org.testng.annotations.Test;

import epam.saratov.homeWork.testng.objects.*;
import epam.saratov.homeWork.testng.objects.GeometricObjects.*;

import java.math.BigDecimal;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Task {
	@DataProvider(name = "twoSideProvider")
	public Object[][] createTwoAxis() {
		return new Object[][] { { 5, 7 } };
	}
	@DataProvider(name = "oneSideProvider")
	public Object[][] createOneAxis() {
		return new Object[][] { {5}};
	}
	GeometricObjects temp = new GeometricObjects();
	Circle testCircle;
	Quadrate testQuad;
	Rectangle testRectangle;;

	@Test(groups = { "init" }, priority = 1, dataProvider = "twoSideProvider")
	public void testInit(double sideONE, double sideTWO) {
		testCircle = temp.new Circle(sideONE);
		testQuad = temp.new Quadrate(sideONE);
		testRectangle = temp.new Rectangle(sideONE, sideTWO);
	}

	@Test(groups = { "circle" }, dependsOnGroups = { "init" },dataProvider = "oneSideProvider")
	public void circleSquare(double width) {
		double expected = new BigDecimal(width * width * Math.PI).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
		Assert.assertEquals(testCircle.getSquare(), expected);
	}

	@Test(groups = { "circle" }, dependsOnGroups = { "init" },dataProvider = "oneSideProvider")
	public void circleFerence(double radius) {
		double expected = new BigDecimal(radius * Math.PI * 2).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
		Assert.assertEquals(testCircle.getCircumference(), expected);
	}
	
	@Test(groups = { "quadrate" }, dependsOnGroups = { "init" },dataProvider = "oneSideProvider")
	public void quadSquare(double side) {
		Assert.assertEquals(testQuad.getSquare(), side * side);
	}

	@Test(groups = { "quadrate" }, dependsOnGroups = { "init" },dataProvider = "oneSideProvider")
	public void quadFerence(double side) {
		Assert.assertEquals(testQuad.getPerimeter(), side * 4);
	}

	@Test(groups = { "rectangle" }, dependsOnGroups = { "init" },dataProvider = "twoSideProvider",priority=2)
	public void recSquare(double width, double height) {
		Assert.assertEquals(testRectangle.getSquare(), width * height);
	}

	@Test(groups = { "rectangle" }, dependsOnGroups = { "init" },dataProvider = "twoSideProvider",priority=2)
	public void recFerence(double width, double height) {
		Assert.assertEquals(testRectangle.getPerimeter(), (height + width) * 2);
	}
	@Test(groups={"rectangle"},priority=3)
	public void isSquareNegatitve(){
		Assert.assertTrue(testRectangle.isQuadrate());
	}
	@Test(groups={"rectangle"},priority=1)
	@Parameters({"sideone","sidetwo"})
	public void isSquarePosititve(double sideOne,double sideTwo){
		testRectangle=temp.getRectangle(sideOne, sideTwo);
		Assert.assertTrue(testRectangle.isQuadrate());
	}
}
