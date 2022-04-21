package com.circuit_designer.circuitDevices.display;

public class LoggerDisplay extends DisplayDevice {

    public LoggerDisplay() {
        super("Logger Display");
    }

    @Override
    public void displaySignal() {
        System.out.println(getName() + ": " + getSignal().toString());
    }
    
}
