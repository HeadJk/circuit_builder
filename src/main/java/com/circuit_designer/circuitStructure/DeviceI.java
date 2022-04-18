package com.circuit_designer.circuitStructure;

import com.circuit_designer.utilities.ArrayNullFinderI;

public interface DeviceI extends SignalObserver {

    public void updateOutputs();

    public Signal getInputSignal(int portIndex);

    public Signal getOutputSignal(int portIndex);

    public BusInterface getInputBus(int portIndex);

    public BusInterface getOutputBus(int portIndex);

    public boolean connectOutputBus(int portIndex, BusInterface bus);

    public boolean connectInputBus(int portIndex, BusInterface bus);

    public boolean disconnectInputBus(int portIndex);

    public boolean disconnectOutputBus(int portIndex);

    public void disconnectAllPorts();

    public int getInputPortCount();

    public int getOutputPortCount();
    
    public String getName();

    public int getNextAvailableOutputPort();

    public int getNextAvailableInputPort();

    public boolean hasAllInputPortsConnected();

    public boolean hasAllOutputPortsConnected();

    @Override
    public String toString();

    // Get rid of after refactor
    public BusInterface[] getOutputPorts();
    public BusInterface[] getInputPorts();
    public ArrayNullFinderI getInputPortAvailability();
    public ArrayNullFinderI getOutputPortAvailability();

}
