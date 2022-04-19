package com.circuit_designer.circuitDevices.gates;

import com.circuit_designer.circuitStructure.Signal;

// TODO Unit test.

public class AndComparator implements BitComparator {

    @Override
    public Signal compare(Signal b1, Signal b2) {

        if(b1 == Signal.LOW || b2 == Signal.LOW) {
            return Signal.LOW;
        }

        if(b1 == Signal.HIGH && b2 == Signal.HIGH) {
            return Signal.HIGH;
        }

        return Signal.UNKNOWN;

    }
    
}
