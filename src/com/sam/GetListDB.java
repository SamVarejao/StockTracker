package com.sam;

import java.sql.*;
import java.util.ArrayList;

final class GetListDB {
    private GetListDB() {
    }

    public static Object[][] as(String collumn) throws SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement stm = null;

        ArrayList<String> circBar = new ArrayList<>();

        Object[][] table = new Object[0][0];

        int x;
        int y;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Stock";
            String user = "stockmaster";
            String password = "123";

            String query = String.format("SELECT * FROM %s ;", collumn);

            con = DriverManager.getConnection(url, user, password);
            stm = con.createStatement();
            rs = stm.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            x = columnsNumber - 1;

            while (rs.next()) {
                //Add one row
                for (int i = 2; i <= columnsNumber; i++) { // COLLUMN´S INDEX DOES NOT BEGIN WITH 0. So _id is 1. We don´t need that so we start at 2
                    circBar.add(rs.getString((i)));
                }
            }

            y = circBar.size() / x;
            int listIndex = 0;

            table = new Object[y][x];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    table[i][j] = circBar.get(listIndex);
                    listIndex++;
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) { /* Ignored */ }
            try {
                rs.close();
            } catch (Exception e) { /* Ignored */ }
            try {
                stm.close();
            } catch (Exception e) { /* Ignored */ }
        }
        return table;
    }
}
