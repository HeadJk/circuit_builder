package com.circuit_designer.circuitStructure;

public interface BusInterface {

    public boolean isAvailableInput();

    public void lockInputConnection();

    public void unlockInputConnection();

    public void attatchObserver(SignalObserver o);

    public void detatchObserver(SignalObserver o);

    public Bit getSignal();

    public void setSignal(Bit bit);

}
