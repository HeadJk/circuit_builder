package com.circuit_designer.circuitStructure.busStructure;

import com.circuit_designer.circuitStructure.Signal;
import com.circuit_designer.circuitStructure.deviceStructure.SignalObserver;

public class Bus extends SignalSubject implements BusInterface {

    private boolean isAvailableInput = true;
    private Signal signalBit = Signal.UNKNOWN;

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
    public Signal getSignal() {
        return this.signalBit;
    }

    @Override
    public void setSignal(Signal bit) {
        this.signalBit = bit;
        notifyObservers();
    }
    
}
