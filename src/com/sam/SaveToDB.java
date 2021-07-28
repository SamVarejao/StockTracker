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

    //<editor-fold desc="Save rectangular bar">
    public static boolean recBar(int heightField, int widthField, int lengthField, String materialField) {

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
    //</editor-fold>

    //<editor-fold desc="Save rectangular tube">
    public static boolean recTube(int heightField, int widthField, int lengthField, int thickField, String materialField) {

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

            String query = String.format("SELECT EXISTS(SELECT * FROM rec_tube WHERE height=%s AND width=%s AND length=%s AND wall_thick=%s AND material='%s')", heightField, widthField, lengthField, thickField, materialField);

            rs = stm.executeQuery(query);
            rs.next();//makes cursor point to first row

            int val = ((Number) rs.getObject(1)).intValue();

            if (val == 1) {
                return false;
            } else {
                query = String.format("INSERT INTO rec_tube (height, width, length, wall_thick, material, quantity) VALUES (%s, %s, %s, %s, '%s', 1 )", heightField, widthField, lengthField, thickField, materialField);
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
    //</editor-fold>


    //<editor-fold desc="Save circular bar">
    public static boolean circBar(int diameterField, int lengthField, String materialField) {

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
    //</editor-fold>

    //<editor-fold desc="Save circular tube">
    public static boolean circTube(int diameterField, int lengthField, int thickField, String materialField) {

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

            String query = String.format("SELECT EXISTS(SELECT * FROM circ_tube WHERE diameter=%s AND length=%s AND wall_thick=%s AND material='%s')", diameterField, lengthField, thickField, materialField);

            rs = stm.executeQuery(query);
            rs.next();//makes cursor point to first row

            int val = ((Number) rs.getObject(1)).intValue();

            if (val == 1) {
                return false;
            } else {
                query = String.format("INSERT INTO circ_tube (diameter, length, wall_thick, material, quantity) VALUES (%s, %s,  %s, '%s', 1 )", diameterField, lengthField, thickField, materialField);
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
    //</editor-fold>


}
