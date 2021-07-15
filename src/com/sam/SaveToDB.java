package com.sam;

import java.sql.*;

public final class SaveToDB {
    private SaveToDB() {

    }
    /*
    * Functions first search the respective table through a query with the data entered to check if the row the user is trying to add
    * already exists or not, if it exists the query will return 1, and in turn the function will return "false" (meaning
    * the process of saving failed).
    * In the opposite case, if the query returns 0 it means the row does not exist, in that case the function will proceed
    * to add the new data to the database and then return "true" to signal that the process of saving succeeded.
    */

    public static boolean saveToDB_recBar(String materialField, int heightField, int widthField, int lengthField) {

        Connection con = null;
        ResultSet rs = null;
        Statement stm = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Stock";
            String user = "stockmaster";
            String password = "123";

            con = DriverManager.getConnection(url, user, password);

            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);//creates scrollable list

            String query = String.format("SELECT EXISTS(SELECT * FROM rec_bar WHERE height=%s AND width=%s AND length=%s AND material='%s')", heightField, widthField, lengthField, materialField);

            rs = stm.executeQuery(query);
            rs.next();//makes cursor point to first row

            int val = ((Number) rs.getObject(1)).intValue();

            if (val == 1) {
                return false;
            } else {
                query = String.format("INSERT INTO rec_bar (height, width, length, material, quantity) VALUES (%s, %s, %s, '%s', 1 )", heightField, widthField, lengthField, materialField);
                stm.executeUpdate(query);
            }


        } catch (ClassNotFoundException | SQLException e) {
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
        return true;
    }

    public static boolean saveToDB_circBar(String materialField, int diameterField, int lengthField) {

        Connection con = null;
        ResultSet rs = null;
        Statement stm = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Stock";
            String user = "stockmaster";
            String password = "123";

            con = DriverManager.getConnection(url, user, password);

            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);//creates scrollable list

            String query = String.format("SELECT EXISTS(SELECT * FROM circ_bar WHERE diameter=%s AND length=%s AND material='%s')", diameterField, lengthField, materialField);

            rs = stm.executeQuery(query);
            rs.next();//makes cursor point to first row

            int val = ((Number) rs.getObject(1)).intValue();

            if (val == 1) {
                return false;
            } else {
                query = String.format("INSERT INTO circ_bar (diameter, length, material, quantity) VALUES (%s, %s, '%s', 1 )", diameterField, lengthField, materialField);
                stm.executeUpdate(query);
            }


        } catch (ClassNotFoundException | SQLException e) {
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
        return true;
    }

}
