package com.circuit_designer.circuitStructure;

public class Bus extends SignalSubject implements BusInterface {

    private boolean isAvailableInput = true;
    private Bit signalBit = Bit.UNKNOWN;

    @Override
    public void attatchObserver(SignalObserver o) {
        super.attatch(o);
    }

    @Override
    public void detatchObserver(SignalObserver o) {
        super.detatch(o);
    }

    @Override
    public boolean isAvailableInput() {
        return this.isAvailableInput;
    }

    @Override
    public void lockInputConnection() {
        this.isAvailableInput = false;
    }

    @Override
    public void unlockInputConnection() {
        this.isAvailableInput = true;
    }

    @Override
    public Bit getSignal() {
        return this.signalBit;
    }

    @Override
    public void setSignal(Bit bit) {
        this.signalBit = bit;
        notifyObservers();
    }
    
}
