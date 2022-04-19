package com.circuit_designer.circuitStructure.deviceStructure;

import com.circuit_designer.circuitStructure.DeviceI;
import com.circuit_designer.circuitStructure.busStructure.BusInterface;
import com.circuit_designer.utilities.ArrayNullFinder;
import com.circuit_designer.utilities.ArrayNullFinderI;

public class PortManager implements PortManagerI {

    private DeviceI device;
    private PortConnectorI portConnector;
    private BusInterface[] outputPorts;
    private BusInterface[] inputPorts;
    private ArrayNullFinderI inputPortAvailability;
    private ArrayNullFinderI outputPortAvailability;

    public PortManager(DeviceI device, int inputPortCount, int outputPortCount) {
        this.inputPorts = new BusInterface[inputPortCount];
        this.outputPorts = new BusInterface[outputPortCount];
        this.inputPortAvailability = new ArrayNullFinder(this.inputPorts);
        this.outputPortAvailability = new ArrayNullFinder(this.outputPorts);
        this.portConnector = new PortConnector(this);
        this.device = device;
    }

    public DeviceI getDevice() {
        return device;
    }

    @Override
    public void updateOutputs() {
        getDevice().transferSignalToOutputs();
    }

    @Override
    public BusInterface getInputBus(int portIndex) {
        assert (0 <= portIndex && portIndex < inputPorts.length);
        return this.inputPorts[portIndex];
    }

    @Override
    public BusInterface getOutputBus(int portIndex) {
        assert (0 <= portIndex && portIndex < outputPorts.length);
        return this.outputPorts[portIndex];
    }

    @Override
    public boolean connectOutputBus(int portIndex, BusInterface bus) {
        return portConnector.connectOutPortBus(bus, portIndex);
    }

    @Override
    public boolean disconnectOutputBus(int portIndex) {
        return portConnector.disconnectOutPortBus(portIndex);
    }

    @Override
    public boolean connectInputBus(int portIndex, BusInterface bus) {
        return portConnector.connectInPortBus(bus, portIndex);
    }

    @Override
    public boolean disconnectInputBus(int portIndex) {
        return portConnector.disconnectInPortBus(portIndex);
    }

    @Override
    public void disconnectAllPorts() {
        portConnector.disconnectAllPorts();
    }

    @Override
    public int getInputPortCount() {
        return this.inputPorts.length;
    }

    @Override
    public int getOutputPortCount() {
        return this.outputPorts.length;
    }

    @Override
    public int getNextAvailableInputPort() {
        return this.inputPortAvailability.getNextNullElementIndex();
    }

    @Override
    public int getNextAvailableOutputPort() {
        return this.outputPortAvailability.getNextNullElementIndex();
    }

    @Override
    public boolean hasAllInputPortsConnected() {
        return this.inputPortAvailability.getNextNullElementIndex() == -1;
    }

    @Override
    public boolean hasAllOutputPortsConnected() {
        return this.outputPortAvailability.getNextNullElementIndex() == -1;
    }

    // Get rid of after refactor
    public BusInterface[] getOutputPorts() { return outputPorts; }
    public BusInterface[] getInputPorts() { return inputPorts; }
    public ArrayNullFinderI getInputPortAvailability() { return inputPortAvailability;}
    public ArrayNullFinderI getOutputPortAvailability() { return outputPortAvailability; }
    
}
