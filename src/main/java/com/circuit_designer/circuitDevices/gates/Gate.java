package com.circuit_designer.circuitDevices.gates;

import com.circuit_designer.circuitDevices.UnaryOutputDevice;

// TODO Unit test.

public abstract class Gate extends UnaryOutputDevice {

    public Gate(int inputPortCount, String name) {
        super(inputPortCount, 1, name);
    }
    
}
