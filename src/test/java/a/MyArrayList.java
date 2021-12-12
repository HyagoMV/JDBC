package a;

import java.util.Arrays;


public class MyArrayList<E> implements MyList<E> {

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
	
	private int modCount;
	private Object[] elementData;
	private int size;

	  public MyArrayList() {
	        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	    }
	
	public boolean add(E e) {
		modCount++;
		add(e, elementData, size);
		return true;
	}

	private void add(E e, Object[] elementData, int s) {
		if (s == elementData.length)
			elementData = grow();
		elementData[s] = e;
		size = s + 1;
	}

	private Object[] grow() {
		return grow(size + 1);
	}

	private Object[] grow(int minCapacity) {
		int oldCapacity = elementData.length;
		if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			int newCapacity = ArraysSupport.newLength(oldCapacity, minCapacity - oldCapacity, /* minimum growth */
					oldCapacity >> 1 /* preferred growth */);
			return elementData = Arrays.copyOf(elementData, newCapacity);
		} else {
			return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
		}
	}
	
	
	static class ArraysSupport {
	    public static final int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;
		
	 public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
	        // assert oldLength >= 0
	        // assert minGrowth > 0

	        int newLength = Math.max(minGrowth, prefGrowth) + oldLength;
	        if (newLength - MAX_ARRAY_LENGTH <= 0) {
	            return newLength;
	        }
	        return hugeLength(oldLength, minGrowth);
	    }

	    private static int hugeLength(int oldLength, int minGrowth) {
	        int minLength = oldLength + minGrowth;
	        if (minLength < 0) { // overflow
	            throw new OutOfMemoryError("Required array length too large");
	        }
	        if (minLength <= MAX_ARRAY_LENGTH) {
	            return MAX_ARRAY_LENGTH;
	        }
	        return Integer.MAX_VALUE;
	    }
	}
}
