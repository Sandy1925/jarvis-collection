package com.sk.jedis.jarviscollection.dynamicarray;

public interface JarvisArray<T> {
    public boolean add(T element);
    public boolean add(int index, T element);

    public T get(int index);
    public boolean set(int index, T element);

    public int size();

    public void remove(int index);

    public boolean isEmpty();
}
