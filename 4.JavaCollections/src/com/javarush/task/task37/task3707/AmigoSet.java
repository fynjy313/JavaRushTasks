package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;


    public AmigoSet() {
        this.map = new HashMap<>();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }

    public AmigoSet(Collection<? extends E> collection) {
        double capacity = Math.max(16, Math.ceil(collection.size() / .75f));
        this.map = new HashMap<>((int) capacity);
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> amigoSet = (AmigoSet<E>) super.clone();
            amigoSet.map = (HashMap<E, Object>) this.map.clone();
            return amigoSet;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        int capacity = HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor");
        oos.writeInt(capacity);
        oos.writeFloat(loadFactor);
        oos.writeInt(map.size());
        if (map.size() == size())
            for (E e : map.keySet()) oos.writeObject(e);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        int size = ois.readInt();

        for (int i = 0; i < size; i++) {
            E e = (E) ois.readObject();
            map.put(e, PRESENT);
        }

    }
}
