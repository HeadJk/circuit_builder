package com.circuit_designer.circuitStructure.deviceStructure;

import com.circuit_designer.circuitStructure.DeviceI;
import com.circuit_designer.circuitStructure.busStructure.BusInterface;

// TODO Test

public class PortConnector implements PortConnectorI {

    private PortManagerI portManager;

    public PortConnector(PortManagerI portManager) {
        this.portManager = portManager;
    }

    public PortManagerI getPortManager() {
        return portManager;
    }

    @Override
    public boolean connectInPortBus(BusInterface bus, int deviceInPort) {
        assert (0 <= deviceInPort && deviceInPort < getPortManager().getInputPorts().length);
        if(getPortManager().getInputPorts()[deviceInPort] != null) return false;

        getPortManager().getInputPorts()[deviceInPort] = bus; 
        bus.attatchObserver(getPortManager());
        getPortManager().getInputPortAvailability().update();
        getPortManager().updateOutputs();
        return true;
    }

    @Override
    public boolean connectOutPortBus(BusInterface bus, int deviceOutPort) {
        assert (0 <= deviceOutPort && deviceOutPort < getPortManager().getOutputPorts().length);
        if(getPortManager().getOutputPorts()[deviceOutPort] != null) return false;

        if(bus.isAvailableInput()) {
            getPortManager().getOutputPorts()[deviceOutPort] = bus;
            bus.lockInputConnection();
            getPortManager().getOutputPortAvailability().update();
            getPortManager().updateOutputs();
            return true;
        }

        return false;
        
    }

    @Override
    public boolean disconnectInPortBus(int deviceInPort) {
        assert (0 <= deviceInPort && deviceInPort < getPortManager().getInputPorts().length);
        if(getPortManager().getInputPorts()[deviceInPort] == null) return false;

        getPortManager().getInputPorts()[deviceInPort].detatchObserver(getPortManager());
        getPortManager().getInputPorts()[deviceInPort] = null; 
        getPortManager().getInputPortAvailability().update();
        getPortManager().updateOutputs();
        return true;
    }

    @Override
    public boolean disconnectOutPortBus(int deviceOutPort) {
        assert (0 <= deviceOutPort && deviceOutPort < getPortManager().getOutputPorts().length);
        if(getPortManager().getOutputPorts()[deviceOutPort] == null) return false;
        getPortManager().getOutputPorts()[deviceOutPort].unlockInputConnection();
        getPortManager().getOutputPorts()[deviceOutPort] = null;

        getPortManager().getOutputPortAvailability().update();
        return true;
    }

    @Override
    public void disconnectAllPorts() {
        for(int i = 0; i < getPortManager().getInputPortCount(); i++) {
            getPortManager().disconnectInputBus(i);
        }
        for(int j = 0; j < getPortManager().getOutputPortCount(); j++) {
            getPortManager().disconnectOutputBus(j);
        }
        getPortManager().getInputPortAvailability().update();
        getPortManager().getOutputPortAvailability().update();
    }
    
}
