package com.circuit_designer.circuitDevices;

import com.circuit_designer.circuitStructure.Device;

// TODO Unit test.

public abstract class SingleOutputDevice extends Device {

    public SingleOutputDevice(int inputPortCount, String name) {
        super(inputPortCount, 1, name);
    }
    
}
