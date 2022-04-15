package com.circuit_designer.circuitComponents.gates;

import com.circuit_designer.circuitStructure.*;

public abstract class Gate extends AbstractComponent {

    public Gate(int inputPortCount, String name) {
        super(inputPortCount, 1, name);
    }

    @Override
    protected abstract void computeSignal();
    
}
