package com.sam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TubeCirc extends BarCirc {
    int wallThic;

    public TubeCirc(int matType, int diameter, int length, int wallThic) {
        super(matType, diameter, length);
        this.setMaterial(matType);
        this.diameter = diameter;
        this.length = length;
        this.wallThic = wallThic;

    }

}
