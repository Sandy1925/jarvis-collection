package com.sk.jedis.jarviscollection.dynamicarray;

import com.sk.jedis.jarviscollection.dynamicarray.exceptions.InvalidSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JarvisArrayImplementationTest {

    @Test
    void add() {
        JarvisArray<Integer> arr = new JarvisArrayImplementation<>();
        boolean added = arr.add(1);
        assertTrue(added);
        assertEquals(1,arr.size());
        assertEquals(arr.get(0),1);
    }

    @Test
    void addException(){

        assertThrows(InvalidSizeException.class,()->{
            JarvisArray<Integer> arr = new JarvisArrayImplementation<>(0);
        });
    }

    @Test
    public void isEmptyCheck(){
        JarvisArray<Integer> arr = new JarvisArrayImplementation<>();
        boolean isEmpty = arr.isEmpty();
        assertTrue(isEmpty);
        arr.add(12);
        arr.add(1,23);
        assertFalse(arr.isEmpty());
        assertEquals(2,arr.size());
    }
}