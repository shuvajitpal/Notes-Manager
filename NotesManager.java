package com.ElevateLabs;
import java.io.*;
import java.util.Scanner;

public class NotesManager {
   private static final String FILE_NAME = "notes.txt";

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while (true) {
         System.out.println("\n--- Notes Manager ---");
         System.out.println("1. Add Note");
         System.out.println("2. View Notes");
         System.out.println("3. Exit");
         System.out.print("Choose an option: ");

         String choice = scanner.nextLine();

         switch (choice) {
            case "1": addNote(scanner); break;
            case "2": viewNotes(); break;
            case "3":
               System.out.println("Exiting Notes Manager. Goodbye!");
               scanner.close();
               return;
            default: System.out.println("Invalid option. Try again.");
         }
      }
   }
   private static void addNote(Scanner scanner) {
      System.out.print("Enter your note: ");
      String note = scanner.nextLine();
      try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // 'true' for append mode
         writer.write(note + System.lineSeparator());
         System.out.println("Note added successfully!");
      } catch (IOException e) {
         System.out.println("Error writing note: " + e.getMessage());
      }
   }
   private static void viewNotes() {
      try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
         String line;
         System.out.println("\n--- Your Notes ---");
         while ((line = reader.readLine()) != null) System.out.println(line);
      } catch (FileNotFoundException e) {
         System.out.println("No notes found. Start by adding one!");
      } catch (IOException e) {
         System.out.println("Error reading notes: " + e.getMessage());
      }
   }
}