package com.circuit_designer.unit;

import com.circuit_designer.unit.prefix.PrefixInterface;

public abstract class AbstractUnit implements UnitInterface {

    private String unit;
    private PrefixInterface prefix;
    private double value;

    public AbstractUnit(double value, PrefixInterface prefix, String unit) {
        this.prefix = prefix;
        this.value = value;
        this.unit = unit;
    }

    @Override
    public String getUnit() {
        return this.unit;
    }

    @Override
    public PrefixInterface getPrefix() {
        return this.prefix;
    }

    @Override
    public double getNoPrefixValue() {
        return this.value * getPrefix().getRatio();
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(getValue()) + getPrefix().toString() + getUnit();
    }
    
}
