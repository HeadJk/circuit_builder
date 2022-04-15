package com.circuit_designer.unit.prefix;

public abstract class AbstractPrefix implements PrefixInterface {

    private String prefix;
    private double ratio;

    public AbstractPrefix(String prefix, double ratio) {
        this.prefix = prefix;
        this.ratio = ratio;
    }

    @Override
    public double getRatio() {
        return this.ratio;
    }

    @Override
    public String toString() {
        return this.prefix;
    }
    
}
