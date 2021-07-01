package com.sam;

public class TubeCirc extends BarCirc {
    int wallThic;

    public TubeCirc(int matType, int diameter, double length, int wallThic) {
        super(matType, diameter, length);
        this.setMaterial(matType);
        this.diameter = diameter;
        this.length = length;
        this.wallThic = wallThic;
    }
}
