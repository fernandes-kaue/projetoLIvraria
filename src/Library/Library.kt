package Library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // attributes
    private ArrayList<Book> books;

    // constructor
    public Library() {
        books = new ArrayList<>();
    }

    // specific methods


    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeBook(int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("Invalid index.");
        } else {
            books.remove(index);
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    public int findBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public List<String> listAllBooks() {
        List<String> bookList = new ArrayList<>();
        for (Book book : books) {
            bookList.add("Title: " + book.title() + ", Author: " + book.author() + ", ISBN: " + book.ISBN());
        }
        return bookList;
    }

    // Optional: Getter for the books list
    public List<Book> getBooks() {
        return books;
    }
}
