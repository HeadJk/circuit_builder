package com.circuit_designer.utilities;

public class ArrayNullFinder implements ArrayNullFinderI {

    private int nextNullElementIndex;
    private Object[] array;

    public ArrayNullFinder(Object[] array) {
        this.array = array;
        update();
    }

    @Override
    public void update() {
        for(int i = 0; i < this.array.length; i++) {
            if(this.array[i] == null) {
                this.nextNullElementIndex = i;
                return;
            }
        }
        this.nextNullElementIndex = -1;
    }

    @Override
    public int getNextNullElementIndex() {
        return this.nextNullElementIndex;
    }
    
}
