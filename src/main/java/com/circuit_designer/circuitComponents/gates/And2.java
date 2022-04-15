package com.circuit_designer.circuitComponents.gates;

public class And2 extends TwoInputGate {

    public And2() {
        super("Two Input And Gate", new AndComparator());
    }
    
}
