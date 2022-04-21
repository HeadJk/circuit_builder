package com.circuit_designer.circuitDevices.gates;

import com.circuit_designer.circuitDevices.SingleOutputDevice;

// TODO Unit test.

public abstract class Gate extends SingleOutputDevice {

    public Gate(int inputPortCount, String name) {
        super(inputPortCount, 1, name);
    }
    
}
