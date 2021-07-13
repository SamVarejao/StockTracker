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

        saveToDB(sideA, sideB, length, wallThic, this.material);
    }

    public void saveToDB(int heightField, int widthField, int lengthField, int thickField, String materialField) {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Stock";
            String user = "stockmaster";
            String password = "123";

            con = DriverManager.getConnection(url, user, password);
            Statement s = con.createStatement();

            String query = String.format("INSERT INTO REC_TUBE (height, width, length, wall_thick, material, quantity) VALUES (%s, %s, %s, %s,'%s', 1 )", heightField, widthField, lengthField, thickField, materialField);

            s.executeUpdate(query);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }


}
