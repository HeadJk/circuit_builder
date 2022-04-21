package com.circuit_designer.circuitStructure.deviceStructure;

import com.circuit_designer.circuitStructure.DeviceI;
import com.circuit_designer.circuitStructure.busStructure.BusInterface;
import com.circuit_designer.cirucitFactory.BusFactory;

// TODO Unit test.

public class DeviceConnector implements DeviceConnectorI {

    @Override
    public void connectComponents(
        DeviceI inputComp, int inputCompPort, 
        DeviceI outputComp,int outputCompPort
    ) {
        BusFactory busFactory = new BusFactory();
        BusInterface bus = busFactory.makeBus();

        boolean c1 = inputComp.connectOutputBus(inputCompPort, bus);
        boolean c2 = outputComp.connectInputBus(outputCompPort, bus);

        if(!c1 || !c2) {
            System.out.println("Error connecting component " + inputComp.getName() + " to " + outputComp.getName());
        }
    }

    @Override
    public void connectComponents(DeviceI inputComp, DeviceI outputComp) {
        connectComponents(
            inputComp, 
            inputComp.getNextAvailableOutputPort(),
            outputComp, 
            outputComp.getNextAvailableInputPort()
        );
    }
    
}
