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
	/*1)�������� �������� ����� ����� ��������*/
	@Test
	public void tsDefaultValuesTest(){
		/*������ �������������� �� ������ ����������� ������ ������*/
		testObj=new NumberGuessBean();
		assertFalse(testObj.success);
		assertNull(testObj.hint);
		assertTrue(testObj.answer>0 && testObj.answer<100);
		assertEquals(testObj.numGuesses,0);
	}
	/*2)�������� ����� ����� �������� ��� �����*/
	@Test
	public void tsHigherHint(){
		testObj.setGuess(Integer.toString( testObj.answer-1));
		assertEquals("higher", testObj.getHint());
	}
	/*3)�������� ����� �������� ��� �����*/
	@Test
	public void tsLowerHint(){
		testObj.setGuess(Integer.toString( testObj.answer+1));
		assertEquals(testObj.hint, "lower");
	}
	/*4)�������� �������� ��� ��������� �������*/
	@Test
	public void tsIncorrectGuess(){
		/*����� ������ ���������*/
		testObj.setGuess(Integer.toString( -5));
		assertEquals("a number next time", testObj.getHint());
		/*����� ������ ���������*/
		testObj.setGuess(Integer.toString(105));
		assertEquals("a number next time", testObj.getHint());
		/*�� �����*/
		testObj.setGuess("��");
		assertEquals("a number next time", testObj.getHint());
	}
	/*5)�������� �������� ����� ����� ������ reset*/
	@Test
	public void tsReset(){
		testObj.reset();
		assertEquals(0, testObj.numGuesses);
		assertFalse(testObj.success);
		assertNotNull(testObj.answer);
	}
	
}
