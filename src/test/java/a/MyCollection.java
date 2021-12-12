package a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface MyCollection<E> extends Iterable<E>{
	
		default int size() {
			throw new UnsupportedOperationException();
		}

	    
	    default boolean isEmpty() {
	    	throw new UnsupportedOperationException();
	    }

	    
	    default boolean contains(Object o) {
	    	throw new UnsupportedOperationException();
	    }

	    
	    default Iterator<E> iterator() {
	    	throw new UnsupportedOperationException();
	    }

	    
	    default Object[] toArray() {
	    	throw new UnsupportedOperationException();
	    }

	    
	    default <T> T[] toArray(T[] a) {throw new UnsupportedOperationException();}

	    
	    default <T> T[] toArray(IntFunction<T[]> generator) {
	        return toArray(generator.apply(0));
	    }

	    
	    default boolean add(E e) {throw new UnsupportedOperationException();}

	    
	    default boolean remove(Object o){throw new UnsupportedOperationException();}

	    
	    default boolean containsAll(Collection<?> c){throw new UnsupportedOperationException();}

	    
	    default boolean addAll(Collection<? extends E> c){throw new UnsupportedOperationException();}

	    
	    default boolean removeAll(Collection<?> c){throw new UnsupportedOperationException();}

	    
	    default boolean removeIf(Predicate<? super E> filter) {
	        Objects.requireNonNull(filter);
	        boolean removed = false;
	        final Iterator<E> each = iterator();
	        while (each.hasNext()) {
	            if (filter.test(each.next())) {
	                each.remove();
	                removed = true;
	            }
	        }
	        return removed;
	    }

	    
	    default boolean retainAll(Collection<?> c){throw new UnsupportedOperationException();}

	    
	    default  void clear(){throw new UnsupportedOperationException();}


	    
	    boolean equals(Object o);
	    
	    int hashCode();
	    
	    @Override
	    default Spliterator<E> spliterator() {
	    	throw new UnsupportedOperationException();
	    }

	    
	    default Stream<E> stream() {
	        return StreamSupport.stream(spliterator(), false);
	    }

	    
	    default Stream<E> parallelStream() {
	        return StreamSupport.stream(spliterator(), true);
	    }
	}
