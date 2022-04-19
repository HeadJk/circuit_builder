package com.circuit_designer.circuitStructure.busStructure;

import com.circuit_designer.circuitStructure.Signal;
import com.circuit_designer.circuitStructure.deviceStructure.SignalObserver;

public interface BusInterface {

    public boolean isAvailableInput();

    public void lockInputConnection();

    public void unlockInputConnection();

    public void attatchObserver(SignalObserver o);

    public void detatchObserver(SignalObserver o);

    public Signal getSignal();

    public void setSignal(Signal bit);

}
