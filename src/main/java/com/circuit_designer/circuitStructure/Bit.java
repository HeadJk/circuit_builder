package com.circuit_designer.circuitStructure;

public enum Bit {
    
    UNKNOWN("-"),
    HIGH("1"),
    LOW("0");

    private String signalString;

    Bit(String s) {
        this.signalString = s;
    }

    @Override
    public String toString() {
        return this.signalString;
    }

}
