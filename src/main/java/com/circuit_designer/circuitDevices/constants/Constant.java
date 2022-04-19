package com.circuit_designer.circuitDevices.constants;

import com.circuit_designer.circuitDevices.UnaryOutputDevice;
import com.circuit_designer.circuitStructure.Signal;

// TODO Unit test.

public abstract class Constant extends UnaryOutputDevice {

    private Signal constantSignal;

    public Constant(Signal constantSignal, String name) {
        super(0, 1, name);
        this.constantSignal = constantSignal;
    }

    @Override
    public void transferSignalToOutputs() {
        this.getOutputBus(0).setSignal(this.constantSignal);
    }
    
}