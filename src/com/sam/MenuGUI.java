package com.sam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame {
    private JPanel panelMain; //main "canvas"

    //<editor-fold desc="-> Main menu components">
    private JPanel mainMenuPanel;
    private JButton newBtn;
    private JButton addBtn;
    private JButton removeBtn;
    //</editor-fold>

    //<editor-fold desc="-> Profile type menu components">
    private JPanel typePanel;
    private JButton circBar;
    private JButton circTube;
    private JButton recTube;
    private JButton recBar;
    private JButton bckToMain1;
    //</editor-fold>

    //<editor-fold desc="-> Rectangular Bar components">
    private JPanel recBarPanel;
    private JRadioButton recBarMatIron;
    private JRadioButton recBarMatSSteel;
    private JRadioButton recBarMatSteel;
    private JRadioButton recBarMatAluminum;
    private JTextField recBarHeightTF;
    private JTextField recBarWidthTF;
    private JTextField recBarLengthTF;
    private JButton recBarBtn;
    //</editor-fold>

    //<editor-fold desc="-> Rectangular Tube components">
    private JPanel recTubePanel;
    private JTextField recTubeThickTF;
    private JRadioButton recTubeMatIron;
    private JRadioButton recTubeMatSSteel;
    private JRadioButton recTubeMatSteel;
    private JRadioButton recTubeMatAluminum;
    private JTextField recTubeHeightTF;
    private JTextField recTubeWidthTF;
    private JTextField recTubeLengthTF;
    private JButton recTubeBtn;
    //</editor-fold>

    //<editor-fold desc="-> Circular Bar components">
    private JPanel circBarPanel;
    private JRadioButton circBarMatIron;
    private JRadioButton circBarMatSSteel;
    private JRadioButton circBarMatSteel;
    private JRadioButton circBarMatAluminum;
    private JButton circBarBtn;
    private JTextField circBarDiamTF;
    private JTextField circBarLengthTF;
    //</editor-fold>

    //<editor-fold desc="-> Circular Tube components">
    private JPanel circTubePanel;
    private JTextField circTubeThickTF;
    private JRadioButton circTubeMatIron;
    private JRadioButton circTubeMatSSteel;
    private JRadioButton circTubeMatSteel;
    private JRadioButton circTubeMatAluminum;
    private JTextField circTubeDiamTF;
    private JTextField circTubeLengthTF;
    private JButton circTubeBtn;
    private JButton bckToType1;
    private JButton bckToType2;
    private JButton bckToType3;
    private JButton bckToType4;
    //</editor-fold>

    public MenuGUI(String title) {
        super(title);

        this.setContentPane(mainMenuPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        //<editor-fold desc="-> Main menu">
        newBtn.addActionListener(e -> {
            setContentPane(typePanel);
            revalidate();
        });
        addBtn.addActionListener(e -> {

        });
        removeBtn.addActionListener(e -> {

        });
        //</editor-fold>

        //<editor-fold desc="-> Profile type menu">
        recBar.addActionListener(e -> {
            setContentPane(recBarPanel);
            revalidate();
        });
        recTube.addActionListener(e -> {
            setContentPane(recTubePanel);
            revalidate();
        });
        circBar.addActionListener(e -> {
            setContentPane(circBarPanel);
            revalidate();
        });
        circTube.addActionListener(e -> {
            setContentPane(circTubePanel);
            revalidate();

        });
        // Ye old return to previous menu button
        bckToMain1.addActionListener(e -> {
            setContentPane(mainMenuPanel);
            revalidate();
        });
        //</editor-fold>

        //<editor-fold desc="-> New Rectangular Bar">
        recBarBtn.addActionListener(e -> {
            int heightField = (int) (Double.parseDouble(recBarHeightTF.getText()));
            int widthField = (int) (Double.parseDouble(recBarWidthTF.getText()));
            int lengthField = (int) Double.parseDouble(recBarLengthTF.getText());
            int matField = 0;

            if (recBarMatIron.isSelected()) {
                matField = 1;
            } else if (recBarMatSSteel.isSelected()) {
                matField = 2;
            } else if (recBarMatSteel.isSelected()) {
                matField = 3;
            } else if (recBarMatAluminum.isSelected()) {
                matField = 4;
            }

            BarRec newBarRec = new BarRec(matField, heightField, widthField, lengthField);
            System.out.println(newBarRec);

        });
        // Ye old return to previous menu button
        bckToType1.addActionListener(e -> {
            setContentPane(typePanel);
            revalidate();
        });
        //</editor-fold>

        //<editor-fold desc="-> New Rectangular Tube">
        recTubeBtn.addActionListener(e -> {
            int heightField = (int) (Double.parseDouble(recTubeHeightTF.getText()));
            int widthField = (int) (Double.parseDouble(recTubeWidthTF.getText()));
            int lengthField = (int) Double.parseDouble(recTubeLengthTF.getText());
            int wallThickField = (int) (Double.parseDouble(recTubeThickTF.getText()));
            int matField = 0;

            if (recTubeMatIron.isSelected()) {
                matField = 1;
            } else if (recTubeMatSSteel.isSelected()) {
                matField = 2;
            } else if (recTubeMatSteel.isSelected()) {
                matField = 3;
            } else if (recTubeMatAluminum.isSelected()) {
                matField = 4;
            }

            BarRec newTubeRec = new TubeRec(matField, heightField, widthField, lengthField, wallThickField);
            System.out.println(newTubeRec);

        });
        // Ye old return to previous menu button
        bckToType2.addActionListener(e -> {
            setContentPane(typePanel);
            revalidate();
        });
        //</editor-fold>

        //<editor-fold desc="-> New Circular Bar">
        circBarBtn.addActionListener(e -> {
            int diamField = (int) (Double.parseDouble(circBarDiamTF.getText()));
            int lengthField = (int) Double.parseDouble(circBarLengthTF.getText());
            int matField = 0; //this will be converted into a string inside the BarCirc class

            if (circBarMatIron.isSelected()) {
                matField = 1;
            } else if (circBarMatSSteel.isSelected()) {
                matField = 2;
            } else if (circBarMatSteel.isSelected()) {
                matField = 3;
            } else if (circBarMatAluminum.isSelected()) {
                matField = 4;
            }

            BarCirc newBarCirc = new BarCirc(matField, diamField, lengthField);
            boolean saveStatus = SaveToDB.saveToDB_circBar(newBarCirc.material, newBarCirc.diameter, newBarCirc.length);
            System.out.println(saveStatus);

            if (!saveStatus) {
                JOptionPane.showMessageDialog(this, "Profile already exists, you can access the quantity through the list");

            } else {

                JOptionPane.showMessageDialog(this, "New profile added");

            }

        });
        // Ye old return to previous menu button
        bckToType3.addActionListener(e -> {
            setContentPane(typePanel);
            revalidate();
        });
        //</editor-fold>

        //<editor-fold desc="-> New Circular Tube">
        circTubeBtn.addActionListener(e -> {
            int diamField = (int) Double.parseDouble(circTubeDiamTF.getText());
            int lengthField = (int) Double.parseDouble(circTubeLengthTF.getText());
            int wallThickField = (int) Double.parseDouble(circTubeThickTF.getText());
            int matField = 0;

            if (circTubeMatIron.isSelected()) {
                matField = 1;
            } else if (circTubeMatSSteel.isSelected()) {
                matField = 2;
            } else if (circTubeMatSteel.isSelected()) {
                matField = 3;
            } else if (circTubeMatAluminum.isSelected()) {
                matField = 4;
            }

            BarCirc newTubeCirc = new TubeCirc(matField, diamField, lengthField, wallThickField);
            System.out.println(newTubeCirc);

        });
        // Ye old return to previous menu button
        bckToType4.addActionListener(e -> {
            setContentPane(typePanel);
            revalidate();
        });
        //</editor-fold>
    }
}
