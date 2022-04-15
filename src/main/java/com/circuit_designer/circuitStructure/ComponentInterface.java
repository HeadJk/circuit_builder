package com.circuit_designer.circuitStructure;

public interface ComponentInterface extends SignalObserver {

    public void updateOutput();

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

    @Override
    public String toString();

}
