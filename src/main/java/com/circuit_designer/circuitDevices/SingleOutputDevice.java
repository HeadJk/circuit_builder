package com.circuit_designer.circuitDevices;

import com.circuit_designer.circuitStructure.Device;

// TODO Unit test.

public abstract class SingleOutputDevice extends Device {

    public SingleOutputDevice(int inputPortCount, int outputPortCount, String name) {
        super(inputPortCount, outputPortCount, name);
    }
    
}
