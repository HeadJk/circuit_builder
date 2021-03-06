package com.circuit_designer.circuitStructure;

import com.circuit_designer.circuitStructure.busStructure.BusInterface;

public interface DeviceI {

    public void transferSignalToOutputs();

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

}
