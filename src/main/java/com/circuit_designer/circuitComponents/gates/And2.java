package com.circuit_designer.circuitComponents.gates;

// TODO Unit test.

public class And2 extends TwoInputGate {

    public And2() {
        super("Two Input And Gate", new AndComparator());
    }
    
}
