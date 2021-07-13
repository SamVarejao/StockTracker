package com.sam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BarRec {
    public String material;
    public int sideA;
    public int sideB;
    public int length;

    public BarRec(int matType, int sideA, int sideB, int length) {
        this.setMaterial(matType);

//  Make sure sideA is the biggest side to maintain the model
        if (sideB > sideA) {
            this.sideA = sideB;
            this.sideB = sideA;
        } else {
            this.sideA = sideA;
            this.sideB = sideB;
        }
//-----------------
        this.length = length;

        saveToDB(sideA, sideB, length, this.material);
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

    public void saveToDB(int heightField, int widthField, int lengthField, String materialField) {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Stock";
            String user = "stockmaster";
            String password = "123";

            con = DriverManager.getConnection(url, user, password);
            Statement s = con.createStatement();

            String query = String.format("INSERT INTO REC_BAR (height, width, length, material, quantity) VALUES (%s, %s, %s, '%s', 1 )", heightField, widthField, lengthField, materialField);

            s.executeUpdate(query);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public String toString() {
        return "material:" + material + ", sideA:" + sideA + ", sideB:" + sideB + ", length:" + length;
    }

}

