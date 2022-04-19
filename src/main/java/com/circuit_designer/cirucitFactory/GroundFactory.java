package com.circuit_designer.cirucitFactory;

import com.circuit_designer.circuitDevices.constants.Ground;

public class GroundFactory extends DeviceFactory {

    @Override
    public Ground makeComponent() {
        return new Ground();
    }
    
}
