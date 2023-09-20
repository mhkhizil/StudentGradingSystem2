/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classespackage;
import java.util.List;
/**
 *
 * @author msi
 */
class Student implements Comparable<Student> {
    private String name;
    private int id;
    private List<Integer> grades;

    public Student(String name, int id, List<Integer> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.getAverageGrade(), other.getAverageGrade());
    }
}