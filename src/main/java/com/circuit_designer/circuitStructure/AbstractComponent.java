package com.circuit_designer.circuitStructure;

public abstract class AbstractComponent implements ComponentInterface {

    private BusInterface[] outputPorts;
    private BusInterface[] inputPorts;
    private String name;

    public AbstractComponent(int inputPortCount, int outputPortCount, String name) {
        this.inputPorts = new BusInterface[inputPortCount];
        this.outputPorts = new BusInterface[outputPortCount];
        this.name = name;
    }

    protected abstract void computeSignal();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void updateOutput() {
        computeSignal();
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
        assert (0 <= portIndex && portIndex < outputPorts.length);
        if(this.outputPorts[portIndex] != null) return false;

        if(bus.isAvailableInput()) {
            this.outputPorts[portIndex] = bus;
            bus.lockInputConnection();
            return true;
        }

        return false;
    }

    @Override
    public boolean disconnectOutputBus(int portIndex) {
        assert (0 <= portIndex && portIndex < outputPorts.length);
        if(this.outputPorts[portIndex] != null) return false;
        this.outputPorts[portIndex].unlockInputConnection();
        this.outputPorts[portIndex] = null;
        return true;
    }

    @Override
    public boolean connectInputBus(int portIndex, BusInterface bus) {
        assert (0 <= portIndex && portIndex < inputPorts.length);
        if(this.inputPorts[portIndex] != null) return false;

        if(bus.isAvailableInput()) {
            this.inputPorts[portIndex] = bus; 
            bus.attatchObserver(this);
            return true;
        }

        return false;
    }

    @Override
    public boolean disconnectInputBus(int portIndex) {
        assert (0 <= portIndex && portIndex < inputPorts.length);
        if(this.inputPorts[portIndex] == null) return false;
        this.inputPorts[portIndex].detatchObserver(this);
        this.inputPorts[portIndex] = null; 
        return true;
    }

    @Override
    public void disconnectAllPorts() {
        for(int i = 0; i < getInputPortCount(); i++) {
            disconnectInputBus(i);
        }
        for(int j = 0; j < getInputPortCount(); j++) {
            disconnectOutputBus(j);
        }
    }

    @Override
    public int getInputPortCount() {
        return this.inputPorts.length;
    }

    @Override
    public int getOutputPortCount() {
        return this.outputPorts.length;
    }
    
}
