package com.circuit_designer.circuitStructure;

public enum Signal {
    
    UNKNOWN("-"),
    HIGH("1"),
    LOW("0");

    private String signalString;

    Signal(String s) {
        this.signalString = s;
    }

    @Override
    public String toString() {
        return this.signalString;
    }

}
