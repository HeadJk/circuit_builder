package com.circuit_designer.cirucitFactory;

import com.circuit_designer.circuitComponents.constants.Source;

public class SourceFactory extends DeviceFactory {

    @Override
    public Source makeComponent() {
        return new Source();
    }
    
}
