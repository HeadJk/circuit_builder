package com.circuit_designer.circuitComponents.constants;

import com.circuit_designer.circuitStructure.Signal;
import com.circuit_designer.circuitStructure.UnaryOutputDevice;

// TODO Unit test.

public abstract class Constant extends UnaryOutputDevice {

    private Signal constantSignal;

    public Constant(Signal constantSignal, String name) {
        super(0, 1, name);
        this.constantSignal = constantSignal;
    }

    @Override
    protected void transferSignalToOutputs() {
        this.getOutputBus(0).setSignal(this.constantSignal);
    }
    
}
