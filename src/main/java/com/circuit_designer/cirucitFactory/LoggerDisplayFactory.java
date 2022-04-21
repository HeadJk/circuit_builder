package com.circuit_designer.cirucitFactory;

import com.circuit_designer.circuitDevices.display.LoggerDisplay;
import com.circuit_designer.circuitStructure.DeviceI;

public class LoggerDisplayFactory extends DeviceFactory {

    @Override
    public DeviceI makeComponent() {
        return new LoggerDisplay();
    }
    
}
