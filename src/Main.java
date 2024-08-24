import Domain.Library;
import Repository.Repository;

import java.awt.*;
import javax.swing.*;

public class Main {
    static Repository repository = new Repository(new Library());

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
            Repository.item1();
        });

        removeBook.addActionListener(e -> {
            scrollPane.setVisible(true);
            Repository.item2();
        });

        findBook.addActionListener(e -> {
            scrollPane.setVisible(true);
            Repository.item3();
        });

        listAllBooks.addActionListener(e -> {
            scrollPane.setVisible(true);
            Repository.item4();
        });

        exit.addActionListener(e -> {
            Repository.item5();
            System.exit(0);
        });

        // Set frame visibility
        frame.setVisible(true);
    }

}
