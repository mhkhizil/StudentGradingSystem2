/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classespackage;
import java.io.*;
import java.util.*;
/**
 *
 * @author msi
 */
class StudentGradeManagementSystem {
    private List<Student> students;

    public StudentGradeManagementSystem() {
        students = new ArrayList<>();
        
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student details (enter 'exit' to stop):");
        while (true) {
            System.out.print("Name: ");
           
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
             if (!isValidName(name)) {
            System.out.println("Invalid name. Please enter a valid string.");
            continue;
        }
            
            System.out.print("ID: ");
            int id = 0;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a valid integer.");
                continue;
            }

            System.out.print("Grades (separated by spaces): ");
            String[] gradesArray = scanner.nextLine().split(" ");
            List<Integer> grades = new ArrayList<>();
            for (String grade : gradesArray) {
                
                try {
                    grades.add(Integer.parseInt(grade));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid grade. Skipping invalid input.");
                }
            }

            Student student = new Student(name, id, grades);
            students.add(student);
        }
    }
    private boolean isValidName(String name) {
    // Validate that the name contains only letters and spaces
    return name.matches("[A-Za-z ]+");
}

    public void saveData(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.getName() + "," + student.getId() + "," + student.getGrades());
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void sortData(String sortOption) {
       try {
            switch (sortOption) {
                case "name":
                    students.sort(Comparator.comparing(Student::getName));
                    System.out.println("Data sorted by name successfully.");
                    break;
                case "id":
                    students.sort(Comparator.comparingInt(Student::getId));
                    System.out.println("Data sorted by ID successfully.");
                    break;
              
                case "average grade":
                    students.sort(Comparator.comparingDouble(Student::getAverageGrade));
                    System.out.println("Data sorted by average grades successfully.");
                    break;
                default:
                    System.out.println("Invalid sort option. Sorting by name by default.");
                    students.sort(Comparator.comparing(Student::getName));
                    System.out.println("Data sorted by name successfully.");
                    break;
                    
            }
               System.out.println("\nSorted Data:");
            for (Student student : students) {
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getId());
                System.out.println("Grades: " + student.getGrades());
                System.out.println();
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Sorting is not supported for the current data structure.");
        }
    }
   

    public void searchData(int studentId) {
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == studentId) {
                System.out.println("Student found:");
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getId());
                System.out.println("Grades: " + student.getGrades());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
      public void displayAverageGrade() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Average Grade: " + student.getAverageGrade());
            System.out.println();
        }
      }


}
