package Library;

import Domain.Book;
import Domain.Library;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class LibraryApp {
    static Library library = new Library();

    public static void main(String[] args) {

        // Create the main frame
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Library App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a panel for the vertical menu and centralize it
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;

        // Define the size for all buttons
        Dimension buttonSize = new Dimension(200, 40);

        // Create and add buttons to the menu panel
        JButton addBook = new JButton("Add a Book");
        JButton removeBook = new JButton("Remove a Book");
        JButton findBook = new JButton("Find a Book");
        JButton listAllBooks = new JButton("List All Books");
        JButton exit = new JButton("Exit");

        // Set the preferred size for all buttons
        addBook.setPreferredSize(buttonSize);
        removeBook.setPreferredSize(buttonSize);
        findBook.setPreferredSize(buttonSize);
        listAllBooks.setPreferredSize(buttonSize);
        exit.setPreferredSize(buttonSize);

        menuPanel.add(addBook, gbc);
        menuPanel.add(removeBook, gbc);
        menuPanel.add(findBook, gbc);
        menuPanel.add(listAllBooks, gbc);
        menuPanel.add(exit, gbc);

        // Add menu panel to the center of the frame
        frame.add(menuPanel, BorderLayout.CENTER);

        // Create a text area for displaying results (optional)
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVisible(false); // Hide the text area initially
        frame.add(scrollPane, BorderLayout.SOUTH); // Show the text area at the bottom when visible

        // Add action listeners for buttons
        addBook.addActionListener(e -> {
            scrollPane.setVisible(true);
            item1();
        });

        removeBook.addActionListener(e -> {
            scrollPane.setVisible(true);
            item2();
        });

        findBook.addActionListener(e -> {
            scrollPane.setVisible(true);
            item3();
        });

        listAllBooks.addActionListener(e -> {
            scrollPane.setVisible(true);
            item4();
        });

        exit.addActionListener(e -> {
            item5();
            System.exit(0);
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    private static void item1() {
        // Implement functionality for adding a book
        String title = JOptionPane.showInputDialog("What's the name of the book you want to add?");
        String author = JOptionPane.showInputDialog("Who's the author of the said book?");
        String ISBN = JOptionPane.showInputDialog("What's the ISBN of the said book?");
        library.addBook(new Book(title, author, ISBN));
        JOptionPane.showMessageDialog(null, "Book added successfully!");

    }

    private static void item2() {
        String bookTitle = JOptionPane.showInputDialog("What's the name of the book you want to remove?");
        if (library.findBook(bookTitle) != -1) {
            library.removeBook(bookTitle);
        } else {
            JOptionPane.showMessageDialog(null, "Book not found!");
        }
    }

    private static void item3() {
    String title = JOptionPane.showInputDialog("What's the name of the book you want to find?");
    int index = library.findBook(title);  // Store the result once
    if (index == -1) {
        JOptionPane.showMessageDialog(null, "Book not found!");
    } else {
        JOptionPane.showMessageDialog(null, "Book found at index: " + (index + 1));
    }
}


    private static void item4() {
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

    private static void item5() {
        JOptionPane.showMessageDialog(null, "Exiting the application...");
        System.exit(0);
    }
}
