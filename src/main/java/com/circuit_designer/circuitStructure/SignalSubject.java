package com.circuit_designer.circuitStructure;

import java.util.List;
import java.util.ArrayList;

public abstract class SignalSubject {
    List<SignalObserver> observers;

    public SignalSubject() {
        this.observers = new ArrayList<SignalObserver>();
    }

    public void attatch(SignalObserver o) {
        this.observers.add(o);
    }

    public void detatch(SignalObserver o) {
        this.observers.remove(o);
    }

    public void notifyObservers() {
        for(SignalObserver o : this.observers)
            o.updateOutput();
    }
}