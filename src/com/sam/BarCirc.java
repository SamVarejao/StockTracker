package com.sam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BarCirc {
    public String material;
    public int diameter;
    public int length;

    public BarCirc(int matType, int diameter, int length) {
        this.setMaterial(matType);
        this.diameter = diameter;
        this.length = length;

        saveToDB(diameter, length, this.material);
    }

    //Convert number(materialType) into material----------------------------------
    public void setMaterial(int materialType) {
        String materialName = null;

        switch (materialType) {
            case 1 -> materialName = "Iron";
            case 2 -> materialName = "Stainless steel";
            case 3 -> materialName = "Steel";
            case 4 -> materialName = "Aluminum";
            default -> System.out.println("x");
        }


        this.material = materialName;

    }

    //------------------------------------------------
    public void saveToDB(int diameterField, int lengthField, String materialField) {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Stock";
            String user = "stockmaster";
            String password = "123";

            con = DriverManager.getConnection(url, user, password);
            Statement s = con.createStatement();

            String query = String.format("INSERT INTO CIRC_BAR (diameter, length, material, quantity) VALUES (%s, %s, '%s', 1 )", diameterField, lengthField, materialField);

            s.executeUpdate(query);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public String toString() {
        return "material:" + material + ", diameter:" + diameter + ", length:" + length;
    }

}
