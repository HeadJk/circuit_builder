package com.circuit_designer.circuitDevices;

import com.circuit_designer.circuitStructure.Device;

public abstract class ZeroOutputDevice extends Device {

    public ZeroOutputDevice(int inputPortCount, String name) {
        super(inputPortCount, 0, name);
    }
    
}
