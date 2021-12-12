package a;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.function.Consumer;


public class A {

	public static void main(String[] args) throws Exception {
		
	System.out.println(a.add(10, 10).add(15, 15).mult(2));	
		
	}
	
	static A a = new A();
	int result;
	
	A add(int x, int y) {
		result += x+y;
		return this;
	}
	
	A mult(int x) {
		result *= x;
		return this;
	}
	
	@Override
	public String toString() { 
		return String.valueOf(result);
	}
}

