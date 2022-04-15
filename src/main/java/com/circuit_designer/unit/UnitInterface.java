package com.circuit_designer.unit;

import com.circuit_designer.unit.prefix.PrefixInterface;

public interface UnitInterface {

    public String getUnit();

    public PrefixInterface getPrefix();

    public double getNoPrefixValue();

    public double getValue();

    public String toString();
    
}
