package Domain;

/**
 * @param title attributes
 */
public record Book(String title, String author, String ISBN) {
    // constructor

    // specific methods
    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

}
