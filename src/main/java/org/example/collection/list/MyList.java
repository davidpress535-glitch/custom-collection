package org.example.collection.list;

public interface MyList {

	void add(Object element);

	void add(int index, Object element);

	void addFirst(Object element);

	void addLast(Object element);

	Object get(int index);

	Object remove(int index);

	boolean remove(Object element);

	int size();

	boolean isEmpty();

	void clear();
}
