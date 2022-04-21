package com.circuit_designer.cirucitFactory;

import com.circuit_designer.circuitDevices.display.LoggerDisplay;
import com.circuit_designer.circuitStructure.DeviceI;

public class LoggerDisplayFactory implements DisplayDeviceFactoryI {

    @Override
    public DeviceI makeComponent(String displayName) {
        return new LoggerDisplay(displayName);
    }
    
}
