package com.circuit_designer.cirucitFactory;

import com.circuit_designer.circuitComponents.gates.And2;

public class AndFactory extends DeviceFactory {

    @Override
    public And2 makeComponent() {
        return new And2();
    }
    
}
