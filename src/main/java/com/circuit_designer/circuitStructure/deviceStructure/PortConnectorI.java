package com.circuit_designer.circuitStructure.deviceStructure;

import com.circuit_designer.circuitStructure.busStructure.BusInterface;

public interface PortConnectorI {
    
    public boolean connectInPortBus(BusInterface bus, int deviceInPort);

    public boolean connectOutPortBus(BusInterface bus, int deviceOutPort);

    public boolean disconnectInPortBus(int deviceInPort);

    public boolean disconnectOutPortBus(int deviceOutPort);

    public void disconnectAllPorts();

}
