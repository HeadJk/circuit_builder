package com.circuit_designer.circuitStructure;

public interface PortConnectorI {
    
    public boolean connectInPortBus(BusInterface bus, DeviceI device, int deviceInPort);

    public boolean connectOutPortBus(BusInterface bus, DeviceI device, int deviceOutPort);

    public boolean disconnectInPortBus(DeviceI device, int deviceInPort);

    public boolean disconnectOutPortBus(DeviceI device, int deviceOutPort);

    public void disconnectAllPorts(DeviceI device);

}
