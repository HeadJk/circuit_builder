package com.circuit_designer.unit.time;

import com.circuit_designer.unit.prefix.Nano;

public class NanoSecond extends Time {

    public NanoSecond(double value) {
        super(value, new Nano());
    }
    
}
