package com.circuit_designer.cirucitFactory;

import com.circuit_designer.circuitDevices.constants.Source;

public class SourceFactory extends DeviceFactory {

    @Override
    public Source makeComponent() {
        return new Source();
    }
    
}
