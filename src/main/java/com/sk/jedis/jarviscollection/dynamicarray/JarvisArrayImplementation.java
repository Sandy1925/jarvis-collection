package com.sk.jedis.jarviscollection.dynamicarray;

import com.sk.jedis.jarviscollection.dynamicarray.exceptions.InvalidSizeException;

public class JarvisArrayImplementation<T> implements JarvisArray<T> {

    private Object[] elements;
    private int size;

    public JarvisArrayImplementation(){
        this.size =10;
        this.elements = new Object[10];
    }

    public JarvisArrayImplementation(int initialCapacity){
        if(initialCapacity<=0){
            throw new InvalidSizeException("Initial Capacity can't be zero");
        }
        this.size =initialCapacity;
        this.elements = new Object[initialCapacity];
    }

    @Override
    public boolean add(T element) {
       try {
           if (this.size == this.elements.length) {
               resize();
           }
           elements[size()] = element;
           grow();
       }catch(Exception ex){
           return false;
       }
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        return false;
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    public boolean set(int index, T element) {
        return false;
    }

    @Override
    public int size() {
        int result =0;

        for(int i=0;i<elements.length;i++){
            if(elements[i] !=null){
                result++;
            }
        }
        return result;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean isEmpty() {
        return elements.length ==0;
    }

    private void resize(){
        int newCapacity = this.size*2;
        Object[] newArray = new Object[newCapacity];
        for(int i=0;i< elements.length;i++){
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    private int grow(){
        return this.size*2;
    }
}
