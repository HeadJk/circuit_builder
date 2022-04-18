package com.circuit_designer.circuitStructure;

import com.circuit_designer.cirucitFactory.BusFactory;

// TODO Unit test.

public class DeviceConnector implements DeviceConnectorI {

    @Override
    public void connectComponents(
        DeviceI inputComp, int inputCompPort, 
        DeviceI outputComp,int outputCompPort
    ) {
        BusInterface bus;

        if(inputComp.getOutputBus(inputCompPort) == null) {
            BusFactory busFactory = new BusFactory();
            bus = busFactory.makeBus();
            inputComp.connectOutputBus(inputCompPort, bus);
        } else {
            bus = inputComp.getInputBus(inputCompPort);
        }
        
        try {
            tryConnecting(outputComp, outputCompPort, bus);
        } catch(Exception ex) {
            throw ex;
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

    private void tryConnecting(DeviceI outputComp, int outputCompPort, BusInterface inputBus) {
        boolean succesfulConnection = outputComp.connectInputBus(outputCompPort, inputBus);
        if(!succesfulConnection) System.out.println("Component Connection Error.");
    }
    
}
