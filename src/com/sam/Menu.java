package com.sam;

import java.util.Scanner;

public final class Menu {

    private Menu() {
    }

    public static BarCirc addBarCirc() {
        Scanner sc = new Scanner(System.in);

        //Assign values ---------------------------------
        System.out.println("Introduce material type: ");
        System.out.println("(1) Iron");
        System.out.println("(2) Stainless steel");
        System.out.println("(3) Steel");
        System.out.println("(4) Aluminum");
        int materialNum = sc.nextInt();

        //Check for correct input
        if (materialNum >= 5) {
            do {
                System.out.println("Invalid value!");
                System.out.println("Introduce material type: ");
                System.out.println("(1) Iron");
                System.out.println("(2) Stainless steel");
                System.out.println("(3) Steel");
                System.out.println("(4) Aluminum");
                materialNum = sc.nextInt();
            } while (materialNum >= 5);
        }

        System.out.println("Introduce diameter(mm): ");
        int diameter = sc.nextInt();
        System.out.println("Introduce object length(mm): ");
        double length = sc.nextDouble();

        //------------------------------------------------
        return new BarCirc(materialNum, diameter, length);
    }

    public static BarRec addBarRec() {
        Scanner sc = new Scanner(System.in);

        //Assign values ---------------------------------
        System.out.println("Introduce material type: ");
        System.out.println("(1) Iron");
        System.out.println("(2) Stainless steel");
        System.out.println("(3) Steel");
        System.out.println("(4) Aluminum");
        int materialNum = sc.nextInt();

        //Check for correct input
        if (materialNum >= 5) {
            do {
                System.out.println("Invalid value!");
                System.out.println("Introduce material type: ");
                System.out.println("(1) Iron");
                System.out.println("(2) Stainless steel");
                System.out.println("(3) Steel");
                System.out.println("(4) Aluminum");
                materialNum = sc.nextInt();
            } while (materialNum >= 5);
        }

        System.out.println("Introduce height(mm): ");
        int sideA = sc.nextInt();
        System.out.println("Introduce width(mm): ");
        int sideB = sc.nextInt();
        System.out.println("Introduce object length(mm): ");
        double length = sc.nextDouble();
        //------------------------------------------------

        return new BarRec(materialNum, sideA, sideB, length);

    }

    public static TubeCirc addTubeCirc() {
        Scanner sc = new Scanner(System.in);

        //Assign values ---------------------------------
        System.out.println("Introduce material type: ");
        System.out.println("(1) Iron");
        System.out.println("(2) Stainless steel");
        System.out.println("(3) Steel");
        System.out.println("(4) Aluminum");
        int materialNum = sc.nextInt();

        //Check for correct input------------------------------------------
        if (materialNum >= 5) {
            do {
                System.out.println("Invalid value!");
                System.out.println("Introduce material type: ");
                System.out.println("(1) Iron");
                System.out.println("(2) Stainless steel");
                System.out.println("(3) Steel");
                System.out.println("(4) Aluminum");
                materialNum = sc.nextInt();
            } while (materialNum >= 5);
        }
        System.out.println("Introduce wall thickness(mm): ");
        int wallThic = sc.nextInt();
        System.out.println("Introduce diameter(mm): ");
        int diameter = sc.nextInt();
        System.out.println("Introduce object length(mm): ");
        double length = sc.nextDouble();

        //------------------------------------------------
        return new TubeCirc(materialNum, diameter, length, wallThic);


    }

    public static TubeRec addTubeRec() {
        Scanner sc = new Scanner(System.in);

        //Assign values ---------------------------------
        System.out.println("Introduce material type: ");
        System.out.println("(1) Iron");
        System.out.println("(2) Stainless steel");
        System.out.println("(3) Steel");
        System.out.println("(4) Aluminum");
        int materialNum = sc.nextInt();

        //Check for correct input
        if (materialNum >= 5) {
            do {
                System.out.println("Invalid value!");
                System.out.println("Introduce material type: ");
                System.out.println("(1) Iron");
                System.out.println("(2) Stainless steel");
                System.out.println("(3) Steel");
                System.out.println("(4) Aluminum");
                materialNum = sc.nextInt();
            } while (materialNum >= 5);
        }
        System.out.println("Introduce wall thickness(mm): ");
        int wallThic = sc.nextInt();
        System.out.println("Introduce height(mm): ");
        int sideA = sc.nextInt();
        System.out.println("Introduce width(mm): ");
        int sideB = sc.nextInt();
        System.out.println("Introduce object length(mm): ");
        double length = sc.nextDouble();
        //------------------------------------------------

        return new TubeRec(materialNum, sideA, sideB, length, wallThic);

    }
}
