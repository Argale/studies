package num;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class TestNumberGuessBean {
	static NumberGuessBean testObj;
	@BeforeClass
	public static void initalization(){
		testObj=new NumberGuessBean();
	}

	@Test
	public void tsDefaultValuesTest(){

		testObj=new NumberGuessBean();
		assertFalse(testObj.success);
		assertNull(testObj.hint);
		assertTrue(testObj.answer>0 && testObj.answer<100);
		assertEquals(testObj.numGuesses,0);
	}	

	@Test
	public void tsHigherHint(){
		testObj.setGuess(Integer.toString( testObj.answer-1));
		assertEquals("higher", testObj.getHint());
	}

	@Test
	public void tsLowerHint(){
		testObj.setGuess(Integer.toString( testObj.answer+1));
		assertEquals(testObj.hint, "lower");
	}
/*
	@Test
	public void tsIncorrectGuess(){
	
		testObj.setGuess(Integer.toString( -5));
		assertEquals("a number next time", testObj.getHint());
		
		testObj.setGuess(Integer.toString(105));
		assertEquals("a number next time", testObj.getHint());
		
		testObj.setGuess("��");
		assertEquals("a number next time", testObj.getHint());
	}
*/
	@Test
	public void tsReset(){
		testObj.reset();
		assertEquals(0, testObj.numGuesses);
		assertFalse(testObj.success);
		assertNotNull(testObj.answer);
	}
	
}
