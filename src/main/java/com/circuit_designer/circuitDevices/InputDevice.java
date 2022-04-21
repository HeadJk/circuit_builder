package com.circuit_designer.circuitDevices;

import com.circuit_designer.circuitStructure.Signal;

public class InputDevice extends SingleOutputDevice implements InputDeviceI {

    private Signal currentInput = Signal.UNKNOWN;

    public InputDevice() {
        super(0, "Input Device");
    }

    @Override
    public void setInput(Signal s) {
        this.currentInput = s;
    }

    @Override
    public Signal getInput() {
        return this.currentInput;
    }

    @Override
    public void transferSignalToOutputs() {
        this.setOutputSignal(0, getInput());
    }
    
}
