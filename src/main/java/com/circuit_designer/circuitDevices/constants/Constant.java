package com.circuit_designer.circuitDevices.constants;

import com.circuit_designer.circuitDevices.SingleOutputDevice;
import com.circuit_designer.circuitStructure.Signal;

// TODO Unit test.

public abstract class Constant extends SingleOutputDevice {

    private Signal constantSignal;

    public Constant(Signal constantSignal, String name) {
        super(0, name);
        this.constantSignal = constantSignal;
    }

    @Override
    public void transferSignalToOutputs() {
        this.setOutputSignal(0, this.constantSignal);
    }
    
}
