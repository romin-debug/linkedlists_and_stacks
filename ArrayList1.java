package Assignment1;

import java.util.Iterator;

public class ArrayList1<E> implements List<E> {
    private Object[] array;
    private int size;
    private int capacity;

    public ArrayList1() {
        capacity = 4;
        array = new Object[capacity];
    }

    private void resize() {
        int newCapacity = capacity * 2;
        if (size < capacity / 4) {
            newCapacity = capacity / 2;
        }
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        capacity = newCapacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @Override
    public E set(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E) array[index];
        array[index] = e;
        return oldValue;
    }

    @Override
    public void add(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            resize();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = e;
        size++;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removedElement = (E) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        if (size < capacity / 4) {
            resize();
        }
        return removedElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return (E) array[currentIndex++];
        }
    }
}
