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

        saveToDB(diameter, length, wallThic, this.material);
    }

    public void saveToDB(int diameterField, int lengthField, int thickField, String materialField) {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Stock";
            String user = "stockmaster";
            String password = "123";

            con = DriverManager.getConnection(url, user, password);
            Statement s = con.createStatement();

            String query = String.format("INSERT INTO CIRC_TUBE (diameter, length, wall_thick, material, quantity) VALUES (%s, %s, %s, '%s', 1 )", diameterField, lengthField, thickField, materialField);

            s.executeUpdate(query);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
