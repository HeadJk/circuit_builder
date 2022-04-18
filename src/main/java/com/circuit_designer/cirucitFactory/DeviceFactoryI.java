package com.circuit_designer.cirucitFactory;

import com.circuit_designer.circuitStructure.DeviceI;

public interface DeviceFactoryI {
    
    public DeviceI makeComponent();

    public DeviceI makeComponentWithOutputs();

}
