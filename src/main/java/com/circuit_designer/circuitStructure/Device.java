package com.circuit_designer.circuitStructure;

import com.circuit_designer.circuitStructure.busStructure.BusInterface;
import com.circuit_designer.circuitStructure.deviceStructure.PortManager;
import com.circuit_designer.circuitStructure.deviceStructure.PortManagerI;

// TODO Unit test.

public abstract class Device implements DeviceI {

    private String name;
    private PortManagerI portManager;

    public Device(int inputPortCount, int outputPortCount, String name) {
        this.name = name;
        this.portManager = new PortManager(this, inputPortCount, outputPortCount);
    }

    public abstract void transferSignalToOutputs();

    public PortManagerI getPortManager() {
        return portManager;
    }

    public boolean setOutputSignal(int portIndex, Signal s) {
        BusInterface bus = getPortManager().getOutputBus(portIndex);
        if(bus != null) bus.setSignal(s);
        else return false;
        return true;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Signal getInputSignal(int portIndex) {
        BusInterface bus = getPortManager().getInputBus(portIndex);
        return bus != null ? bus.getSignal() : Signal.UNKNOWN;
    }

    @Override
    public Signal getOutputSignal(int portIndex) {
        BusInterface bus = getPortManager().getOutputBus(portIndex);
        return bus != null ? bus.getSignal() : Signal.UNKNOWN;
    }

    @Override
    public BusInterface getInputBus(int portIndex) {
        return getPortManager().getInputBus(portIndex);
    }

    @Override
    public BusInterface getOutputBus(int portIndex) {
        return getPortManager().getOutputBus(portIndex);
    }

    @Override
    public boolean connectOutputBus(int portIndex, BusInterface bus) {
        return getPortManager().connectOutputBus(portIndex, bus);
    }

    @Override
    public boolean disconnectOutputBus(int portIndex) {
        return getPortManager().disconnectOutputBus(portIndex);
    }

    @Override
    public boolean connectInputBus(int portIndex, BusInterface bus) {
        return getPortManager().connectInputBus(portIndex, bus);
    }

    @Override
    public boolean disconnectInputBus(int portIndex) {
        return getPortManager().disconnectInputBus(portIndex);
    }

    @Override
    public void disconnectAllPorts() {
        getPortManager().disconnectAllPorts();
    }

    @Override
    public int getInputPortCount() {
        return getPortManager().getInputPortCount();
    }

    @Override
    public int getOutputPortCount() {
        return getPortManager().getOutputPortCount();
    }

    @Override
    public int getNextAvailableInputPort() {
        return getPortManager().getNextAvailableInputPort();
    }

    @Override
    public int getNextAvailableOutputPort() {
        return getPortManager().getNextAvailableOutputPort();
    }

    @Override
    public boolean hasAllInputPortsConnected() {
        return getPortManager().hasAllInputPortsConnected();
    }

    @Override
    public boolean hasAllOutputPortsConnected() {
        return getPortManager().hasAllOutputPortsConnected();
    }
    
}
