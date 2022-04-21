package com.circuit_designer.cirucitFactory;

import com.circuit_designer.circuitStructure.DeviceI;

public interface DisplayDeviceFactoryI {

    public DeviceI makeComponent(String displayName);
    
}
