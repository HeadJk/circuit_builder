package com.circuit_designer.circuitDevices;

import com.circuit_designer.circuitStructure.Signal;

public interface InputDeviceI {
    
    public void setInput(Signal s);

    public Signal getInput();

}
