package by.com.andersen.collections;

import by.com.andersen.collections.exception.WrongIndexException;

import java.util.*;

public class CollectionImpl<T> implements Collection<T>, Iterable<T> {

    private Object[] items;
    private int size;

    public CollectionImpl() {
        items = new Object[]{};
        size = 0;
    }

    public CollectionImpl(int capacity) {
        items = new Object[capacity];
        size = capacity;
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
    public boolean contains(Object o) {
        return search(o);
    }

    private boolean search(Object o) {
        if (o == null) {
            for (Object item : items) {
                if (item == null) {
                    return true;
                }
            }
        } else {
            for (Object item : items) {
                if (item.equals(o)) {
                    return item.equals(o);
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && items[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) items[currentIndex++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(items, size, a.getClass());
        }
        System.arraycopy(items, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(T t) {
        if (size == items.length) {
            items = increaseCapacity();
            items[items.length - 1] = t;
            size++;
            return true;
        }
        return false;
    }

    public T get(int index) throws WrongIndexException {
        if (index >= size || index < 0) {
            throw new WrongIndexException("Wrong index");
        } else {
            return (T) items[index];
        }
    }

    private Object[] increaseCapacity() {
        return items = Arrays.copyOf(items, size + 1);
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (items[i].equals(o)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void remove(int index) {
        final int newSize;
        if ((newSize = size - 1) > index)
            System.arraycopy(items, index + 1, items, index, newSize - index);
        items[size = newSize] = null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size() > size) {
            return false;
        }
        return checkEntries(c) == c.size();
    }

    private int checkEntries(Collection<?> c){
        int counter = 0;
        Iterator cIt = c.iterator();
        while (cIt.hasNext()) {
            for (Object item : items) {
                if (cIt.equals(item)) {
                    counter++;
                }
            }
            cIt.next();
        }
        return counter;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }
        Object[] cArr = c.toArray();
        if(cArr.length > items.length){
            copyArray(cArr, 0, items, size, size + cArr.length);
        } else {
            copyArray(items, 0, cArr, cArr.length, size+ cArr.length);
        }
        increaseCapacity(cArr.length);
        return true;
    }

    private void copyArray(Object[] first, int srcPos, Object[] second, int secongLength, int newSize){
        System.arraycopy(first, srcPos, second, second.length, newSize);
    }

    private void increaseCapacity(int size){
        items = Arrays.copyOf(items, this.size + size);
        this.size = this.size + size;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(c.size() == 0){
            return false;
        }
        setNullable(c);
        return true;
    }

    private void setNullable(Collection<?> c){
        Iterator cIt = c.iterator();
        while(cIt.hasNext()){
            for(int i = 0; i< size; i++){
                if(cIt.equals(items[i])){
                    items[i] = null;
                }
            }
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(c.size() == 0){
            return false;
        }
        final Object[] temp = new Object[checkEntries(c)];
        retain(c, temp);
        items = temp;
        return true;
    }

    private void retain(Collection<?> c, Object[] temp) {
        int counter = 0;
        Iterator cIt = c.iterator();
        while (cIt.hasNext()) {
            for (int i = 0; i < size; i++) {
                if (cIt.equals(items[i])){
                    temp[counter] = items[i];
                    counter++;
                }
            }
        }
    }

    @Override
    public void clear() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                items[i] = null;
            }
        }
    }
}
