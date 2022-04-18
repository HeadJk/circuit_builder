package com.circuit_designer.utilities;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class ArrayNullFinderTest {
    
    @Test
    public void findNextNullElem() {
        Object[] array = {4, 5, null, 6};

        ArrayNullFinder af = new ArrayNullFinder(array);
        Assertions.assertEquals(2, af.getNextNullElementIndex()); 

        array[0] = null;
        Assertions.assertEquals(2, af.getNextNullElementIndex());

        af.update();
        Assertions.assertEquals(0, af.getNextNullElementIndex());

        array[0] = 3;
        array[2] = 5;
        Assertions.assertEquals(0, af.getNextNullElementIndex());

        af.update();
        Assertions.assertEquals(-1, af.getNextNullElementIndex());
    }

}
