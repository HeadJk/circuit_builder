package com.circuit_designer.circuitDevices.display;

import com.circuit_designer.circuitDevices.ZeroOutputDevice;
import com.circuit_designer.circuitStructure.Signal;

public abstract class DisplayDevice extends ZeroOutputDevice implements DisplayDeviceI {

    private Signal signal;

    public DisplayDevice(String name) {
        super(1, name);
    }

    @Override
    public Signal getSignal() {
        return this.signal;
    }

    @Override
    public void setSignal(Signal signal) {
        this.signal = signal;
    }

    @Override
    public void transferSignalToOutputs() {
        setSignal(getInputSignal(0));
        displaySignal();
    }
    
}
