package Repository;

import Domain.Book;
import Domain.Library;

import java.util.ArrayList;
import java.util.List;

public class Repository {

     static Library library;

    public Repository(Library library){
        Repository.library = new Library();
    }

    // specific methods
    public void removeBook(Book book) {
        library.books.remove(book);
    }

    public void removeBook(int index) {
        if (index < 0 || index >= library.books.size()) {
            System.out.println("Invalid index.");
        } else {
            library.books.remove(index);
        }
    }

    public void addBook(Book book) {
        library.books.add(book);
    }

    public void removeBook(String title) {
        library.books.removeIf(book -> book.getTitle().equals(title));
    }

    public int findBook(String title) {
        for (int i = 0; i < library.books.size(); i++) {
            if (library.books.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public List<String> listAllBooks() {
        List<String> bookList = new ArrayList<>();
        for (Book book : library.books) {
            bookList.add("Title: " + book.title() + ", Author: " + book.author() + ", ISBN: " + book.ISBN());
        }
        return bookList;
    }

    // Optional: Getter for the books list
    public List<Book> getBooks() {
        return library.books;
    }

}
