package binarySearchTree;

import java.util.Collection;
import java.util.Iterator;

public interface Tree<E> extends Collection<E> {
	
	public boolean search(E e); 
	
	public boolean insert(E e);
	
	public boolean delete(E e);
	
	public int getSize();
	
	public default void inorder() {
		
	}
	
	public default void postorder() {
		
	}
	
	public default void preorder() {
		
	}
	
	@Override
	public default boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public default boolean contains(Object e) {
		return search((E) e);
	}
	
	@Override
	public default boolean add(E e) {
		return insert(e);
	}
	
	@Override
	public default boolean remove(Object e) {
		return delete((E) e);
	}
	
	@Override
	public default int size() {
		return getSize();
	}
	
	@Override
	public default boolean containsAll(Collection<?> c) {
		boolean result =  false;
		Iterator<?> iter = c.iterator();
		for(int i = 0; i < c.size(); i++) {
			result = contains(iter.next());
		}
		return result;
	}
	
	@Override
	public default boolean addAll(Collection<? extends E> c) {
		Iterator<? extends E> iter = c.iterator();
		while(iter.hasNext()) {
			add((E)iter.next());
		}
		return true;
	}
	
	@Override
	public default boolean removeAll(Collection<?> c) {
		Iterator<?> iter = c.iterator();
		while(iter.hasNext()) {
			E next = (E)iter.next();
			remove(next);
		}
		return true;
	}
	
	@Override
	public default boolean retainAll(Collection<?> c) {
		// TODO
		return false;
	}
	
	@Override
	public default Object[] toArray() {
		return null;
	}
	
}
