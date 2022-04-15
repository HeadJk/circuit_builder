package com.circuit_designer.unit.time;

import com.circuit_designer.unit.prefix.Micro;

public class MicroSecond extends Time {

    public MicroSecond(double value) {
        super(value, new Micro());
    }
    
}
