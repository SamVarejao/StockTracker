package com.sam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TubeRec extends BarRec {
    int wallThic;

    public TubeRec(int matType, int sideA, int sideB, int length, int wallThic) {
        super(matType, sideA, sideB, length);

        this.setMaterial(matType);
        this.sideA = sideA;
        this.sideB = sideB;
        this.length = length;
        this.wallThic = wallThic;

    }


}
