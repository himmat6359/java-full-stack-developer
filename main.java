package crud;

import java.util.Scanner;
import java.io.*;

public class main {
    public static void main(String args[]) {
        String filename;
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            menu();
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter your filename:");
                    filename = sc.next();
                    Createfile(filename);
                    break;

                case 2:
                    System.out.println("Enter filename:");
                    filename = sc.next();
                    ReadFile(filename);
                    break;

                case 3:
                    System.out.println("Enter filename:");
                    filename = sc.next();
                    DeleteFile(filename);
                    break;

                case 4:
                    System.out.println("Enter filename:");
                    filename = sc.next();
                    SearchFile(filename);
                    break;

                case 5:
                    System.out.println("Enter filename:");
                    filename = sc.next();
                    UpdateFile(filename);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (ch != 0);
        sc.close();
    }

    private static void menu() {
        System.out.println("1. Create file");
        System.out.println("2. Read file");
        System.out.println("3. Delete file");
        System.out.println("4. Search file");
        System.out.println("5. Update file");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
    }

    private static void Createfile(String filename) {
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void ReadFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    private static void DeleteFile(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    private static void SearchFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("File found: " + file.getName());
        } else {
            System.out.println("File not found.");
        }
    }

    private static void UpdateFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new content:");
            String newContent = scanner.nextLine();
            FileWriter writer = new FileWriter(file);
            writer.write(newContent);
            writer.close();
            System.out.println("File updated.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}