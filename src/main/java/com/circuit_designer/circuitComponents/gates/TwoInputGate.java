package com.circuit_designer.circuitComponents.gates;

import com.circuit_designer.circuitStructure.Bit;

public abstract class TwoInputGate extends Gate {

    public BitComparator bitComparator;

    public TwoInputGate(String name, BitComparator bc) {
        super(2, name);
        this.bitComparator = bc;
    }
    
    @Override
    protected void computeSignal() {
        Bit b1 = this.getInputBus(0).getSignal();
        Bit b2 = this.getInputBus(1).getSignal();
        Bit nextOutput = this.bitComparator.compare(b1, b2);
        this.getOutputBus(0).setSignal(nextOutput);
    }

}
