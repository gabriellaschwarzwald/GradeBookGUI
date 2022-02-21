package com.company;
import java.util.*;
import javax.swing.*;

public class Screen2 extends JFrame{
    private JPanel PanelTop;
    private JLabel LabelTitle;
    private JTextField TextAverage;
    private JLabel LabelAverage;
    private JPanel PanelBottom;
    private JTextField TextGrade;
    private JLabel LabelGrade;
    private JPanel MainPanel;

    Screen2() {
        super("Term Grade Overlook");
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        TextAverage.setText(Double.toString(Grades.AverageGrade));
    }
}
