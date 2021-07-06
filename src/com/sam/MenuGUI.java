package com.sam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuGUI extends JFrame {
    private JButton newBtn;
    private JButton addBtn;
    private JButton removeBtn;

    private JPanel panelMain;

    public MenuGUI(String title) {
        super(title);

        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        newBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
