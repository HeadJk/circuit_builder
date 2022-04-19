package com.circuit_designer.circuitDevices.gates;

import com.circuit_designer.circuitStructure.Signal;

// TODO Unit test.

public abstract class TwoInputGate extends Gate {

    public BitComparator bitComparator;

    public TwoInputGate(String name, BitComparator bc) {
        super(2, name);
        this.bitComparator = bc;
    }
    
    @Override
    public void transferSignalToOutputs() {
        Signal s0 = this.getInputSignal(0);
        Signal s1 = this.getInputSignal(1);
        Signal nextOutput = this.bitComparator.compare(s0, s1);
        if(hasAllOutputPortsConnected()) {
            this.getOutputBus(0).setSignal(nextOutput);
        }
    }

}
