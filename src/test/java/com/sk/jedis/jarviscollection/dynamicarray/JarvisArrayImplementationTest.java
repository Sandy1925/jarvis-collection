package com.sk.jedis.jarviscollection.dynamicarray;

import com.sk.jedis.jarviscollection.dynamicarray.exceptions.InvalidSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JarvisArrayImplementationTest {

    @Test
    void add() {
        JarvisArray arr = new JarvisArrayImplementation();
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
}