package com.circuit_designer.circuitDevices.gates;

import com.circuit_designer.circuitStructure.Signal;

public interface BitComparator {

    public Signal compare(Signal b1, Signal b2);
    
}
