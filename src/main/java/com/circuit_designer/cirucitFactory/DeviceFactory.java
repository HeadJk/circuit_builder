package com.circuit_designer.cirucitFactory;

import com.circuit_designer.circuitStructure.DeviceI;
import com.circuit_designer.circuitStructure.busStructure.BusInterface;

public abstract class DeviceFactory implements DeviceFactoryI {
    
    public abstract DeviceI makeComponent();

    public DeviceI makeComponentWithOutputs() {
        DeviceI component = makeComponent();
        BusFactory busFactory = new BusFactory();
        for(int i = 0; i < component.getOutputPortCount(); i++) {
            BusInterface bus = busFactory.makeBus();
            component.connectOutputBus(i, bus);
        }
        return component;
    }

}
