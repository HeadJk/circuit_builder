package com.circuit_designer.unit.time;

import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    public void correctTimeUnit() {
        Time nanoSeconds = new NanoSecond(5);
        Time microSeconds = new MicroSecond(5);
        Time seconds = new Second(5);

        System.out.println(nanoSeconds.toString());
        System.out.println(microSeconds.toString());
        System.out.println(seconds.toString());
    }

    
}
