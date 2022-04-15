package com.circuit_designer.circuitComponents.gates;

import com.circuit_designer.circuitStructure.Bit;

public class AndComparator implements BitComparator {

    @Override
    public Bit compare(Bit b1, Bit b2) {

        if(b1 == Bit.LOW || b2 == Bit.LOW) {
            return Bit.LOW;
        }

        if(b1 == Bit.HIGH && b2 == Bit.HIGH) {
            return Bit.HIGH;
        }

        return Bit.UNKNOWN;

    }
    
}
