package com.company;

public class Grades {

    private String name;
    private String marks;
    private String totalmarks;
    static double AveragePercent;
    static double AverageGrade;
    private double GradePercent;


    public Grades(String name, String marks, String totalmarks) {
        this.name = name;
        this.marks = marks;
        this.totalmarks = totalmarks;
        this.GradePercent = CalcGradePercent();
    }

    public double CalcGradePercent(){
        return ((Integer.parseInt(marks))/Integer.parseInt(totalmarks))*100;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getTotalmarks() {
        return totalmarks;
    }

    public double getGradePercent() {
        return GradePercent;
    }

    public void setTotalmarks(String totalmarks) {this.totalmarks = totalmarks;
    }

    public void CalculateGrade() {
        String grade;
        if (GradePercent <= 15)
            grade = "1";
        if (GradePercent > 15 && GradePercent <= 25)
            grade = "2";
        if (GradePercent > 25 && GradePercent <= 35)
            grade = "3";
        if (GradePercent > 35 && GradePercent <= 50)
            grade = "4";
        if (GradePercent > 50 && GradePercent <= 65)
            grade = "5";
        if (GradePercent > 65 && GradePercent <= 80)
            grade = "6";
        if (GradePercent > 80)
            grade = "7";
    }


}

