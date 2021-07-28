package com.sam;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args){

        JFrame frame = new MenuGUI("Stock Tracker");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


    }

}



