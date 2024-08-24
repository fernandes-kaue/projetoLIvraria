package Repository;

import Domain.Book;
import Domain.Library;

import javax.swing.*;
import java.util.List;

public class Repository {

    private static Library library;

    public Repository(Library library){
        Repository.library = library;
    }


    // menu items
    public static void item1() {
        // Implement functionality for adding a book
        String title = JOptionPane.showInputDialog("What's the name of the book you want to add?");
        String author = JOptionPane.showInputDialog("Who's the author of the said book?");
        String ISBN = JOptionPane.showInputDialog("What's the ISBN of the said book?");
        library.addBook(new Book(title, author, ISBN));
        JOptionPane.showMessageDialog(null, "Book added successfully!");

    }

    public static void item2() {
        String bookTitle = JOptionPane.showInputDialog("What's the name of the book you want to remove?");
        if (library.findBook(bookTitle) != -1) {
            library.removeBook(bookTitle);
        } else {
            JOptionPane.showMessageDialog(null, "Book not found!");
        }
    }

    public static void item3() {
        String title = JOptionPane.showInputDialog("What's the name of the book you want to find?");
        int index = library.findBook(title);  // Store the result once
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Book not found!");
        } else {
            JOptionPane.showMessageDialog(null, "Book found at index: " + (index + 1));
        }
    }


    public static void item4() {
        List<String> books = library.listAllBooks();

        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books available.");
        } else {
            StringBuilder bookList = new StringBuilder();
            for (String book : books) {
                bookList.append(book).append("\n");
            }
            JOptionPane.showMessageDialog(null, bookList.toString(), "List of Books", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void item5() {
        JOptionPane.showMessageDialog(null, "Exiting the application...");
        System.exit(0);
    }

}
