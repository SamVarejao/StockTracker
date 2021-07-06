package com.sam;

public class BarCirc {
    public String material;
    public int diameter;
    public double length;

    public BarCirc(int matType, int diameter, double length) {
        this.setMaterial(matType);
        this.diameter = diameter;
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
        return "material:" + material + ", diameter:" + diameter + ", length:" + length;
    }

}
