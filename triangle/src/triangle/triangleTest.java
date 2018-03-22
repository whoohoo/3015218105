package triangle;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class triangleTest {
	String result;
	String equilateral="The triangle is equilateral.";
	String isosceles="The triangle is isosceles.";
	String scalene="The triangle is scalene.";
	 
	@Before
	 public void setUp() throws Exception {
	  System.out.println("≤‚ ‘ø™ º");
	 }
	 @After
	 public void tearDown() throws Exception {
		  System.out.println("≤‚ ‘Ω· ¯...");
		 }
	 
@Test
public void test1(){
	result = triangle.triangle(3,4,5);
	System.out.println(result);
	assertEquals(scalene,result);
}
@Test
public void test2(){
	result = triangle.triangle(3,3,5);
	System.out.println(result);
	assertEquals(isosceles,result);
}
@Test
public void test3(){
	result = triangle.triangle(3,3,3);
	System.out.println(result);
	assertEquals(equilateral,result);
}
}
