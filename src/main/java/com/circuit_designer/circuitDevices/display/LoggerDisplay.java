package com.circuit_designer.circuitDevices.display;

public class LoggerDisplay extends DisplayDevice {

    private String loggerName;

    public LoggerDisplay(String loggerName) {
        super("Logger Display");
        this.loggerName = loggerName;
    }

    public String getLoggerName() {
        return loggerName;
    }

    @Override
    public void displaySignal() {
        System.out.println(getLoggerName() + ": " + getSignal().toString());
    }
    
}
