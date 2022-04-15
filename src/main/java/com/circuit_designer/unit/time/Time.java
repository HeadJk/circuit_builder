package com.circuit_designer.unit.time;

import com.circuit_designer.unit.AbstractUnit;
import com.circuit_designer.unit.prefix.PrefixInterface;

public abstract class Time extends AbstractUnit {

    public Time(double value, PrefixInterface prefix) {
        super(value, prefix, "s");
    }
    
}
