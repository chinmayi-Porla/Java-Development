import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Book {
  int id;
  String title;
  String author;

  public Book(int id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }
}

public class LibraryManagementSystem {
  static Scanner scanner = new Scanner(System.in);
  static ArrayList<Book> books = new ArrayList<>();

  public static void main(String[] args) {
    int choice;
    do {
      System.out.println("\nDigital Library Management System");
      System.out.println("1. Add Book");
      System.out.println("2. View Books");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");

      try {
        choice = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine(); // Clear the scanner buffer
        choice = -1;
      }

      switch (choice) {
        case 1:
          addBook();
          break;
        case 2:
          viewBooks();
          break;
        case 3:
          System.out.println("Exiting the system...");
          break;
        default:
          System.out.println("Invalid choice.");
      }
    } while (choice != 3);
  }

  public static void addBook() {
    System.out.print("Enter Book ID: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Clear the scanner buffer

    System.out.print("Enter Book Title: ");
    String title = scanner.nextLine();

    System.out.print("Enter Book Author: ");
    String author = scanner.nextLine();

    books.add(new Book(id, title, author));
    System.out.println("Book added successfully!");
  }

  public static void viewBooks() {
    if (books.isEmpty()) {
      System.out.println("No books found in the library.");
    } else {
      System.out.println("\nList of Books:");
      for (Book book : books) {
        System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author);
      }
    }
  }
}