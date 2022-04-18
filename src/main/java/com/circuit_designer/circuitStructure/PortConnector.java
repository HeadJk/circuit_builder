package com.circuit_designer.circuitStructure;

// TODO Test

public class PortConnector implements PortConnectorI {

    @Override
    public boolean connectInPortBus(BusInterface bus, DeviceI device, int deviceInPort) {
        assert (0 <= deviceInPort && deviceInPort < device.getInputPorts().length);
        if(device.getInputPorts()[deviceInPort] != null) return false;

        device.getInputPorts()[deviceInPort] = bus; 
        bus.attatchObserver(device);
        device.getInputPortAvailability().update();
        device.updateOutputs();
        return true;
    }

    @Override
    public boolean connectOutPortBus(BusInterface bus, DeviceI device, int deviceOutPort) {
        assert (0 <= deviceOutPort && deviceOutPort < device.getOutputPorts().length);
        if(device.getOutputPorts()[deviceOutPort] != null) return false;

        if(bus.isAvailableInput()) {
            device.getOutputPorts()[deviceOutPort] = bus;
            bus.lockInputConnection();
            device.getOutputPortAvailability().update();
            device.updateOutputs();
            return true;
        }

        return false;
        
    }

    @Override
    public boolean disconnectInPortBus(DeviceI device, int deviceInPort) {
        assert (0 <= deviceInPort && deviceInPort < device.getInputPorts().length);
        if(device.getInputPorts()[deviceInPort] == null) return false;

        device.getInputPorts()[deviceInPort].detatchObserver(device);
        device.getInputPorts()[deviceInPort] = null; 
        device.getInputPortAvailability().update();
        device.updateOutputs();
        return true;
    }

    @Override
    public boolean disconnectOutPortBus(DeviceI device, int deviceOutPort) {
        assert (0 <= deviceOutPort && deviceOutPort < device.getOutputPorts().length);
        if(device.getOutputPorts()[deviceOutPort] == null) return false;
        device.getOutputPorts()[deviceOutPort].unlockInputConnection();
        device.getOutputPorts()[deviceOutPort] = null;

        device.getOutputPortAvailability().update();
        return true;
    }

    @Override
    public void disconnectAllPorts(DeviceI device) {
        for(int i = 0; i < device.getInputPortCount(); i++) {
            device.disconnectInputBus(i);
        }
        for(int j = 0; j < device.getOutputPortCount(); j++) {
            device.disconnectOutputBus(j);
        }
        device.getInputPortAvailability().update();
        device.getOutputPortAvailability().update();
    }
    
}
