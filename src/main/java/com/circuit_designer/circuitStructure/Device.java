package com.circuit_designer.circuitStructure;

import com.circuit_designer.utilities.ArrayNullFinder;
import com.circuit_designer.utilities.ArrayNullFinderI;

// TODO Unit test.

public abstract class Device implements DeviceI {

    private String name;
    private PortConnectorI portConnector = new PortConnector();
    private BusInterface[] outputPorts;
    private BusInterface[] inputPorts;
    private ArrayNullFinderI inputPortAvailability;
    private ArrayNullFinderI outputPortAvailability;

    public Device(int inputPortCount, int outputPortCount, String name) {
        this.inputPorts = new BusInterface[inputPortCount];
        this.outputPorts = new BusInterface[outputPortCount];
        this.name = name;
        this.inputPortAvailability = new ArrayNullFinder(this.inputPorts);
        this.outputPortAvailability = new ArrayNullFinder(this.outputPorts);
    }

    protected abstract void transferSignalToOutputs();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void updateOutputs() {
        transferSignalToOutputs();
    }

    @Override
    public Signal getInputSignal(int portIndex) {
        assert (0 <= portIndex && portIndex < inputPorts.length);
        BusInterface bus = getInputBus(portIndex);
        return bus != null ? bus.getSignal() : Signal.UNKNOWN;
    }

    @Override
    public Signal getOutputSignal(int portIndex) {
        assert (0 <= portIndex && portIndex < outputPorts.length);
        BusInterface bus = getOutputBus(portIndex);
        return bus != null ? bus.getSignal() : Signal.UNKNOWN;
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
        return portConnector.connectOutPortBus(bus, this, portIndex);
    }

    @Override
    public boolean disconnectOutputBus(int portIndex) {
        return portConnector.disconnectOutPortBus(this, portIndex);
    }

    @Override
    public boolean connectInputBus(int portIndex, BusInterface bus) {
        return portConnector.connectInPortBus(bus, this, portIndex);
    }

    @Override
    public boolean disconnectInputBus(int portIndex) {
        return portConnector.disconnectInPortBus(this, portIndex);
    }

    @Override
    public void disconnectAllPorts() {
        portConnector.disconnectAllPorts(this);
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
