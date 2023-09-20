/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classespackage;
import java.util.Scanner;
/**
 *
 * @author msi
 */
public class Main {
    public static void main(String[] args) {
        StudentGradeManagementSystem system = new StudentGradeManagementSystem();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Input data");
            System.out.println("2. Save data");
            System.out.println("3. Sort data");
            System.out.println("4. Search data");
            System.out.println("5. Calculate average grade");
             System.out.println("6. exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a valid integer.");
                continue;
            }

            switch (choice) {
                case 1:
                    system.inputData();
                    break;
                case 2:
                    System.out.print("Enter filename: ");
                    String filename = scanner.nextLine();
                    system.saveData(filename);
                    break;
                case 3:
                    System.out.println("Sort Options:");
                    System.out.println("1. Sort by name");
                    System.out.println("2. Sort by ID");
                 
                    System.out.println("3. Sort by average grades");
                    System.out.print("Enter sort option: ");
                    String sortOption = scanner.nextLine();
                    switch (sortOption) {
                        case "1":
                            system.sortData("name");
                            break;
                        case "2":
                            system.sortData("id");
                            break;
                       
                        case "3":
                            system.sortData("average grade");
                            break;
                        default:
                            System.out.println("Invalid sort option. Sorting by name by default.");
                            system.sortData("name");
                            break;
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID to search : ");
                    int studentId = 0;
                    try {
                        studentId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a valid integer.");
                        continue;
                    }
                    system.searchData(studentId);
                    break;
                  case 5:
                    system.displayAverageGrade();
                    break;
                    case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
