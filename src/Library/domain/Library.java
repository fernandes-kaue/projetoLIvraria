package Library.domain;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // attributes
    public ArrayList<Book> books;

    // constructor
    public Library() {
        books = new ArrayList<>();
    }

    public String toString() {
        StringBuilder bookList = new StringBuilder();
        for (Book book : books) {
            bookList.append(book).append("\n");
        }
        return bookList.toString();
    }
}
