package com.company;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

public class Screen extends JFrame {
    private JPanel MainPanel;
    private JPanel PanelTop;
    private JPanel PanelRight;
    private JPanel PanelLeft;
    private JLabel LabelTitle;
    private JList TaskList;
    private JLabel ListTitle;
    private JLabel LabelTask;
    private JLabel LabelGrade;
    private JLabel LabelTotalMarks;
    private JTextField TextTaskName;
    private JTextField TextMarks;
    private JTextField TextTotalMarks;
    private JButton AddButton;
    private JButton DeleteButton;
    private JButton TermButton;

    ArrayList<Grades> GradesList = new ArrayList<Grades>();
    private DefaultListModel TaskListModel;


    Screen() {
        super("Grade Book");
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        TaskListModel = new DefaultListModel();
        TaskList.setModel(TaskListModel);

        AddButton.setEnabled(true);

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grades g = new Grades(
                        TextTaskName.getText(),
                        TextMarks.getText(),
                        TextTotalMarks.getText());
                AddGrade(g);
            }
        });

        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextTaskName.setText(" ");
                TextMarks.setText(" ");
                TextTotalMarks.setText(" ");
            }
        });
        TermButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            double sum = 0.0;
            for(int i = 0; i < GradesList.size(); i++) {
                sum = sum + GradesList.get(i).getGradePercent();
                System.out.println(sum);
            }
            Grades.AveragePercent = sum / GradesList.size();

                Screen2 screen = new Screen2();
                screen.setVisible(true);
            }
        });

        TaskList.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        int GradeNumber = TaskList.getSelectedIndex();
                        if (GradeNumber >= 0) {
                            Grades g = GradesList.get(GradeNumber);
                            TextTaskName.setText(g.getName());
                            TextMarks.setText(g.getMarks());
                            TextTotalMarks.setText(g.getTotalmarks());
                         }
                    }
                });


    }
    public void refreshList() {
        TaskListModel.removeAllElements();
        System.out.println("Removing all people from list");
        for (Grades g : GradesList) {
            System.out.println("Adding task to list: " + g.getName());
            TaskListModel.addElement(g.getName());
        }
    }

    public void AddGrade(Grades g) {
        GradesList.add(g);
        refreshList();
    }

    }

