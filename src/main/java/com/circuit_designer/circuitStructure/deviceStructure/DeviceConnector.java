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
    ) throws Exception {
        BusFactory busFactory = new BusFactory();
        BusInterface bus = busFactory.makeBus();

        if(inputComp.getOutputBus(inputCompPort) == null) {
            inputComp.connectOutputBus(inputCompPort, bus);
        } else {
            bus = inputComp.getOutputBus(inputCompPort);
        }

        boolean c2 = outputComp.connectInputBus(outputCompPort, bus);

        if(!c2) throw new Exception(
            "Error encountered when connecting devices.\n" + inputComp.getName() + "->" + outputComp.getName()
        );
    }

    @Override
    public void connectComponents(DeviceI inputComp, DeviceI outputComp) throws Exception {
        try {
            connectComponents(
                inputComp, 
                0,
                outputComp, 
                outputComp.getNextAvailableInputPort()
            );
        } catch(Exception ex) {
            throw ex;
        }
    }

    @Override
    public void connectComponents(DeviceI inputComp, int inputCompPort, DeviceI outputComp) throws Exception {
        try {
            connectComponents(
                inputComp, 
                inputCompPort,
                outputComp, 
                outputComp.getNextAvailableInputPort()
            );
        } catch(Exception ex) {
            throw ex;
        }
    }
    
}
