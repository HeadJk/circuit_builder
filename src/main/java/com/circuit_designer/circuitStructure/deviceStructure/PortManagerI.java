package com.circuit_designer.circuitStructure.deviceStructure;

import com.circuit_designer.circuitStructure.busStructure.BusInterface;
import com.circuit_designer.utilities.ArrayNullFinderI;

public interface PortManagerI extends SignalObserver {

    public void updateOutputs();

    public BusInterface getInputBus(int portIndex);

    public BusInterface getOutputBus(int portIndex);

    public boolean connectOutputBus(int portIndex, BusInterface bus);

    public boolean connectInputBus(int portIndex, BusInterface bus);

    public boolean disconnectInputBus(int portIndex);

    public boolean disconnectOutputBus(int portIndex);

    public void disconnectAllPorts();

    public int getInputPortCount();

    public int getOutputPortCount();

    public int getNextAvailableOutputPort();

    public int getNextAvailableInputPort();

    public boolean hasAllInputPortsConnected();

    public boolean hasAllOutputPortsConnected();

    public BusInterface[] getInputPorts();

    public BusInterface[] getOutputPorts();

    public ArrayNullFinderI getInputPortAvailability();

    public ArrayNullFinderI getOutputPortAvailability();
    
}
