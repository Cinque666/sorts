package by.com.andersen;

import by.com.andersen.collections.CollectionImpl;
import by.com.andersen.collections.exception.WrongIndexException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private final List<Integer> readOnly = new ArrayList<>();

    public void addElement(Integer element){
        readOnly.add(element);
    }

    public List<Integer> getCollection(){
        return readOnly;
    }

    public static void main(String[] args) throws WrongIndexException {

        Main main = new Main();
        CollectionImpl<Main> collection = new CollectionImpl<>();
        collection.add(main);
        System.out.println(collection.contains(main));
        System.out.println(collection.size());
        collection.add(main);
        System.out.println(collection.size());
        collection.remove(main);
        System.out.println(collection.size());
    }
}
