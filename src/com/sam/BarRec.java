package com.sam;

public class BarRec {
    public String material;
    public int matType;
    public int sideA;
    public int sideB;
    public double length ;

    public BarRec(int matType, int sideA, int sideB, double length) {
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

    public String toString() {
        return "material:" + material + ", sideA:" + sideA + ", sideB:" + sideB + ", length:" + length;
    }
}
