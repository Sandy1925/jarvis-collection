package com.sk.jedis.jarviscollection.dynamicarray;

import com.sk.jedis.jarviscollection.dynamicarray.exceptions.InvalidSizeException;

import java.util.logging.Logger;

public class JarvisArrayImplementation<T> implements JarvisArray<T> {

    private Object[] elements;
    private int size;
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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
           if (this.size == size()) {
               resize();
           }
           elements[size()] = element;
           this.size= elements.length;
       }catch(Exception ex){
           return false;
       }
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if(index>= this.size){
            resize();
        }
        try{
            elements[index] = element;
            this.size= elements.length;
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    public boolean set(int index, T element) {

        if(index>= this.size){
            throw new InvalidSizeException("Index out of bound");
        }
        try{
            elements[index] = element;
        }catch(Exception e){
            return false;
        }
        return true;
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
        if(index>= this.size){
            throw new InvalidSizeException("Index out of bound");
        }
        elements[index] = null;
    }

    @Override
    public boolean isEmpty() {
        return size() ==0;
    }

    private void resize(){
        int newCapacity = this.size*2;
        Object[] newArray = new Object[newCapacity];
        for(int i=0;i< size();i++){
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

}
