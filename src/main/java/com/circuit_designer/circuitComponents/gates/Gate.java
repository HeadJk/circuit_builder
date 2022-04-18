package com.circuit_designer.circuitComponents.gates;

import com.circuit_designer.circuitStructure.*;

// TODO Unit test.

public abstract class Gate extends UnaryOutputDevice {

    public Gate(int inputPortCount, String name) {
        super(inputPortCount, 1, name);
    }

    @Override
    protected abstract void transferSignalToOutputs();
    
}
