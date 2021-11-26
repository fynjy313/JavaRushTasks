package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    public int size;

    public CustomTree() {
        this.root = new Entry("0_root");
        this.size = 1;
    }

    public Entry<String> find(int key) {
        Entry<String> current = root;
        while (current.key != key) {
            if (current.key < key) current = current.leftChild;
            else current = current.rightChild;
            if (current == null) return null;
        }
        return current;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        Entry<String> entry = new Entry<>(s);
        entry.elementName = s;
        entry.key = Integer.parseInt(entry.elementName);
        Entry<String> current = root;
        Entry<String> prev;

        this.size++;
        while (true) {
            prev = current;
            entry.parent = prev;
            if (entry.key < prev.key) {
                current = current.leftChild;
                if (current == null) {
                    prev.leftChild = entry;
                    return true;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    prev.rightChild = entry;
                    return true;
                }
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    public String getParent(String entryName) {
        Entry<String> current = find(Integer.parseInt(entryName));
        return current.parent.elementName;
    }


    public void print(Entry startEntry) {
        if (startEntry != null) {
            print(startEntry.leftChild);
            startEntry.printNode();
            print(startEntry.rightChild);
        }
    }


    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


    static class Entry<T> implements Serializable {
        public int key; //key node = elementName
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String str) {
            this.elementName = str;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public void printNode() {
            System.out.println("KEY: " + this.key + " NAME: " + elementName);
        }

        public boolean isAvailableToAddChildren() {
            return this.availableToAddLeftChildren | this.availableToAddRightChildren;
        }

    }
}
