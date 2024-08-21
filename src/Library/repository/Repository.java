package Library.repository;

import Library.domain.Book;
import Library.domain.Library;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    static Library library;

    // specific methods
    public Repository(){
        library = new Library();
    }


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
    
    public Boolean isLibraryEmpty() {
        return library.books.isEmpty();
    }
    
    public String getBooklist(){
        if(isLibraryEmpty()){
            return "No books available.";
        } else {
            return library.toString();
        }
    }

    // Optional: Getter for the books list
    public List<Book> getBooks() {
        return library.books;
    }
}
