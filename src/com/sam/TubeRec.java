package com.sam;

public class TubeRec extends BarRec{
    int wallThic;
    public TubeRec(int matType, int sideA, int sideB, int length, int wallThic) {
        super(matType, sideA, sideB, length);

        this.setMaterial(matType);
        this.sideA = sideA;
        this.sideB = sideB;
        this.length = length;
        this.wallThic= wallThic;
    }


}
