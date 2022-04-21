package com.circuit_designer.circuitDevices.display;

import com.circuit_designer.circuitStructure.Signal;

public interface DisplayDeviceI {

    public void displaySignal();

    public Signal getSignal();

    public void setSignal(Signal signal);
    
}
