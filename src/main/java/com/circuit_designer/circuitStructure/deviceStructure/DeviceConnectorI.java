package com.circuit_designer.circuitStructure.deviceStructure;

import com.circuit_designer.circuitStructure.DeviceI;

public interface DeviceConnectorI {
    
    public void connectComponents(
        DeviceI inputComp, int inputCompPort,
        DeviceI outputComp, int outputCompPort
    );

    public void connectComponents(DeviceI inputComp, DeviceI outputComp);

}
