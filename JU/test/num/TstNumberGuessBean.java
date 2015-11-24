package num;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class TstNumberGuessBean {
	static NumberGuessBean testObj;
	@BeforeClass
	public static void initalization(){
		testObj=new NumberGuessBean();
	}
	/*1)Проверка значений полей после создания*/
	@Test
	public void tsDefaultValuesTest(){
		/*заново инициализируем на случай прохождения других тестов*/
		testObj=new NumberGuessBean();
		assertFalse(testObj.success);
		assertNull(testObj.hint);
		assertTrue(testObj.answer>0 && testObj.answer<100);
		assertEquals(testObj.numGuesses,0);
	}
	/*2)Проверка ввода числа меньшего чем ответ*/
	@Test
	public void tsHigherHint(){
		testObj.setGuess(Integer.toString( testObj.answer-1));
		assertEquals("higher", testObj.getHint());
	}
	/*3)Проверка числа большего чем ответ*/
	@Test
	public void tsLowerHint(){
		testObj.setGuess(Integer.toString( testObj.answer+1));
		assertEquals(testObj.hint, "lower");
	}
	/*4)Проверка значений вне диапазона ответов*/
	@Test
	public void tsIncorrectGuess(){
		/*число меньше диапазона*/
		testObj.setGuess(Integer.toString( -5));
		assertEquals("a number next time", testObj.getHint());
		/*число больше диапазона*/
		testObj.setGuess(Integer.toString(105));
		assertEquals("a number next time", testObj.getHint());
		/*не число*/
		testObj.setGuess("ой");
		assertEquals("a number next time", testObj.getHint());
	}
	/*5)Проверка значений полей после метода reset*/
	@Test
	public void tsReset(){
		testObj.reset();
		assertEquals(0, testObj.numGuesses);
		assertFalse(testObj.success);
		assertNotNull(testObj.answer);
	}
	
}
