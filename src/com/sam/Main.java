package com.sam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private JButton button1;
    private JPanel panelMain;

    public Main() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.addBarRec();
            }
        });
    }

    public static void main(String[] args) {
        JFrame mainFrame= new JFrame("StockTracker");
        mainFrame.setContentPane(new Main().panelMain);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        /*
        Scanner sc = new Scanner(System.in);

        System.out.println("(1) Add new profile type");
        System.out.println("(2) Add to existing profile type");
        System.out.println("(3) Remove from existing profile type");

        int option = sc.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Select what category to create:");
                System.out.println("(1) Rectangular bar");
                System.out.println("(2) Rectangular tube");
                System.out.println("(3) Circular bar");
                System.out.println("(4) Circular tube");
                option = sc.nextInt();
                switch (option) {
                    case 1 -> Menu.addBarRec();
                    case 2 -> Menu.addTubeRec();
                    case 3 -> Menu.addBarCirc();
                    case 4 -> Menu.addTubeCirc();
                }
            }
            case 2 -> System.out.println("Feature to come");
            case 3 -> System.out.println("Feature yet to come");
        }*/

    }

        /*
        BarRec x[]= new BarRec[2];
        x[0]= Menu.addBarRec();
        x[1]= Menu.addBarRec();

        System.out.println(Arrays.toString(x));
        */

}


